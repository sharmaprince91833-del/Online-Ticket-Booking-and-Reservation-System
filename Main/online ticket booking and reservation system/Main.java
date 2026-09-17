import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookingSystem system = new BookingSystem();

        Customer currentUser = null;

        while (true) {

            System.out.println("\n==============================");
            System.out.println("     ONLINE TICKET BOOKING");
            System.out.println("==============================");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. View Shows");
            System.out.println("4. View Seats");
            System.out.println("5. Book Ticket");
            System.out.println("6. Cancel Ticket");
            System.out.println("7. Find Booking");
            System.out.println("8. View All Bookings");
            System.out.println("9. Test Concurrent Booking");
            System.out.println("10. Exit");

            System.out.print("Enter choice: ");

            int choice;

            try {

                choice = sc.nextInt();
                sc.nextLine();

            } catch (Exception e) {

                System.out.println("Please enter a number.");
                sc.nextLine();
                continue;
            }

            try {

                if (choice == 1) {

                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter password: ");
                    String password = sc.nextLine();

                    system.register(name, email, password);
                }

                else if (choice == 2) {

                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter password: ");
                    String password = sc.nextLine();

                    currentUser =
                        system.login(email, password);

                    System.out.println(
                        "Welcome " + currentUser.getName()
                    );
                }

                else if (choice == 3) {

                    system.displayShows();
                }

                else if (choice == 4) {

                    system.displaySeats();
                }

                else if (choice == 5) {

                    if (currentUser == null) {

                        System.out.println("Login first.");
                        continue;
                    }

                    system.displayShows();

                    System.out.print("Enter show ID: ");
                    int showId = sc.nextInt();

                    Show show = system.findShow(showId);

                    if (show == null) {

                        System.out.println("Show not found.");
                        continue;
                    }

                    system.displaySeats();

                    System.out.print("Enter seat number: ");
                    int seat = sc.nextInt();

                    Booking booking =
                        system.bookTicket(
                            currentUser, show, seat
                        );

                    System.out.println(
                        "\nTicket booked successfully!"
                    );

                    booking.display();
                }

                else if (choice == 6) {

                    if (currentUser == null) {

                        System.out.println("Login first.");
                        continue;
                    }

                    System.out.print("Enter booking ID: ");
                    sc.nextLine();
                    String id = sc.nextLine();

                    Booking booking =
                        system.findBooking(id);

                    if (booking == null) {

                        System.out.println("Booking not found.");
                    }

                    else if (
                        booking.getCustomer().getId()
                        != currentUser.getId()) {

                        System.out.println(
                            "You cannot cancel this booking."
                        );
                    }

                    else {

                        system.cancelBooking(id);
                    }
                }

                else if (choice == 7) {

                    System.out.print("Enter booking ID: ");
                    sc.nextLine();
                    String id = sc.nextLine();

                    Booking booking =
                        system.findBooking(id);

                    if (booking == null) {
                        System.out.println("Booking not found.");
                    }
                    else {
                        booking.display();
                    }
                }

                else if (choice == 8) {

                    system.displayBookings();
                }

                else if (choice == 9) {

                    testBooking(system);
                }

                else if (choice == 10) {

                    System.out.println("Thank you!");
                    break;
                }

                else {

                    System.out.println("Invalid choice.");
                }

            } catch (BookingException e) {

                System.out.println("Error: " + e.getMessage());

            } catch (Exception e) {

                System.out.println("Invalid input.");
                sc.nextLine();
            }
        }

        sc.close();
    }

    public static void testBooking(BookingSystem system) {

        System.out.println(
            "\nTwo users are trying to book Seat 20."
        );

        Customer c1 =
            new Customer(101, "Rahul",
                         "rahul@gmail.com", "1234");

        Customer c2 =
            new Customer(102, "Aman",
                         "aman@gmail.com", "1234");

        Show show = system.findShow(1);

        Thread t1 = new Thread(new Runnable() {

            public void run() {

                try {

                    system.bookTicket(c1, show, 20);
                    System.out.println("Rahul booked Seat 20.");

                } catch (BookingException e) {

                    System.out.println(
                        "Rahul: " + e.getMessage()
                    );
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            public void run() {

                try {

                    system.bookTicket(c2, show, 20);
                    System.out.println("Aman booked Seat 20.");

                } catch (BookingException e) {

                    System.out.println(
                        "Aman: " + e.getMessage()
                    );
                }
            }
        });

        t1.start();
        t2.start();

        try {

            t1.join();
            t2.join();

        } catch (InterruptedException e) {

            System.out.println("Thread interrupted.");
        }

        System.out.println("Concurrent booking test completed.");
    }
}