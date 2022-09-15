import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Hotel {
    private String name;
    private List<Room> rooms;
    private Map<Room, Guest> guestList;

    public Hotel(String name) {
        this.name = name;
        this.rooms = new ArrayList<>(10);
        this.guestList = new LinkedHashMap<>(10);
    }

    public String addRooms(Room room) {
        this.rooms.add(room);
        return String.format("Added new room %s in hotel %s", room.getClass().getSimpleName(), name);
    }

    public String addGuest(Guest guest, String roomNumber) {
        Room room = rooms.stream().filter(r -> r.getNumber().equals(roomNumber)).findAny().orElse(null);
        guestList.put(room, guest);
        room.setAvailable(false);
        return String.format("%s added in room number %s", guest.getName(), roomNumber);
    }

    public String viewAvailableRooms() {
        List<Room> availableList = rooms.stream().filter(Room::isAvailable)
                .collect(Collectors.toList());

        if (availableList.size() == 0){
            return "No rooms available";
        }
        StringBuilder out = new StringBuilder();
        out.append(String.format("Available rooms in %s hotel:", name)).append(System.lineSeparator());
        for (Room room : availableList) {
            out.append("--Room number ").append(room.getNumber()).append(System.lineSeparator());
        }
        return out.toString();
    }


    public String getBill(String roomNumber) {
        Room room = rooms.stream().filter(r -> r.getNumber().equals(roomNumber)).findAny().orElse(null);
        Guest guest = guestList.get(room);
        guestList.remove(room);
        room.setAvailable(true);
        return String.format("Total bill for room %s: $%.2f", roomNumber,room.getPrice() * guest.getDaysOfStay());
    }

    public String guestInfo(){
        StringBuilder out = new StringBuilder();
        out.append(String.format("There are %d guests in %s hotel", guestList.size(), name)).append(System.lineSeparator());
        for (Map.Entry<Room, Guest> entry : guestList.entrySet()) {
            out.append(entry.getValue().getName()).append(", room number ");
            out.append(entry.getKey().getNumber()).append(", ").append(entry.getValue().getDaysOfStay()).append(" nights");
            out.append(System.lineSeparator());
        }
        return out.toString();
    }
}
