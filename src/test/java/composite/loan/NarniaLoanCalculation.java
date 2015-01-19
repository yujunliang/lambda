package composite.loan;


import algocraft.function.CompositeFunction;
import functions.atomic.*;

import static algocraft.function.Functions.conditional;
import static composite.FinancialInstrument.RATE_3;

public final class NarniaLoanCalculation extends CompositeFunction<Loan, Loan> {

    public NarniaLoanCalculation() {
        super(
            conditional(
                new IsFinancingApplicationFee<>(),
                new SetPrincipal<>(new AddApplicationFeeToPrincipal<>())
            ),
            new SetMonthlyPayment<>(new MonthlyLoanPayment<>()),
            conditional(
                new IsFirstTimeBuyer<Loan>().negate(),
                new SetStampDuty<>(new StampDutyOnMonthlyPayment<>(RATE_3))
            ),
            new SetFirstMonthPayment<>(new SumMonthlyPaymentAndStampDuty<>()),
            conditional(
                new IsFinancingApplicationFee<Loan>().negate(),
                new SetFirstMonthPayment<>(new AddApplicationFeeToFirstMonthPayment<>())
            )
        );
    }
}
