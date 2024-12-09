package ru.clevertec.dealer.dto;

import java.util.List;

public record CarShowroomDto(String nameOfShowroom, String addressOfShowroom, List<CarDto> carInStore) {
}
