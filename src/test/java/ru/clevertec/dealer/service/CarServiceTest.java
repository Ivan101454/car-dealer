package ru.clevertec.dealer.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.clevertec.dealer.dto.CarDto;
import ru.clevertec.dealer.filter.CarParam;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarServiceTest {

    @Autowired
    private CarService carService;
//    private static Session session;

//    @BeforeAll
//    static void init() {
//        session = HibernateUtil.initDatabaseSession();
//        session.beginTransaction();
//        CarRepository carRepository = new CarRepository(session);
//        carService = new CarService(carRepository);
//    }

//    @AfterAll
//    static void close() {
//        session.getTransaction().rollback();
//    }


    @Test
    void findById() {
        Optional<CarDto> byId = carService.findById(11L);
        byId.ifPresent(car -> assertEquals("Octavia 3", car.carModel()));
//        byId.ifPresent(car -> assertEquals("Лозанж Lada", car.getCarShowroom().getNameOfShowroom()));
    }

    @Test
    void getCarsByFilter() {
        CarParam param = CarParam.builder().maxPrice(BigDecimal.valueOf(1000000)).isRequiredSort(true).isDescent(true).build();
        List<CarDto> cars = carService.getCarsByFilter(param, 1, 2);
        cars.forEach(System.out::println);
    }
}