package ru.clevertec.dealer.config;

import lombok.Data;

@Data
public class DatabaseConfig {
    private String url;
    private String driverClassName;
    private String username;
    private String password;
}
