package fpt.edu.lab.bookingHotel.serviceImpl;

import fpt.edu.lab.bookingHotel.entity.KindOfRoom;
import fpt.edu.lab.bookingHotel.exception.ResourceNotFoundException;
import fpt.edu.lab.bookingHotel.repository.KindOfRoomRepository;
import fpt.edu.lab.bookingHotel.request.KindOfRoomRequest;
import fpt.edu.lab.bookingHotel.response.KindOfRoomResponse;
import fpt.edu.lab.bookingHotel.service.KindOfRoomService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KindOfRoomServiceImpl implements KindOfRoomService {
    final
    KindOfRoomRepository kindOfRoomRepository;
    final
    ModelMapper modelMapper;

    public KindOfRoomServiceImpl(KindOfRoomRepository kindOfRoomRepository, ModelMapper modelMapper) {
        this.kindOfRoomRepository = kindOfRoomRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public KindOfRoomResponse createKindOfRoom(KindOfRoomRequest kindOfRoomRequest) {
        KindOfRoom kindOfRoom = modelMapper.map(kindOfRoomRequest,KindOfRoom.class);
        Optional<KindOfRoom> optionalKindOfRoom = kindOfRoomRepository.findByName(kindOfRoomRequest.getName());
        if(optionalKindOfRoom.isPresent()){
            throw  new ResourceNotFoundException("KindOfRoom is already existed. Please enter a different KindOfRoom");
        }
        kindOfRoomRepository.save(kindOfRoom);
        return modelMapper.map(kindOfRoom,KindOfRoomResponse.class);
    }

    @Override
    public KindOfRoomResponse updateKindOfRoom(KindOfRoomRequest kindOfRoomRequest, Long id) {
        return null;
    }

    @Override
    public List<KindOfRoom> getAllKindOfRoom() {
        return null;
    }

    @Override
    public boolean deleteHotel(Long id) {
        return false;
    }
}
