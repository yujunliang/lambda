package loan.composite;


import algocraft.function.AbstractFunction;
import loan.atomic.FirstMonthPaymentCalculation;
import loan.atomic.MonthlyPaymentCalculation;
import loan.atomic.StampDutyOnPrincipalCalculation;
import loan.domain.Loan;

import static algocraft.function.Functions.left;
import static loan.domain.Rate.valueOf;

public final class WonderlandCalculation extends AbstractFunction<Loan, Loan> {

    public WonderlandCalculation() {
        super(
              left(
                   left(MonthlyPaymentCalculation.INSTANCE,
                        new StampDutyOnPrincipalCalculation(valueOf(0.03))
                   ),
                   FirstMonthPaymentCalculation.INSTANCE
              )
        );
    }
}
