package ru.clevertec.springmetric.springbootmetricstarter.configuration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


@AutoConfiguration
@EnableConfigurationProperties(PerformanceMonitorProperties.class)
@ConditionalOnProperty(prefix = "application.metric", name = "enabled", havingValue = "true")
public class PerformanceMonitorAutoConfiguration {

    @Bean
    public PerformanceMonitorAspect performanceMonitorAspect(PerformanceMonitorProperties performanceMonitorProperties) {
        return new PerformanceMonitorAspect(performanceMonitorProperties);
    }
}
