package composite.loan;


import algocraft.function.CompositeFunction;
import functions.atomic.*;

import static algocraft.function.Functions.conditional;
import static composite.FinancialInstrument.RATE_3;

public final class NarniaLoanCalculation extends CompositeFunction<Loan, Loan> {

    public NarniaLoanCalculation() {
        super(
            conditional(
                new IsFinancingApplicationFee<Loan>(),
                new SetPrincipal<Loan>(new AddApplicationFeeToPrincipal<>())
            ),
            new SetMonthlyPayment<Loan>(new MonthlyLoanPayment<Loan>()),
            conditional(
                new IsFirstTimeBuyer<Loan>().negate(),
                new SetStampDuty<Loan>(new StampDutyOnMonthlyPayment<>(RATE_3))
            ),
            new SetFirstMonthPayment<Loan>(new SumMonthlyPaymentAndStampDuty<Loan>()),
            conditional(
                new IsFinancingApplicationFee<Loan>().negate(),
                new SetFirstMonthPayment<Loan>(new AddApplicationFeeToFirstMonthPayment<Loan>())
            )
        );
    }
}
