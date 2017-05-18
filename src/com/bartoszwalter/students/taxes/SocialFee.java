package com.bartoszwalter.students.taxes;

import java.math.BigDecimal;

/**
 * Created by krzysztof on 18/05/2017.
 */
public class SocialFee {

    private BigDecimal taxBase; // base - gainCost
    private BigDecimal gainCost = BigDecimal.valueOf(111.25);
    private BigDecimal advancePaymentForTax; // (base * 18) / 100
    private BigDecimal base;

    private BigDecimal pensionFee;
    private BigDecimal rentFee;
    private BigDecimal healthInsuranceFee;


    public SocialFee(BigDecimal income, GainCostType gainType) {
        pensionFee = income.multiply(BigDecimal.valueOf(9.76/100));
        rentFee = income.multiply(BigDecimal.valueOf(1.5/100));
        healthInsuranceFee = income.multiply(BigDecimal.valueOf(2.45/100));

        base = income.subtract(pensionFee).subtract(rentFee).subtract(healthInsuranceFee);

        if (gainType.equals(GainCostType.EXTENDED)) {
            gainCost = base.multiply(BigDecimal.valueOf(20)).divide(BigDecimal.valueOf(100));
        }

        taxBase = base.subtract(gainCost);
        advancePaymentForTax = taxBase.multiply(BigDecimal.valueOf(18)).divide(BigDecimal.valueOf(100));
    }

    public BigDecimal feesSum(){
        return pensionFee.add(rentFee).add(healthInsuranceFee);
    }

    public BigDecimal getTaxBase() {
        return taxBase;
    }

    public BigDecimal getGainCost() {
        return gainCost;
    }

    public BigDecimal getBase() {
        return base;
    }

    public BigDecimal getPensionFee() {
        return pensionFee;
    }

    public BigDecimal getRentFee() {
        return rentFee;
    }

    public BigDecimal getHealthInsuranceFee() {
        return healthInsuranceFee;
    }

    public BigDecimal getAdvancePaymentForTax() {
        return advancePaymentForTax;
    }
}
