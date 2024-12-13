package ru.clevertec.dealer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.clevertec.dealer.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
