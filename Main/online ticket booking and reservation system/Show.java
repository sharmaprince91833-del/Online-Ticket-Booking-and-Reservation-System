public class Show {

    private int id;
    private String name;
    private String date;
    private String time;

    public Show(int id, String name, String date, String time) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void display() {
        System.out.println(
            id + "  " + name + "  " + date + "  " + time
        );
    }
}