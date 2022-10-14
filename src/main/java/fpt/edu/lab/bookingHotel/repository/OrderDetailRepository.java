package fpt.edu.lab.bookingHotel.repository;

import fpt.edu.lab.bookingHotel.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
}
