import java.io.*;
import java.util.*;

//Class to represent a Hotel Room
class Room{
    int roomNumber;
    String category;
    double price;
    boolean isAvailable;

    public Room(int roomNumber,String category,double price){
        this.roomNumber=roomNumber;
        this.category=category;
        this.price=price;
        this.isAvailable=true; //All rooms are available by default

    }
    @Override
    public String toString(){
        String status;
        if(this.isAvailable==true){
            status="[Available]";
        }else{
            status="[Booked]";
        }

        return "Room: "+roomNumber+ " | "+"Category: "+category+ " | "+"Price ($): "+price+ " | "+status;
    }
}

public class HotelReservationSystem{
    private static ArrayList<Room> rooms=new ArrayList<>();
    private static final String FILE_NAME="reservation.txt";

    public static void main(String [] args){
        initializeRooms();
        Scanner input=new Scanner(System.in);

    while(true){
        System.out.println("\n     HOTEL RESERVATION SYSTEM     ");
        System.out.println("1.Search for available rooms.");
        System.out.println("2.Make a reservation.");
        System.out.println("3.View booking histroy (File)");
        System.out.println("4.Exit");
        System.out.print("Choose an option: ");

        if(!input.hasNextInt()){
                System.out.println("Please enter a valid number!");
                input.next(); 
                continue;
            }
        int choice=input.nextInt();
        input.nextLine();

        if(choice==4){
            System.out.println("Exiting system.");
            break;
        }
        switch(choice){
            case 1:
                displayAvailableRooms();
                break;
            case 2:
                processBooking(input);
                break;
            case 3:
                showHistoryFromFile();
                break;
            default:
                System.out.println("Invalid option.Please try again!");
        }
    }
    input.close();
  }

  //Step 1:Initialize some data for the hotel
  private static void initializeRooms(){
    rooms.add(new Room(101,"Standard",50.0));
    rooms.add(new Room(203,"Deluxe",110.5));
    rooms.add(new Room(205,"Deluxe",110.5));
    rooms.add(new Room(102,"Standard",50.0));
    rooms.add(new Room(305,"Suite",250.0));
  }

  //Step 2:Display only rooms where isAvailable is true
  private static void displayAvailableRooms(){
    System.out.println("\n   Available Rooms   ");
    for(Room r:rooms){
        if(r.isAvailable){
            System.out.println(r);
        }
     }
  }

  //Step 3:Handle dhe booking logic and simulation
  private static void processBooking(Scanner sc){
    displayAvailableRooms();
    System.out.print("\nEnter room number to book: ");
    int roomNum=sc.nextInt();
    sc.nextLine();

    System.out.print("Enter guest name: ");
    String guestName=sc.nextLine();

    boolean found=false;

    for(Room r: rooms){
        if(r.roomNumber==roomNum && r.isAvailable){
            r.isAvailable=false; //Mark as booked
            found=true;

    //Simulate payment and booking details
    String bookingDetail="Guest: "+guestName+ " | Room: "+roomNum+ " | Category: "+r.category+" | Paid ($): "+r.price;
    saveToFile(bookingDetail); //Save to file
    System.out.println("Success!Payment processed and room reserved.");
    break;
      }
    }
    if(!found){
        System.out.println("Room not found.");

    }
  }

  //Step 4:Save data using PrintWriter
  private static void saveToFile(String data){
    try{
        //FileOutputStream with 'true' allows appending data without overwriting
        PrintWriter writer=new PrintWriter(new FileOutputStream(new File(FILE_NAME),true));
        writer.println(data);
        writer.close();
    }catch (IOException e){
        System.out.println("Error saving to file: "+e.getMessage());
    }
  }

  //Step 5:Read data using Scanner
  private static void showHistoryFromFile(){
    System.out.println("\n   Booking History from File   ");
    File f=new File(FILE_NAME);

    if(!f.exists()){
        System.out.println("No reservation found yet.");
        return;
    }
    try{
        Scanner fileScanner=new Scanner(f);
        while(fileScanner.hasNextLine()){
            System.out.println(fileScanner.nextLine());
        }
        fileScanner.close();
    }catch (FileNotFoundException e){
        System.out.println("File not found.");
    }
  }
} 
