package ru.clevertec.dealer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDto {
    private String carBrand;
    private String carModel;
    private int year;
    private BigDecimal price;
    private CategoryDto categoryBody;
    private CarShowroomDto carShowroom;
    private List<ReviewDto> reviewsOnCar;
    private List<ClientDto> clients;
}
