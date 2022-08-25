package fpt.edu.lab.bookingHotel.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "discounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int percents;

    private Date expiryDate;

    @OneToMany(mappedBy = "discount",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Order> orders;
}
