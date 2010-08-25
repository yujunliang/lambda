package loan.composite;


import algocraft.function.AbstractFunction;
import loan.atomic.*;
import loan.domain.Loan;

import static algocraft.function.Functions.conditional;
import static algocraft.function.Functions.compose;
import static com.google.common.base.Predicates.not;
import static loan.domain.Rate.valueOf;

public final class NarniaCalculation extends AbstractFunction<Loan, Loan> {

	public NarniaCalculation() {
        super(
              compose(
                   compose(
                        compose(
                             compose(conditional(BorrowLoanApplicationFeePredicate.INSTANCE, AddApplicationFeeToPrincipalCalculation.INSTANCE),
                                  MonthlyPaymentCalculation.INSTANCE
                             ),
                             conditional(not(FirstTimeBuyerPredicate.INSTANCE), new StampDutyOnMonthlyPaymentCalculation(valueOf(0.03)))
                        ),
                        FirstMonthPaymentCalculation.INSTANCE
                   ),
                   conditional(not(BorrowLoanApplicationFeePredicate.INSTANCE), AddApplicationFeeToFirstMonthPaymentCalculation.INSTANCE)
              )
        );
	}
}
