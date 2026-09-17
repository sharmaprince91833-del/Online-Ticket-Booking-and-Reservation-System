public class CashPayment implements Payment {

    public boolean pay(double amount) {

        System.out.println("Payment of Rs. " + amount + " received.");

        return true;
    }
}