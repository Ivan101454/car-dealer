package ru.clevertec.springmetric.springbootmetricstarter.configuration;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@NoArgsConstructor
@Data
@ConfigurationProperties(prefix = "application.metric")
public class PerformanceMonitorProperties {

    private boolean enabled;
    private int minTimeExecute;
}
