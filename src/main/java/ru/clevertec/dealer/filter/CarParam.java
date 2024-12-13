package ru.clevertec.dealer.filter;


import ru.clevertec.dealer.entity.Category;

import java.math.BigDecimal;

public record CarParam(String carBrand, int startDate, int endDate, BigDecimal minPrice, BigDecimal maxPrice,
                       Category categoryBody, boolean isRequiredSort, boolean isDescent) {
}
