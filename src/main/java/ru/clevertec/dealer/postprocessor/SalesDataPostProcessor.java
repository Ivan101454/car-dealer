package ru.clevertec.dealer.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import ru.clevertec.dealer.config.PageConfig;
import ru.clevertec.dealer.service.CarService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

//@Component
public class SalesDataPostProcessor implements BeanPostProcessor {

    private PageConfig pageConfig;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof CarService) {
            CarService carService = (CarService) bean;
            SalesDataStatistic salesDataStatistic = new SalesDataStatistic();
            salesDataStatistic.setCarQuantity(carService.findAllCars(1, 10).size());
            salesDataStatistic.setCarOrdered(carService.findAllCars(1, 10).stream().filter(car -> !car.clients().isEmpty()).toList().size());
            salesDataStatistic.showStatistic();
        }
        return bean;
    }
}
