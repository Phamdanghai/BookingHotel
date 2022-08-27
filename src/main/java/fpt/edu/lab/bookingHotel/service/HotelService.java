package fpt.edu.lab.bookingHotel.service;

import fpt.edu.lab.bookingHotel.entity.Hotel;
import fpt.edu.lab.bookingHotel.request.HotelRequest;
import fpt.edu.lab.bookingHotel.response.HotelResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {
    HotelResponse createHotel(HotelRequest hotelRequest);
    HotelResponse updateHotel(HotelRequest hotelRequest,Long id);
    List<Hotel> getAllHotel();
    boolean deleteHotel(Long id);
}
