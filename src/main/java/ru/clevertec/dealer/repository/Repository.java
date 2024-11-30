package ru.clevertec.dealer.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<K, E> {

    E save(E entity);

    void delete(K id);

    void update(E entity);

    Optional<E> finById(K id);

    List<E> findAll();
}
