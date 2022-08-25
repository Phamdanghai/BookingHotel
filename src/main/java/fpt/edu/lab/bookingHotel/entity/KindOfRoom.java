package fpt.edu.lab.bookingHotel.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "kindOfRooms")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KindOfRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int amount;

    @OneToMany(mappedBy = "kindOfRooms",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Room> rooms;

}
