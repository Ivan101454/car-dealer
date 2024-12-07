package ru.clevertec;

import org.hibernate.Session;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.clevertec.dealer.dto.CarDto;
import ru.clevertec.dealer.filter.CarParam;
import ru.clevertec.dealer.service.CarService;
import ru.clevertec.dealer.utils.HibernateUtil;

import java.math.BigDecimal;
import java.util.Optional;


public class Main {

    public static void main(String[] args) {
//        Session session = HibernateUtil.initDatabaseSession();
        var context = new ClassPathXmlApplicationContext("application.xml");
        CarService bean = context.getBean(CarService.class);
        bean.findById(1L).ifPresent(System.out::println);
        CarParam param = CarParam.builder().maxPrice(BigDecimal.valueOf(1000000)).isRequiredSort(true).isDescent(true).build();
        bean.getCarsByFilter(param, 1, 2).forEach(System.out::println);
    }



}
