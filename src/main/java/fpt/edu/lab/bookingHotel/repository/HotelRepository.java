package fpt.edu.lab.bookingHotel.repository;

import fpt.edu.lab.bookingHotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {
    @Query(value = "SELECT h.* from hotels h where h.name = :name and h.status = 1",nativeQuery = true)
    Optional<Hotel> findByName(String name);
    @Query(value = "SELECT h.* from hotels h where h.status = 1",nativeQuery = true)
    List<Hotel> getAllHotelByStatus();
}
