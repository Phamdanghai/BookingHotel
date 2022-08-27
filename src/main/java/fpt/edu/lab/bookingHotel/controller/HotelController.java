package fpt.edu.lab.bookingHotel.controller;

import fpt.edu.lab.bookingHotel.entity.Hotel;
import fpt.edu.lab.bookingHotel.request.HotelRequest;
import fpt.edu.lab.bookingHotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import fpt.edu.lab.bookingHotel.response.HotelResponse;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {
    @Autowired
    HotelService hotelService;

    @PostMapping("")
    HotelResponse createHotel(@Valid @RequestBody HotelRequest hotelRequest){
        return hotelService.createHotel(hotelRequest);
    }

    @GetMapping
    List<Hotel> getAll(){
        return hotelService.getAllHotel();
    }
}
