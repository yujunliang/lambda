package loan.composite;


import algocraft.algorithm.engine.AbstractFunction;
import loan.atomic.*;
import loan.domain.Loan;
import loan.domain.Rate;

import static algocraft.algorithm.engine.Functions.conditional;
import static algocraft.algorithm.engine.Functions.left;
import static loan.domain.Rate.valueOf;

public final class NarniaCalculation extends AbstractFunction<Loan, Loan> {

	public NarniaCalculation() {
        super(
              left(
                   left(
                        left(
                             left(conditional(BorrowLoanApplicationFeePredicate.INSTANCE, AddApplicationFeeToPrincipalCalculation.INSTANCE),
                                  MonthlyPaymentCalculation.INSTANCE
                             ),
                             conditional(NotFirstTimeBuyerPredicate.INSTANCE, new StampDutyOnMonthlyPaymentCalculation(valueOf(0.03)))
                        ),
                        FirstMonthPaymentCalculation.INSTANCE
                   ),
                   conditional(PayLoanApplicationFeePredicate.INSTANCE, AddApplicationFeeToFirstMonthPaymentCalculation.INSTANCE)
              )
        );
	}
}
