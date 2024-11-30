package ru.clevertec.dealer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewDto {
    private String textReview;
    private int rating;
    private ClientDto client;
    private CarDto car;
}
