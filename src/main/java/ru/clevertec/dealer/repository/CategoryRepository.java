package ru.clevertec.dealer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.clevertec.dealer.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
