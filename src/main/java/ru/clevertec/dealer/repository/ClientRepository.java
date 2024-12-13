package ru.clevertec.dealer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.clevertec.dealer.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
