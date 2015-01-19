package composite.loan;


import algocraft.function.CompositeFunction;
import functions.atomic.*;

import static composite.FinancialInstrument.RATE_2;

public final class GondorLoanCalculation extends CompositeFunction<Loan, Loan> {

    public GondorLoanCalculation() {
        super(
            new SetMonthlyPayment<>(new MonthlyLoanPayment<>()),
            new SetStampDuty<>(new StampDutyOnMonthlyPayment<>(RATE_2)),
            new SetFirstMonthPayment<>(new SumMonthlyPaymentAndStampDuty<>())
        );
    }
}
