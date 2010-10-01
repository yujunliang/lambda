package composite.loan;


import algocraft.function.CompositeFunction;
import functions.atomic.*;

import static algocraft.function.Functions.conditional;
import static com.google.common.base.Predicates.not;
import static functions.primitives.Rate.valueOf;

public final class NarniaLoanCalculation extends CompositeFunction<Loan, Loan> {

    public NarniaLoanCalculation() {
        super(
                conditional(new FinanceApplicationFeePredicate<Loan>(),
                        new SetPrincipal(new AddApplicationFeeToPrincipal<Loan>())),
                new SetMonthlyPayment<Loan>(new MonthlyLoanPayment<Loan>()),
                conditional(not(new FirstTimeBuyerPredicate<Loan>()),
                        new SetStampDuty<Loan>(new StampDutyOnMonthlyPayment<Loan>(valueOf(0.03)))),
                new SetFirstMonthPayment<Loan>(new SumMonthlyPaymentAndStampDuty<Loan>()),
                conditional(not(new FinanceApplicationFeePredicate<Loan>()),
                        new SetFirstMonthPayment<Loan>(new AddApplicationFeeToFirstMonthPayment<Loan>()))
        );
    }
}
