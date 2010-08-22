package loan.composite;


import algocraft.algorithm.engine.AbstractFunction;
import loan.atomic.FirstMonthPayment;
import loan.atomic.MonthlyPaymentCalculation;
import loan.atomic.StampDutyOnMonthlyPayment;
import loan.domain.Worksheet;

import java.math.BigDecimal;

public final class GondorCalculation extends AbstractFunction<Worksheet, Worksheet> {

    public GondorCalculation() {
        super(new MonthlyPaymentCalculation(),
              new StampDutyOnMonthlyPayment(new BigDecimal(0.02)),
              new FirstMonthPayment()
        );
    }
}
