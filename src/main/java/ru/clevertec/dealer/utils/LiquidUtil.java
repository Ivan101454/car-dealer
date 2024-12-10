package ru.clevertec.dealer.utils;

import liquibase.integration.spring.SpringLiquibase;
import lombok.experimental.UtilityClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

@UtilityClass
public class LiquidUtil {
    public static  void DmlDatabase(ClassPathXmlApplicationContext context) {
        DataSource dataSource = context.getBean(DataSource.class);
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:db/changelog/db.changelog-master.yaml");
        try {
            liquibase.afterPropertiesSet();
            System.out.println("Liquibase migration completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        context.close();
    }
}
