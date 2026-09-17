import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public static void save(Booking booking) {

        try {

            File folder = new File("data");

            if (!folder.exists()) {
                folder.mkdir();
            }

            FileWriter file =
                new FileWriter("data/bookings.txt", true);

            file.write("\n------------------------\n");
            file.write("Booking ID : " + booking.getBookingId() + "\n");
            file.write("Customer   : "
                    + booking.getCustomer().getName() + "\n");
            file.write("Show       : "
                    + booking.getTicket().getShow().getName() + "\n");
            file.write("Seat       : "
                    + booking.getTicket().getSeatNumber() + "\n");
            file.write("Price      : Rs. "
                    + booking.getTicket().getPrice() + "\n");
            file.write("Status     : "
                    + booking.getStatus() + "\n");

            file.close();

        } catch (IOException e) {

            System.out.println("Error while saving booking.");
        }
    }
}