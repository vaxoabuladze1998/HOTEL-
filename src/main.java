import java.io.IOException;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {
        List<Hotel> hotelList;
        Filter filter = new Filter();
        hotelList = filter.filterHotels("საქართველო", "ბათუმი", 5, 70, "");
        for (Hotel hotel : hotelList) {
            System.out.println(hotel.getName());
            for (Room room : hotel.getRooms()) {
                System.out.println(room.getNumber());
                System.out.println(room.getType());
            }
        }
    }
}
