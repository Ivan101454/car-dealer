package ru.clevertec.dealer.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.clevertec.dealer.entity.CarShowroom;

public interface CarShowroomRepository extends JpaRepository<CarShowroom, Long> {
}
