package ru.clevertec.dealer.filter;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.clevertec.dealer.entity.Category;

import java.math.BigDecimal;

@Data
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
