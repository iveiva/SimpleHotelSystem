public class Guest {
    private String name;
    private int daysOfStay;

    public Guest(String name, int daysOfStay) {
        this.name = name;
        this.daysOfStay = daysOfStay;
    }

    public String getName() {
        return name;
    }

    public int getDaysOfStay() {
        return daysOfStay;
    }
}
