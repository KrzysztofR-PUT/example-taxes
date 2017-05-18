package com.bartoszwalter.students.taxes;

import java.math.BigDecimal;

/**
 * Created by krzysztof on 18/05/2017.
 */
public abstract class Contract {

    private BigDecimal income;
    private BigDecimal salary;
    private BigDecimal advancePaymentUS;
    private BigDecimal kwotaZmniejsz = BigDecimal.valueOf(46.33);


    private Fee fee;


    public Contract(BigDecimal income, GainCostType gainType) {
        this.income = income;
        fee = new Fee(income, gainType);
        calculateAdvancePayment();
        calculateSalary();
    }

    private void calculateAdvancePayment() {
        advancePaymentUS = fee.socialFee.getAdvancePaymentForTax().subtract(fee.insuranceFee.getHealthFee2()).subtract(kwotaZmniejsz);
    }

    protected void printContractData() {
        System.out.println("Podstawa wymiaru składek " + income);
        System.out.println("Składka na ubezpieczenie emerytalne " + fee.socialFee.getPensionFee());
        System.out.println("Składka na ubezpieczenie rentowe    " + fee.socialFee.getRentFee());
        System.out.println("Składka na ubezpieczenie chorobowe  " + fee.socialFee.getHealthInsuranceFee());
        System.out.println("Podstawa wymiaru składki na ubezpieczenie zdrowotne: " + fee.socialFee.getBase());
        System.out.println("Składka na ubezpieczenie zdrowotne: 9% = "+ fee.insuranceFee.getHealthFee1() +" 7,75% = " + fee.insuranceFee.getHealthFee2());
        System.out.println("Koszty uzyskania przychodu w stałej wysokości " + fee.socialFee.getGainCost());
        System.out.println("Podstawa opodatkowania " + fee.socialFee.getTaxBase());
        System.out.println("Zaliczka na podatek dochodowy 18 % = " + fee.socialFee.getAdvancePaymentForTax());
        System.out.println("Kwota wolna od podatku = " + kwotaZmniejsz);
        System.out.println("Zaliczka do urzędu skarbowego = " + advancePaymentUS);
        System.out.println("Pracownik otrzyma wynagrodzenie netto w wysokości = " + salary);
    }

    public void calculateSalary() {
        salary = fee.socialFee.getBase().subtract(fee.socialFee.feesSum().add(fee.insuranceFee.getHealthFee1()).add(advancePaymentUS));
    }

    public void printData() {}
}
