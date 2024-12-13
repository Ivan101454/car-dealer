package ru.clevertec.dealer.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

@NoArgsConstructor
@Data
@AutoConfiguration
@ConfigurationProperties(prefix = "page")
public class PageConfig {

    private int pageNumber;
    private int pageSize;
}
