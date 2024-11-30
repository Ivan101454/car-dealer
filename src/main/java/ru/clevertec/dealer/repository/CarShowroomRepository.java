package ru.clevertec.dealer.repository;

import org.hibernate.Session;
import ru.clevertec.dealer.entity.CarShowroom;

public class CarShowroomRepository extends RepositoryBase<Long, CarShowroom> {

    public CarShowroomRepository(Session session) {
        super(CarShowroom.class, session);
    }


}