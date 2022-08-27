package fpt.edu.lab.bookingHotel.service;

import fpt.edu.lab.bookingHotel.entity.Hotel;
import fpt.edu.lab.bookingHotel.repository.HotelRepository;
import fpt.edu.lab.bookingHotel.request.HotelRequest;
import fpt.edu.lab.bookingHotel.response.HotelResponse;
import fpt.edu.lab.bookingHotel.serviceImpl.HotelServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HotelServiceImplTest {
    HotelServiceImpl hotelService;
    HotelRepository hotelRepository;
    ModelMapper modelMapper;

    Hotel hotel;

    Hotel oldHotel;
    Hotel expectedHotel;
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
        oldHotel = mock(Hotel.class);
        expectedHotel = mock(Hotel.class);
    }

    @Test
    void createHotel_ShouldReturnObject_WhenDataValid(){
        hotelRequest = new HotelRequest("hello", "HCM");
        when(modelMapper.map(hotelRequest,Hotel.class)).thenReturn(hotel);
//        when(hotelRepository.findByName(hotelRequest.getName())).thenReturn(Optional.of(oldHotel));
        when(hotelRepository.save(hotel)).thenReturn(expectedHotel);
        when(modelMapper.map(expectedHotel,HotelResponse.class)).thenReturn(hotelResponse);
        HotelResponse result ;
//        result = mock(HotelResponse.class);
        result =hotelService.createHotel(hotelRequest);

        assertThat(result,is(hotelResponse));
    }
}
