public class Ticket {

    private static int ticketNumber = 1000;

    private int id;
    private Customer customer;
    private Show show;
    private int seatNumber;
    private double price;

    public Ticket(Customer customer, Show show,
                  int seatNumber, double price) {

        ticketNumber++;
        id = ticketNumber;

        this.customer = customer;
        this.show = show;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public Show getShow() {
        return show;
    }

    public double getPrice() {
        return price;
    }

    public void display() {

        System.out.println("Ticket ID : " + id);
        System.out.println("Customer  : " + customer.getName());
        System.out.println("Show      : " + show.getName());
        System.out.println("Seat      : " + seatNumber);
        System.out.println("Price     : Rs. " + price);
    }
}