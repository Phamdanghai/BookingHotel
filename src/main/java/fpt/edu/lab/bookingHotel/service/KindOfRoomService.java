package fpt.edu.lab.bookingHotel.service;

import fpt.edu.lab.bookingHotel.entity.KindOfRoom;
import fpt.edu.lab.bookingHotel.request.KindOfRoomRequest;
import fpt.edu.lab.bookingHotel.response.KindOfRoomResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KindOfRoomService {
    KindOfRoomResponse createKindOfRoom(KindOfRoomRequest kindOfRoomRequest);
    KindOfRoomResponse updateKindOfRoom(KindOfRoomRequest kindOfRoomRequest,Long id);
    List<KindOfRoom> getAllKindOfRoom();
    boolean deleteHotel(Long id);
}
