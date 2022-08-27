package fpt.edu.lab.bookingHotel.repository;

import fpt.edu.lab.bookingHotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {
    Optional<Hotel> findByName(String name);
}
