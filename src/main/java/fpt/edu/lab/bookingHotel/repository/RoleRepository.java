package fpt.edu.lab.bookingHotel.repository;

import fpt.edu.lab.bookingHotel.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
