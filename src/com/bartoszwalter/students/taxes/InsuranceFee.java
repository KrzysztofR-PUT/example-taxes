package com.bartoszwalter.students.taxes;

import java.math.BigDecimal;

/**
 * Created by krzysztof on 18/05/2017.
 */
public class InsuranceFee {

    private BigDecimal healthFee1;
    private BigDecimal healthFee2;

    public InsuranceFee(BigDecimal base) {
        healthFee1 = base.multiply(BigDecimal.valueOf(9).divide(BigDecimal.valueOf(100)));
        healthFee2 = base.multiply(BigDecimal.valueOf(7.75)).divide(BigDecimal.valueOf(100));
    }

    public BigDecimal getHealthFee1() {
        return healthFee1;
    }

    public BigDecimal getHealthFee2() {
        return healthFee2;
    }
}
