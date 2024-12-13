package ru.clevertec.dealer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.clevertec.dealer.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
