package fpt.edu.lab.bookingHotel.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelResponse {

    private Long id;

    private String name;

    private String location;
}
