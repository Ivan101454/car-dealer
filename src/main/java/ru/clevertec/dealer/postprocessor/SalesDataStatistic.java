package ru.clevertec.dealer.postprocessor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalesDataStatistic {
    private int carQuantity;
    private int carOrdered;
    private BigDecimal percentOfOrderedCar;

    public void showStatistic() {
        if(carQuantity != 0) {
            double percent = (double) carOrdered*100/carQuantity ;
            percentOfOrderedCar = new BigDecimal(percent).setScale(2, RoundingMode.HALF_UP);
            System.out.println("Процент зарезервированных машин = " + percentOfOrderedCar + "%");
        } else {
            System.out.println("На складе нет машин");
        }
    }
}
