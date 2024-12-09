package ru.clevertec.dealer.dto;

import java.math.BigDecimal;
import java.util.List;

public record CarDto(String carBrand, String carModel, int year, BigDecimal price,
                     CategoryDto categoryBody, CarShowroomDto carShowroom, List<ReviewDto> reviewsOnCar,
                     List<ClientDto> clients) {
}
