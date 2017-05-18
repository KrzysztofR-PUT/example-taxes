package com.bartoszwalter.students.taxes;

import java.math.BigDecimal;

/**
 * Created by krzysztof on 18/05/2017.
 */
public class Fee {
    public SocialFee socialFee;
    public InsuranceFee insuranceFee;

    public Fee(BigDecimal income, GainCostType gainType) {
        socialFee = new SocialFee(income, gainType);
        insuranceFee = new InsuranceFee(socialFee.getBase());
    }
}
