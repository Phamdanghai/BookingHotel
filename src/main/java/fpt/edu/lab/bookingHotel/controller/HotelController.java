package fpt.edu.lab.bookingHotel.controller;

import fpt.edu.lab.bookingHotel.entity.Hotel;
import fpt.edu.lab.bookingHotel.request.HotelRequest;
import fpt.edu.lab.bookingHotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import fpt.edu.lab.bookingHotel.response.HotelResponse;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {
    @Autowired
    HotelService hotelService;

    @PostMapping
    HotelResponse createHotel(@Valid @RequestBody HotelRequest hotelRequest){
        return hotelService.createHotel(hotelRequest);
    }
    @PutMapping("/{id}")
    HotelResponse updateHotel(@Valid @RequestBody HotelRequest hotelRequest, @PathVariable Long id){
        return hotelService.updateHotel(hotelRequest,id);
    }

    @GetMapping
    List<Hotel> getAll(){
        return hotelService.getAllHotel();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable Long id){
        if(hotelService.deleteHotel(id)){
            return new ResponseEntity<>("DELETE SUCCESSFULLY", null, HttpStatus.OK);
        }
        return new ResponseEntity<>("DELETE SUCCESSFULLY", null, HttpStatus.BAD_REQUEST);
    }
}
