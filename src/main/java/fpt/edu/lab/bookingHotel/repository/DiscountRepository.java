package fpt.edu.lab.bookingHotel.repository;

import fpt.edu.lab.bookingHotel.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount,Long> {
}
