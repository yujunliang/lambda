package loan.composite;


import algocraft.function.CompositeFunction;
import loan.atomic.*;
import loan.domain.Loan;

import static algocraft.function.Functions.conditional;
import static com.google.common.base.Predicates.not;
import static loan.primitives.Rate.valueOf;

public final class NarniaLoanCalculation extends CompositeFunction<Loan, Loan> {

	public NarniaLoanCalculation() {
        super(
              conditional(new BorrowLoanApplicationFeePredicate(), new SetPrincipal()),
              new SetMonthlyPayment(new MonthlyLoanPayment()),
              conditional(not(new FirstTimeBuyerPredicate()), new SetStampDuty(new StampDutyOnMonthlyPayment(valueOf(0.03)))),
              new SetFirstMonthPayment( new SumMonthlyPaymentAndStampDuty()),
              conditional(not(new BorrowLoanApplicationFeePredicate()),  new SetFirstMonthPayment( new AddApplicationFeeToFirstMonthPayment()))
        );
	}
}
