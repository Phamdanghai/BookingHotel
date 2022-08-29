package fpt.edu.lab.bookingHotel.serviceImpl;

import fpt.edu.lab.bookingHotel.entity.Hotel;
import fpt.edu.lab.bookingHotel.exception.ForbiddenException;
import fpt.edu.lab.bookingHotel.exception.ResourceNotFoundException;
import fpt.edu.lab.bookingHotel.repository.HotelRepository;
import fpt.edu.lab.bookingHotel.request.HotelRequest;
import fpt.edu.lab.bookingHotel.response.HotelResponse;
import fpt.edu.lab.bookingHotel.service.HotelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {
	
	final
	HotelRepository hotelRepository;
	final
	ModelMapper modelMapper;

	public HotelServiceImpl(HotelRepository hotelRepository, ModelMapper modelMapper) {
		this.hotelRepository=hotelRepository;
		this.modelMapper=modelMapper;
	}

	@Override
	public HotelResponse createHotel(HotelRequest hotelRequest) {
		Hotel hotel = modelMapper.map(hotelRequest, Hotel.class);
		Optional<Hotel> optionalHotel = hotelRepository.findByName(hotelRequest.getName());
		if (optionalHotel.isPresent()) {
			throw new ResourceNotFoundException("Hotel is already existed. Please enter a different hotel");
		}
		hotel.setStatus(true);
		Hotel saveHotel = hotelRepository.save(hotel);
		return modelMapper.map(saveHotel, HotelResponse.class);
	}

	@Override
	public HotelResponse updateHotel(HotelRequest hotelRequest, Long id) {
		Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel not found"));
		Optional<Hotel> optionalHotel = hotelRepository.findByName(hotelRequest.getName());
		if(optionalHotel.isEmpty() || hotel.getName().equals(hotelRequest.getName()) ){
			modelMapper.map(hotelRequest, hotel);
			hotelRepository.save(hotel);
			return modelMapper.map(hotel, HotelResponse.class);
		}
		throw new ResourceNotFoundException("Hotel is already existed. Please enter a different hotel");
	}

	@Override
	public List<HotelResponse> getAllHotel() {
		List<Hotel> hotelList = hotelRepository.getAllHotelByStatus();
		if(hotelList.isEmpty()){
			throw new ResourceNotFoundException("Hotel not found");
		}
		List<HotelResponse> hotelResponseList = new ArrayList<>();
		hotelList.forEach(h -> hotelResponseList.add(modelMapper.map(h,HotelResponse.class)));
		return hotelResponseList;
//		return hotels.stream().map(HotelResponse::buildHotelResponse).collect(Collectors.toList());
	}

	@Override
	public boolean deleteHotel(Long id) {
		Hotel hotel = hotelRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Hotel not found"));
		if (!hotel.getStatus()){
			throw new ForbiddenException("Hotel already disable");
		}
		hotel.setStatus(false);
		hotelRepository.save(hotel);
		return true;
	}
}
