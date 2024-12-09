package ru.clevertec.dealer.dto;

public record ReviewDto(String textReview, int rating, ClientDto client, CarDto car) {
}
