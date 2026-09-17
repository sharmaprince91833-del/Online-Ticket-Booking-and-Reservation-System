# Online Ticket Booking and Reservation System

## Project Overview

The Online Ticket Booking and Reservation System is a Java-based command-line application developed as a CSE2006 Programming in Java project.

The system allows users to register and login, view available shows and seats, book tickets, cancel bookings, and view booking records. It also demonstrates multithreading and synchronization by handling two users trying to book the same seat at the same time.

The project uses core Java concepts such as classes and objects, inheritance, interfaces, collections, exception handling, file handling, multithreading, and synchronization.

---

## Features

### 1. User Management
- New customer registration
- Email validation
- User login
- Password verification
- Customer details management

### 2. Show Management
- Display available shows
- Show ID, name, date and time
- Search show using Show ID

### 3. Seat Management
- Display available and booked seats
- Select a seat for booking
- Prevent booking of an already booked seat
- Cancel a seat when a booking is cancelled

### 4. Ticket Booking
- Select a show
- Select a seat
- Make payment
- Generate ticket
- Generate booking ID
- Display booking details

### 5. Booking Management
- Find booking using booking ID
- View all bookings
- Cancel booking
- Check booking status

### 6. File Handling
- Booking details are stored in a text file
- A `data` folder is created automatically when required
- Booking records are stored in `bookings.txt`

### 7. Concurrent Booking
- Two users can be simulated trying to book the same seat
- Multithreading is used for the simulation
- The `synchronized` method prevents both users from booking the same seat

---

## Technologies Used

- **Programming Language:** Java
- **JDK:** Java Development Kit
- **IDE:** Visual Studio Code
- **Version Control:** Git and GitHub
- **Storage:** Text File
- **Interface:** Command Line Interface (CLI)

---

## Java Concepts Used

The project demonstrates the following concepts from Programming in Java:

- Classes and Objects
- Constructors
- Encapsulation
- Inheritance
- Interfaces
- Polymorphism
- ArrayList
- Exception Handling
- Custom Exceptions
- File Handling
- Multithreading
- Synchronization
- Scanner for user input
- Method Overriding

---

## Functional Requirements

1. The system should allow a new customer to register.
2. The system should allow registered customers to login.
3. The system should display available shows.
4. The system should display seat availability.
5. The system should allow a logged-in customer to book a ticket.
6. The system should prevent booking of an already booked seat.
7. The system should generate a booking ID.
8. The system should allow customers to cancel their bookings.
9. The system should allow users to search for a booking.
10. The system should store booking information in a file.
11. The system should demonstrate concurrent booking using multiple threads.
12. The system should prevent two users from booking the same seat simultaneously.

---

## Non-Functional Requirements

### 1. Performance
The system should respond quickly to user commands and perform booking operations efficiently.

### 2. Reliability
The system should handle invalid inputs and booking errors without terminating unexpectedly.

### 3. Usability
The application provides a simple menu-based command-line interface that is easy to understand.

### 4. Security
Login credentials are checked before allowing access to booking operations.

### 5. Maintainability
The project is divided into multiple classes, making the code easier to understand and modify.

### 6. Error Handling
Custom exceptions are used to handle invalid bookings, incorrect login details, invalid seats, and missing bookings.

---

# 6. Instructions for Testing

1. Select Register and create a new user account.
2. Select Login and enter the registered email and password.
3. Select View Shows to check the available shows.
4. Select View Seats to check available and booked seats.
5. Select Book Ticket, choose a show and an available seat, and complete the payment.
6. Try booking an already booked seat to verify that duplicate booking is prevented.
7. Select Find Booking and enter the booking ID to check booking details.
8. Select Cancel Ticket and enter the booking ID to verify cancellation.
9. Select View All Bookings to check the booking records.
10. Select Test Concurrent Booking to verify that two threads attempting to book the same seat are handled using synchronization and only one booking succeeds.
11. Check data/bookings.txt to verify that booking information has been stored successfully.
