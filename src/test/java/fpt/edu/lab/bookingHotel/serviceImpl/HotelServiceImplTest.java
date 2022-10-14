package fpt.edu.lab.bookingHotel.serviceImpl;

import fpt.edu.lab.bookingHotel.entity.Hotel;
import fpt.edu.lab.bookingHotel.exception.ForbiddenException;
import fpt.edu.lab.bookingHotel.exception.ResourceNotFoundException;
import fpt.edu.lab.bookingHotel.repository.HotelRepository;
import fpt.edu.lab.bookingHotel.request.HotelRequest;
import fpt.edu.lab.bookingHotel.response.HotelResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HotelServiceImplTest {
    HotelServiceImpl hotelServiceImpl;
    HotelRepository hotelRepository;
    ModelMapper modelMapper;

    Hotel hotel;
    Hotel optionalHotel;
    Hotel expectedHotel;
    HotelRequest hotelRequest;
    HotelResponse hotelResponse;
    List<Hotel> hotelList;
    List<HotelResponse> hotelResponseList;

    @BeforeEach
    void BeforeEach(){

        hotelRepository = mock(HotelRepository.class);
        modelMapper = mock(ModelMapper.class);
        hotelServiceImpl = new HotelServiceImpl(hotelRepository,modelMapper);
        hotelRequest = mock(HotelRequest.class);
        hotelResponse = mock(HotelResponse.class);
        hotel = mock(Hotel.class);
        optionalHotel = mock(Hotel.class);
        expectedHotel = mock(Hotel.class);
        hotelList = mock(List.class);
        hotelResponseList = mock(ArrayList.class);
    }

    @Test
    void createHotel_ShouldReturnObject_WhenDataValid(){
        when(modelMapper.map(hotelRequest,Hotel.class)).thenReturn(hotel);
        when(hotelRepository.findByName("Test")).thenReturn(Optional.of(optionalHotel));
        when(hotel.getStatus()).thenReturn(true);
        when(hotelRepository.save(hotel)).thenReturn(expectedHotel);
        when(modelMapper.map(expectedHotel,HotelResponse.class)).thenReturn(hotelResponse);
        HotelResponse result = hotelServiceImpl.createHotel(hotelRequest);
        assertThat(result,is(hotelResponse));
    }
    @Test
    void createHotel_ShouldReturnException_WhenHotelIsPresent(){
        when(modelMapper.map(hotelRequest,Hotel.class)).thenReturn(hotel);
        when(hotelRepository.findByName(hotelRequest.getName())).thenReturn(Optional.of(optionalHotel));
//        when(Optional.of(optionalHotel).isPresent()).thenReturn(true);
        ResourceNotFoundException resourceNotFoundException = Assertions.assertThrows(ResourceNotFoundException.class,
                () -> hotelServiceImpl.createHotel(hotelRequest));
        assertThat(resourceNotFoundException.getMessage(),is("Hotel is already existed. Please enter a different hotel"));
    }

    @Test
    void updateHotel_ShouldReturnObject_WhenDataValid(){
        when(hotelRepository.findById(1L)).thenReturn(Optional.ofNullable(hotel));
        when(hotelRepository.findByName("Test")).thenReturn(Optional.of(optionalHotel));
        when(modelMapper.map(hotelRequest,Hotel.class)).thenReturn(hotel);
        when(hotelRepository.save(hotel)).thenReturn(hotel);
        when(modelMapper.map(hotel,HotelResponse.class)).thenReturn(hotelResponse);
        HotelResponse response = hotelServiceImpl.updateHotel(hotelRequest,1L);
        assertThat(response,is(hotelResponse));
    }

    @Test
    void updateHotel_ShouldReturnException_When(){
        when(hotelRepository.findById(1L)).thenReturn(Optional.empty());
        ResourceNotFoundException resourceNotFoundException = Assertions.assertThrows(ResourceNotFoundException.class,
                () -> hotelServiceImpl.updateHotel(hotelRequest,1L));
        assertThat(resourceNotFoundException.getMessage(),is("Hotel not found"));
    }

//    @Test
//    void updateHotel_ShouldReturnException(){
//        when(hotelRepository.findById(1L)).thenReturn(Optional.of(hotel));
//        when(hotelRepository.findByName(hotelRequest.getName())).thenReturn(Optional.of(optionalHotel));
//        ResourceNotFoundException resourceNotFoundException = Assertions.assertThrows(ResourceNotFoundException.class,
//                () -> hotelServiceImpl.updateHotel(hotelRequest,1L));
//        assertThat(resourceNotFoundException.getMessage(),is("Hotel is already existed. Please enter a different hotel"));
//    }

    @Test
    void deleteHotel_ShouldReturnObject_WhenDataValid(){
        when(hotelRepository.findById(1L)).thenReturn(Optional.of(hotel));
        when(hotel.getStatus()).thenReturn(true);
        boolean result= hotelServiceImpl.deleteHotel(1L);
        assertThat(result,is(true));
    }
    @Test
    void deleteHotel_ShouldReturnException_WhenStatusFalse(){
        when(hotelRepository.findById(1L)).thenReturn(Optional.of(hotel));
        when(hotel.getStatus()).thenReturn(false);
        ForbiddenException forbiddenException = Assertions.assertThrows(ForbiddenException.class,
        () -> hotelServiceImpl.deleteHotel(1L));
        assertThat(forbiddenException.getMessage(),is("Hotel already disable"));
    }

    @Test
    void deleteHotel_ShouldReturnException_WhenHotelEmpty(){
        when(hotelRepository.findById(1L)).thenReturn(Optional.empty());
        ResourceNotFoundException resourceNotFoundException = Assertions.assertThrows(ResourceNotFoundException.class,
                () -> hotelServiceImpl.deleteHotel(1L));
        assertThat(resourceNotFoundException.getMessage(),is("Hotel not found"));
    }

    @Test
    void getAllHotel_ShouldReturnListHotelResponse_WhenDataValid(){
        when(hotelRepository.getAllHotelByStatus()).thenReturn(hotelList);
        when(modelMapper.map(hotel,HotelResponse.class)).thenReturn(hotelResponse);
        List<HotelResponse> hotelResponses= hotelServiceImpl.getAllHotel();
        assertThat(hotelResponses.size(),is(hotelList.size()));
    }

    @Test
    void getAllHotel_ShouldReturnException_WhenHotelIsEmpty(){
        when(hotelRepository.getAllHotelByStatus()).thenReturn(hotelList);
        when(hotelList.isEmpty()).thenReturn(true);
        ResourceNotFoundException resourceNotFoundException = Assertions.assertThrows(ResourceNotFoundException.class,
                () -> hotelServiceImpl.getAllHotel());
        assertThat(resourceNotFoundException.getMessage(),is("Hotel not found"));
    }

}
