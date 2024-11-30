package ru.clevertec.dealer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@ToString(exclude = {"categoryBody", "carShowroom", "reviewsOnCar", "clients"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "car", schema = "dealer")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long carId;
    private String carBrand;
    private String carModel;
    private int year;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categoryBody;
    @ManyToOne
    private CarShowroom carShowroom;
    @OneToMany(mappedBy = "car")
    private List<Review> reviewsOnCar;
    @ManyToMany
    @JoinTable(schema = "dealer",
            name = "car_client",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private List<Client> clients;

    public void addReviewOnCar(Review review) {
        review.setCar(this);
        reviewsOnCar.add(review);
    }
}
