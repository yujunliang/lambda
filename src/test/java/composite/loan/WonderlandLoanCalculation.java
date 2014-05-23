package composite.loan;


import algocraft.function.CompositeFunction;
import functions.atomic.*;

import static composite.FinancialInstrument.RATE_3;

public final class WonderlandLoanCalculation extends CompositeFunction<Loan, Loan> {

    public WonderlandLoanCalculation() {
        super(
                new SetMonthlyPayment<>(new MonthlyLoanPayment<>()),
                new SetStampDuty<>(new StampDutyOnPrincipal<>(RATE_3)),
                new SetFirstMonthPayment<>(new SumMonthlyPaymentAndStampDuty<>())
        );
    }
}
