package com.bartoszwalter.students.taxes;

import java.math.BigDecimal;

/**
 * Created by krzysztof on 19/05/2017.
 */
public class FreelanceContract extends Contract{

    public FreelanceContract(BigDecimal income) {
        super(income, GainCostType.EXTENDED);
    }

    public void printData() {
        System.out.println("UMOWA-ZLECENIE");
        printContractData();
    }
}
