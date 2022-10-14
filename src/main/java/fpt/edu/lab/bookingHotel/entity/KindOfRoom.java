package fpt.edu.lab.bookingHotel.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "kind_of_rooms")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KindOfRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "kindOfRooms",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Room> rooms;

}
