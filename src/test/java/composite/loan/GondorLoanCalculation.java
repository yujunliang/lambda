package composite.loan;


import algocraft.function.CompositeFunction;
import composite.lease.Lease;
import functions.atomic.*;

import static functions.primitives.Rate.valueOf;

public final class GondorLoanCalculation extends CompositeFunction<Loan, Loan> {

    public GondorLoanCalculation() {
        super(
                new SetMonthlyPayment<Loan>(new MonthlyLoanPayment<Loan>()),
                new SetStampDuty<Loan>(new StampDutyOnMonthlyPayment<Loan>(valueOf(0.02))),
                new SetFirstMonthPayment<Loan>(new SumMonthlyPaymentAndStampDuty<Loan>())
        );
    }
}
