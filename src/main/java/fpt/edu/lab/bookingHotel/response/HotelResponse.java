package fpt.edu.lab.bookingHotel.response;

import fpt.edu.lab.bookingHotel.entity.Hotel;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelResponse {

    private Long id;

    private String name;

    private String location;

    public static HotelResponse buildHotelResponse(Hotel hotel){
        return new HotelResponse(
                hotel.getId(),
                hotel.getName(),
                hotel.getLocation()
        );
    }
}
