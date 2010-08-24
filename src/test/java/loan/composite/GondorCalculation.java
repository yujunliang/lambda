package loan.composite;


import algocraft.algorithm.engine.AbstractFunction;
import loan.atomic.FirstMonthPaymentCalculation;
import loan.atomic.MonthlyPaymentCalculation;
import loan.atomic.StampDutyOnMonthlyPaymentCalculation;
import loan.domain.Loan;
import loan.domain.Rate;

import java.math.BigDecimal;

public final class GondorCalculation extends AbstractFunction<Loan, Loan> {

    public GondorCalculation() {
        super(new MonthlyPaymentCalculation(),
              new StampDutyOnMonthlyPaymentCalculation(Rate.valueOf(0.02)),
              new FirstMonthPaymentCalculation()
        );
    }
}
