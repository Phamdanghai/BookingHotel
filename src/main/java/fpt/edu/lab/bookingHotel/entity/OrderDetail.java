package fpt.edu.lab.bookingHotel.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    private int price;

    @ManyToOne
    @JoinColumn(name = "room_id",nullable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;

}
