package ru.clevertec;

import liquibase.integration.spring.SpringLiquibase;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.clevertec.dealer.utils.LuqidUtil;

import javax.sql.DataSource;


public class Main {

    public static void main(String[] args) {
//        Session session = HibernateUtil.initDatabaseSession();
        var context = new ClassPathXmlApplicationContext("application.xml");

        LuqidUtil.DmlDatabase(context);

//        DataSource dataSource = context.getBean(DataSource.class);
//        SpringLiquibase liquibase = new SpringLiquibase();
//        liquibase.setDataSource(dataSource);
//        liquibase.setChangeLog("classpath:db/changelog/db.changelog-master.yaml");
//        try {
//            liquibase.afterPropertiesSet();
//            System.out.println("Liquibase migration completed.");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        CarService bean = context.getBean(CarService.class);
//        bean.findById(1L).ifPresent(System.out::println);
//        CarParam param = CarParam.builder().maxPrice(BigDecimal.valueOf(1000000)).isRequiredSort(true).isDescent(true).build();
//        bean.getCarsByFilter(param, 1, 2).forEach(System.out::println);
    }


}
