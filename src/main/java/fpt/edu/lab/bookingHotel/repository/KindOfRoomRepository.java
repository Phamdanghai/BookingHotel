package fpt.edu.lab.bookingHotel.repository;

import fpt.edu.lab.bookingHotel.entity.KindOfRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KindOfRoomRepository extends JpaRepository<KindOfRoom,Long> {
    Optional<KindOfRoom> findByName(String name);
}
