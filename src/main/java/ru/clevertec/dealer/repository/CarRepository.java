package ru.clevertec.dealer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.clevertec.dealer.entity.Car;
import ru.clevertec.dealer.filter.CarParam;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

}
