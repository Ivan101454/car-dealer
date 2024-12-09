package ru.clevertec.dealer.dto;

import ru.clevertec.dealer.enums.Body;

import java.util.List;

public record CategoryDto(Body body, List<CarDto> listOfCar) {
}
