public class Customer extends User {

    public Customer(int id, String name, String email, String password) {
        super(id, name, email, password);
    }

    public void display() {
        System.out.println("Customer ID : " + getId());
        System.out.println("Name        : " + getName());
        System.out.println("Email       : " + getEmail());
    }
}