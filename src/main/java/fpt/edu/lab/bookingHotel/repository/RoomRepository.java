package fpt.edu.lab.bookingHotel.repository;

import fpt.edu.lab.bookingHotel.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
}
