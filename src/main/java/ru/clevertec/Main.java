package ru.clevertec;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.clevertec.dealer.utils.LiquidUtil;


public class Main {

    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("application.xml");

//  Инициализация БД
        LiquidUtil.DmlDatabase(context);


//        CarService bean = context.getBean(CarService.class);
//        bean.findById(1L).ifPresent(System.out::println);
//        CarParam param = CarParam.builder().maxPrice(BigDecimal.valueOf(1000000)).isRequiredSort(true).isDescent(true).build();
//        bean.getCarsByFilter(param, 1, 2).forEach(System.out::println);
    }


}
