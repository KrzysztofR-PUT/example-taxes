package com.bartoszwalter.students.taxes;

import java.math.BigDecimal;

/**
 * Created by krzysztof on 18/05/2017.
 */
public class EmploymentContract extends Contract {

   public EmploymentContract(BigDecimal income) {
       super(income, GainCostType.STANDARD);
   }

   public void printData() {
       System.out.println("UMOWA O PRACĘ");
       printContractData();
   }
}
