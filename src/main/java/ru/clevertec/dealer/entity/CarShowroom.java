package ru.clevertec.dealer.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@ToString(exclude = {"carInStore"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "car_showroom", schema = "dealer")
public class CarShowroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "showroom_id")
    private Long showroomId;
    @Column(name = "name_of_showroom")
    private String nameOfShowroom;
    @Column(name = "address_of_showroom")
    private String addressOfShowroom;
    @OneToMany(mappedBy = "carShowroom", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Car> carInStore;

    public void addCarToStore(Car car) {
        car.setCarShowroom(this);
        carInStore.add(car);
    }

}
