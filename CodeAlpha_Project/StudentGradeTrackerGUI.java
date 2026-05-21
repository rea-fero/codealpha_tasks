import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
/*Task 1:Student Grade Tracker
Developed for CodeAlpha internship.This programm allows user to input grades and
calculates the average,highest and lowest scores using Graphical User Interface.*/

public class StudentGradeTrackerGUI extends JFrame{

    //List to store student grades dynamically
    private ArrayList<Double> grades=new ArrayList<>();

    //UI components
    private JTextField gradeInput;
    private JTextArea displayArea;
    private JLabel avgLabel,maxLabel,minLabel;
    private JPanel inputPanel,statsPanel;
    private JButton addButton,resetButton;
    private JScrollPane scrollPane;

    public StudentGradeTrackerGUI(){
        //Initalize the frame settings
        setTitle("Student Grade Tracker");
        setSize(650,550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(15,15));

    // 1.Input section
    inputPanel=new JPanel(new FlowLayout());
    gradeInput=new JTextField(12);
    addButton=new JButton("Add Grade");
    resetButton = new JButton("Reset All");

    inputPanel.add(new JLabel("Enter grade:"));
    inputPanel.add(gradeInput);
    inputPanel.add(addButton);
    inputPanel.add(resetButton);

    // 2.Display section->List of grades
    displayArea=new JTextArea();
    displayArea.setEditable(false);
    displayArea.setFont(new Font("Monospaced",Font.PLAIN,12));
    scrollPane=new JScrollPane(displayArea);
    scrollPane.setBorder(BorderFactory.createTitledBorder("Registered Grades"));

    // 3.Results
    statsPanel=new JPanel(new GridLayout(3,1,5,5));
    statsPanel.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
    avgLabel=new JLabel("Average score:0.00");
    maxLabel=new JLabel("Highest score:0.00");
    minLabel=new JLabel("Lowest score:0.00");

    //Enhance label fonts
    Font labelFont=new Font("SansSerif",Font.BOLD,14);
    avgLabel.setFont(labelFont);
    maxLabel.setFont(labelFont);
    minLabel.setFont(labelFont);

    statsPanel.add(avgLabel);
    statsPanel.add(maxLabel);
    statsPanel.add(minLabel);

    // 4.Event Handling
    addButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            processInput();
        }
     });
    //Allow adding grades by pressing the 'Enter' key for better user experience
    gradeInput.addActionListener(e -> processInput());

    //Reset button logic to clear all data and reset the dashboard
    resetButton.addActionListener(e -> {
    grades.clear();
    displayArea.setText("");
    avgLabel.setText("Average score: 0.00");
    maxLabel.setText("Highest score: 0.00");
    minLabel.setText("Lowest score: 0.00");
});

    //Add components to the main frame
    add(inputPanel,BorderLayout.NORTH);
    add(scrollPane,BorderLayout.CENTER);
    add(statsPanel,BorderLayout.SOUTH);

    //Center the window on the screen
    setLocationRelativeTo(null);
    setVisible(true);

    }

    //Handles the input validation and updates the data list.
    private void processInput(){
        String rawInput=gradeInput.getText();
        try{
            double grade=Double.parseDouble(rawInput);

            //Validate grade range (0-100)
            if(grade>=0 && grade<=100){
                grades.add(grade);
                updateDashboard();
                gradeInput.setText(""); //Clear input field
            }else{
                JOptionPane.showMessageDialog(this,"Invalid range!Please enter a grade between 0 and 100",
                "Input Error",
                JOptionPane.ERROR_MESSAGE);
            }

        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this,"Invalid input!Please enter a numeric value.",
            "Type Error",
            JOptionPane.ERROR_MESSAGE);
        }
      }

      //Recalculates statistics and updates the UI components.
      private void updateDashboard(){
        //Clear the text area list.
        displayArea.setText("");
        double sum=0;
        for(int i=0;i<grades.size();i++){
            displayArea.append(String.format("Student %d:%.2f\n",(i+1),grades.get(i)));
            sum+=grades.get(i);
        }
        
        // Check if the list is not empty to avoid errors during calculations
        if(!grades.isEmpty()){ 
        //Perform calculations
        double average=sum/grades.size();
        double highest=Collections.max(grades);
        double lowest=Collections.min(grades);

        //Update UI labels with formatted results
        avgLabel.setText(String.format("Average Score: %.2f",average));
        maxLabel.setText(String.format("Highest Score: %.2f",highest));
        minLabel.setText(String.format("Lowest Score: %.2f",lowest));

      }
    }
      public static void main(String[] args){
        //Run the GUI on the Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(()->new StudentGradeTrackerGUI());
      }
    }


