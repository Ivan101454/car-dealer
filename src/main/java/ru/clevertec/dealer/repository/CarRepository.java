package ru.clevertec.dealer.repository;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import ru.clevertec.dealer.entity.Car;

public class CarRepository extends RepositoryBase<Long, Car> {

    public CarRepository(Session session) {
        super(Car.class, session);
    }

}
