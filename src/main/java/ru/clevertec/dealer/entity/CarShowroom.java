package ru.clevertec.dealer.entity;

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
    private String nameOfShowroom;
    private String addressOfShowroom;
    @OneToMany(mappedBy = "carShowroom", orphanRemoval = true)
    private List<Car> carInStore;

    public void addCarToStore(Car car) {
        carInStore.add(car);
    }
    private void deleteFromStore(Car car) {
        carInStore.remove(car);
    }

}
