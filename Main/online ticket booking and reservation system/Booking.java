public class Booking {

    private String bookingId;
    private Customer customer;
    private Ticket ticket;
    private String status;

    public Booking(String bookingId,
                   Customer customer,
                   Ticket ticket) {

        this.bookingId = bookingId;
        this.customer = customer;
        this.ticket = ticket;
        status = "CONFIRMED";
    }

    public String getBookingId() {
        return bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public String getStatus() {
        return status;
    }

    public void cancel() {
        status = "CANCELLED";
    }

    public void display() {

        System.out.println("\nBooking ID : " + bookingId);
        System.out.println("Customer   : " + customer.getName());
        System.out.println("Show       : " + ticket.getShow().getName());
        System.out.println("Seat       : " + ticket.getSeatNumber());
        System.out.println("Price      : Rs. " + ticket.getPrice());
        System.out.println("Status     : " + status);
    }
}
