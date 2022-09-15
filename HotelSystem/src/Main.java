import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Room room = new OneBed("001");
        Room room1 = new TwoBed("002");
        Hotel hotel = new Hotel("Paradise");
        System.out .println(hotel.addRooms(room));
        System.out.println(hotel.addRooms(room1));
        Guest guest = new Guest("John John", 3);
        System.out.println(hotel.addGuest(guest, "001"));
        System.out.println(hotel.viewAvailableRooms());
       // System.out.println(hotel.getBill("001"));
        Guest guest1 = new Guest("Ivelina Ivanova", 2);
        Room room2 = new TwoBed("003");
        hotel.addRooms(room2);
        System.out.println(hotel.addGuest(guest1, "003"));
        Guest guest2 = new Guest("Dara Tzankova", 4);
        hotel.addGuest(guest2, "002");
        System.out.println(hotel.guestInfo());
        System.out.println(hotel.viewAvailableRooms());
    }
}
