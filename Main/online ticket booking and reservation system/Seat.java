public class Seat {

    private int number;
    private boolean booked;

    public Seat(int number) {
        this.number = number;
        booked = false;
    }

    public int getNumber() {
        return number;
    }

    public boolean isBooked() {
        return booked;
    }

    public void book() {
        booked = true;
    }

    public void cancel() {
        booked = false;
    }

    public void display() {
        if (booked) {
            System.out.println("Seat " + number + " - Booked");
        } else {
            System.out.println("Seat " + number + " - Available");
        }
    }
}