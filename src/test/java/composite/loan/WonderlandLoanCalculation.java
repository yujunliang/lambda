package composite.loan;


import algocraft.function.CompositeFunction;
import functions.atomic.*;

import static functions.primitives.Rate.valueOf;

public final class WonderlandLoanCalculation extends CompositeFunction<Loan, Loan> {

    public WonderlandLoanCalculation() {
        super(
                new SetMonthlyPayment<Loan>(new MonthlyLoanPayment<Loan>()),
                new SetStampDuty<Loan>(new StampDutyOnPrincipal<Loan>(valueOf(0.03))),
                new SetFirstMonthPayment<Loan>(new SumMonthlyPaymentAndStampDuty<Loan>())
        );
    }
}
