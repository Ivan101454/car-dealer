package ru.clevertec.dealer.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DatabaseInit {

//    @Bean
//    public DatabaseConfig databaseConfig() {
//        YamlPropertiesFactoryBean yml = new YamlPropertiesFactoryBean();
//        yml.setResources(new ClassPathResource("application.yml"));
//        Properties properties = yml.getObject();
//
//        DatabaseConfig config = new DatabaseConfig();
//        config.setUrl(properties.getProperty("database.url"));
//        config.setDriverClassName(properties.getProperty("database.driver-class-name"));
//        config.setUsername(properties.getProperty("database.username"));
//        config.setPassword(properties.getProperty("database.password"));
//
//        return config;
//    }
    private static Properties getProperties() {
        YamlPropertiesFactoryBean yml = new YamlPropertiesFactoryBean();
        yml.setResources(new ClassPathResource("application.yml"));
        return yml.getObject();
    }

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(getProperties().getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(getProperties().getProperty("spring.datasource.url"));
        dataSource.setUsername(getProperties().getProperty("spring.datasource.username"));
        dataSource.setPassword(getProperties().getProperty("spring.datasource.password"));
        dataSource.setSchema("dealer");
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource);
        entityManagerFactory.setPackagesToScan("ru.clevertec.dealer");
        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.hbm2ddl.auto", getProperties().getProperty("spring.jpa.hibernate.ddl-auto"));
        jpaProperties.put("hibernate.dialect", getProperties().getProperty("spring.jpa.properties.hibernate.dialect"));
        entityManagerFactory.setJpaProperties(jpaProperties);
        return entityManagerFactory;
    }


    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}

