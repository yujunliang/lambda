package loan.composite;


import algocraft.algorithm.engine.AbstractFunction;
import loan.atomic.FirstMonthPaymentCalculation;
import loan.atomic.MonthlyPaymentCalculation;
import loan.atomic.StampDutyOnPrincipalCalculation;
import loan.domain.Loan;
import loan.domain.Rate;

public final class WonderlandCalculation extends AbstractFunction<Loan, Loan> {

    public WonderlandCalculation() {
        super(new MonthlyPaymentCalculation(),
              new StampDutyOnPrincipalCalculation(Rate.valueOf(0.03)),
              new FirstMonthPaymentCalculation()
        );
    }
}
