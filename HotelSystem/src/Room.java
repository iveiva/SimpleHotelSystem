public abstract class Room {
    private String number;
    private boolean isAvailable;
    private double price;

    public Room(String number, double price) {
        this.number = number;
        this.isAvailable = true;
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public double getPrice() {
        return price;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
