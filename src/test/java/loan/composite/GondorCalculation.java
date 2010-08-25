package loan.composite;


import algocraft.function.AbstractFunction;
import loan.atomic.FirstMonthPaymentCalculation;
import loan.atomic.MonthlyPaymentCalculation;
import loan.atomic.StampDutyOnMonthlyPaymentCalculation;
import loan.domain.Loan;

import static algocraft.function.Functions.compose;
import static loan.domain.Rate.valueOf;

public final class GondorCalculation extends AbstractFunction<Loan, Loan> {

    public GondorCalculation() {
        super(compose(
              MonthlyPaymentCalculation.INSTANCE,
              new StampDutyOnMonthlyPaymentCalculation(valueOf(0.02)),
              FirstMonthPaymentCalculation.INSTANCE
        ));
    }
}
