package composite.loan;


import algocraft.function.CompositeFunction;
import functions.atomic.*;

import static algocraft.function.Functions.conditional;
import static com.google.common.base.Predicates.not;
import static functions.primitives.Rate.valueOf;

public final class NarniaLoanCalculation extends CompositeFunction<Loan, Loan> {

    public NarniaLoanCalculation() {
        super(
                conditional(new FinanceApplicationFeePredicate(),
                        new SetPrincipal(new AddApplicationFeeToPrincipal())),
                new SetMonthlyPayment(new MonthlyLoanPayment()),
                conditional(not(new FirstTimeBuyerPredicate()),
                        new SetStampDuty(new StampDutyOnMonthlyPayment(valueOf(0.03)))),
                new SetFirstMonthPayment(new SumMonthlyPaymentAndStampDuty()),
                conditional(not(new FinanceApplicationFeePredicate()),
                        new SetFirstMonthPayment(new AddApplicationFeeToFirstMonthPayment()))
        );
    }
}
