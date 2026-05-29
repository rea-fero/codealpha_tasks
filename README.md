# CodeAlpha_Internship

This repository serves as a documentation of the projects I am developing during my Java Programming internship at CodeAlpha.

📁 Projects Overview

***1.Student Grade Tracker (Task 1)***

For this first task, I built a desktop application that helps teachers or administrators track student performance. Instead of a simple console-based program, I decided to implement a Graphical User Interface (GUI) using Java Swing to make it more interactive and practical.

What I focused on:

Data Management: Using ArrayList to handle grades dynamically so there is no limit to how many students can be added.

Logical Operations: Implementing the Collections framework to efficiently find the highest and lowest scores, along with basic math for the average.

User Experience: Added input validation to prevent the program from crashing if someone enters text instead of numbers or values outside the 0-100 range. I also added support for the "Enter" key and a "Reset" button for better workflow.

Files: * StudentGradeTrackerGUI.java: The main source code containing the UI logic and calculation methods.

🛠️ How to run the code

If you want to test the Grade Tracker locally:

Compile the file:

javac CodeAlpha_Project/StudentGradeTrackerGUI.java

Run the application:

java StudentGradeTrackerGUI



***2.Hotel Reservation System (Task 2)***

For this second task, I built a console program that works like a hotel booking system.It allows users to search for rooms, make a booking, and save the information for later.

What I focused on:

Organizing Data:I created a Room class to hold information like the room number, type (Standard, Deluxe, Suite), and price.

Saving Information:I used PrintWriter so that every time a guest books a room, the details are saved in a file called reservation.txt.This way, the data is not lost when the program closes.

Booking Logic:The system shows only the rooms that are free.It also updates the room status to "Booked" immediately after a successful reservation.

Reading Files:I used a Scanner to read the reservation.txt file, which allows the user to see the full history of all bookings made in the past.

Files: * HotelReservationSystem.java: The main code that runs the menu and handles the booking steps.

reservation.txt: A simple text file used to store the booking details.

🛠️ How to run the code

Compile the file:

javac CodeAlpha_Project/HotelReservationSystem.java

Run the application:

java HotelReservationSystem

Intern: Rea Fero

Organization: CodeAlpha
