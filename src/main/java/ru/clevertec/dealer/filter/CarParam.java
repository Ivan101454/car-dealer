package ru.clevertec.dealer.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.clevertec.dealer.entity.Category;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class CarParam {

    private String carBrand;
    private int startDate;
    private int endDate;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Category categoryBody;
    private boolean isRequiredSort;
    private boolean isDescent;
}
