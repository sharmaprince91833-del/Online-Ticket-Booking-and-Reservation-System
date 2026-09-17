import java.util.ArrayList;

public class BookingSystem {

    private ArrayList<Customer> customers;
    private ArrayList<Show> shows;
    private ArrayList<Seat> seats;
    private ArrayList<Booking> bookings;

    private int userNumber = 1;
    private int bookingNumber = 1;

    public BookingSystem() {

        customers = new ArrayList<>();
        shows = new ArrayList<>();
        seats = new ArrayList<>();
        bookings = new ArrayList<>();

        shows.add(new Show(
            1, "Avengers", "20-09-2026", "6:00 PM"
        ));

        shows.add(new Show(
            2, "Interstellar", "21-09-2026", "7:00 PM"
        ));

        shows.add(new Show(
            3, "Inception", "22-09-2026", "5:30 PM"
        ));

        for (int i = 1; i <= 20; i++) {
            seats.add(new Seat(i));
        }
    }

    public void register(String name, String email, String password)
            throws BookingException {

        if (name.trim().isEmpty() ||
            email.trim().isEmpty() ||
            password.trim().isEmpty()) {

            throw new BookingException("All fields are required.");
        }

        for (Customer c : customers) {

            if (c.getEmail().equalsIgnoreCase(email)) {
                throw new BookingException("Email already registered.");
            }
        }

        Customer customer = new Customer(
            userNumber, name, email, password
        );

        userNumber++;
        customers.add(customer);

        System.out.println("Registration successful.");
    }

    public Customer login(String email, String password)
            throws BookingException {

        for (Customer c : customers) {

            if (c.getEmail().equalsIgnoreCase(email) &&
                c.checkPassword(password)) {

                return c;
            }
        }

        throw new BookingException("Wrong email or password.");
    }

    public void displayShows() {

        System.out.println("\nID   Show          Date          Time");
        System.out.println("----------------------------------------");

        for (Show s : shows) {
            s.display();
        }
    }

    public Show findShow(int id) {

        for (Show s : shows) {

            if (s.getId() == id) {
                return s;
            }
        }

        return null;
    }

    public void displaySeats() {

        System.out.println("\nSeat Availability");

        for (Seat s : seats) {
            s.display();
        }
    }

    public synchronized Booking bookTicket(
            Customer customer,
            Show show,
            int seatNumber)
            throws BookingException {

        Seat selectedSeat = null;

        for (Seat s : seats) {

            if (s.getNumber() == seatNumber) {
                selectedSeat = s;
                break;
            }
        }

        if (selectedSeat == null) {
            throw new BookingException("Seat does not exist.");
        }

        if (selectedSeat.isBooked()) {
            throw new BookingException(
                "Seat " + seatNumber + " is already booked."
            );
        }

        selectedSeat.book();

        double price = 250;

        Payment payment = new CashPayment();

        if (!payment.pay(price)) {

            selectedSeat.cancel();

            throw new BookingException("Payment failed.");
        }

        Ticket ticket = new Ticket(
            customer, show, seatNumber, price
        );

        String id = "B" + bookingNumber;
        bookingNumber++;

        Booking booking = new Booking(
            id, customer, ticket
        );

        bookings.add(booking);

        FileManager.save(booking);

        return booking;
    }

    public synchronized void cancelBooking(String id)
            throws BookingException {

        Booking booking = findBooking(id);

        if (booking == null) {
            throw new BookingException("Booking not found.");
        }

        if (booking.getStatus().equals("CANCELLED")) {
            throw new BookingException(
                "Booking is already cancelled."
            );
        }

        int seatNumber =
            booking.getTicket().getSeatNumber();

        for (Seat s : seats) {

            if (s.getNumber() == seatNumber) {
                s.cancel();
                break;
            }
        }

        booking.cancel();

        System.out.println("Booking cancelled successfully.");
    }

    public Booking findBooking(String id) {

        for (Booking b : bookings) {

            if (b.getBookingId().equalsIgnoreCase(id)) {
                return b;
            }
        }

        return null;
    }

    public void displayBookings() {

        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }

        for (Booking b : bookings) {
            b.display();
        }
    }
}