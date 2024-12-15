package ru.clevertec.spingbootmetricstarter.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties(PerformanceMonitorProperties.class)
@ConditionalOnProperty(prefix = "application.metric", name = "enabled", havingValue = "true")
public class PerformanceMonitorAutoConfiguration {

    @Bean
    public PerformanceMonitorAspect performanceMonitorAspect(PerformanceMonitorProperties performanceMonitorProperties) {
        return new PerformanceMonitorAspect(performanceMonitorProperties);
    }
}
