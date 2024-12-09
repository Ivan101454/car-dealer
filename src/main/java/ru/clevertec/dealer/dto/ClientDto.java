package ru.clevertec.dealer.dto;

import java.time.LocalDate;
import java.util.List;


public record ClientDto(String nameOfCustomer, List<String> contacts, LocalDate dateOfRegistration,
                        List<CarDto> cars, List<ReviewDto> reviewOnCar) {
}
