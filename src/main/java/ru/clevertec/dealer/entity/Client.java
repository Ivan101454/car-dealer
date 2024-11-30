package ru.clevertec.dealer.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@ToString(exclude = {"cars", "reviewOnCar"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "client", schema = "dealer")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long clientId;
    private String nameOfCustomer;
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "contact", joinColumns = @JoinColumn(name = "client_id"), schema = "dealer")
    private List<String> contacts;
    private LocalDate dateOfRegistration;
    @ManyToMany(mappedBy = "clients", cascade = CascadeType.ALL)
    private List<Car> cars;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviewOnCar;

    public void buyACar(Car car) {
        cars.add(car);
    }

    private void addReview(Review review, Car car, String text, int rating) {
        review.setCar(car);
        review.setRating(rating);
        review.setTextReview(text);
        reviewOnCar.add(review);
    }
}
