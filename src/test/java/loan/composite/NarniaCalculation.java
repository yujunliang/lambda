package loan.composite;


import algocraft.algorithm.engine.AbstractFunction;
import loan.atomic.*;
import loan.domain.Worksheet;

import static algocraft.algorithm.engine.AlgorithmComposer.conditional;

public final class NarniaCalculation extends AbstractFunction<Worksheet, Worksheet> {

	public NarniaCalculation() {
        super(conditional(new BorrowLoanApplicationFeePredicate(), new AddApplicationFeeToPrincipalCalculation()),
              new MonthlyPaymentCalculation(),
              conditional(new FirstTimeBuyerPredicate(), new StampDutyOnMonthlyPayment()),
              new FirstMonthPayment(),
              conditional(new PayLoanApplicationFeePredicate(), new AddApplicationFeeToFirstMonthPaymentCalculation())
             );
	}
}
