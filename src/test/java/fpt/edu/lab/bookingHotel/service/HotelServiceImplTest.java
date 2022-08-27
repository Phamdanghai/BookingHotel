package fpt.edu.lab.bookingHotel.service;

import fpt.edu.lab.bookingHotel.entity.Hotel;
import fpt.edu.lab.bookingHotel.repository.HotelRepository;
import fpt.edu.lab.bookingHotel.request.HotelRequest;
import fpt.edu.lab.bookingHotel.response.HotelResponse;
import fpt.edu.lab.bookingHotel.serviceImpl.HotelServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.modelmapper.ModelMapper;

import static org.mockito.Mockito.mock;

public class HotelServiceImplTest {
    HotelServiceImpl hotelService;
    HotelRepository hotelRepository;
    ModelMapper modelMapper;

    Hotel hotel;

    HotelRequest hotelRequest;

    HotelResponse hotelResponse;

    @BeforeEach
    void BeforeEach(){

        hotelRepository = mock(HotelRepository.class);
        modelMapper = mock(ModelMapper.class);
        hotelService = new HotelServiceImpl(hotelRepository,modelMapper);
        hotelRequest = mock(HotelRequest.class);
        hotelResponse = mock(HotelResponse.class);
        hotel = mock(Hotel.class);
    }
}
