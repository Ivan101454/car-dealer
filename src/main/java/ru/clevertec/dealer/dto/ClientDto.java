package ru.clevertec.dealer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDto {

    private String nameOfCustomer;
    private List<String> contacts;
    private LocalDate dateOfRegistration;
    private List<CarDto> cars;
    private List<ReviewDto> reviewOnCar;
}
