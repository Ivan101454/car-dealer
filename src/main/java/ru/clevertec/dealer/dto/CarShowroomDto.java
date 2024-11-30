package ru.clevertec.dealer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarShowroomDto {

    private String nameOfShowroom;
    private String addressOfShowroom;
    private List<CarDto> carInStore;
}
