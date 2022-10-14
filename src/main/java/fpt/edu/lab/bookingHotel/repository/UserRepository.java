package fpt.edu.lab.bookingHotel.repository;

import fpt.edu.lab.bookingHotel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
