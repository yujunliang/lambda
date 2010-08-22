package loan.composite;


import algocraft.algorithm.engine.AbstractFunction;
import loan.atomic.*;
import loan.domain.Worksheet;

import java.math.BigDecimal;

import static algocraft.algorithm.engine.AlgorithmComposer.conditional;

public final class NarniaCalculation extends AbstractFunction<Worksheet, Worksheet> {

	public NarniaCalculation() {
        super(conditional(new BorrowLoanApplicationFeePredicate(), new AddApplicationFeeToPrincipalCalculation()),
              new MonthlyPaymentCalculation(),
              conditional(new NotFirstTimeBuyerPredicate(), new StampDutyOnMonthlyPayment(new BigDecimal(0.03))),
              new FirstMonthPayment(),
              conditional(new PayLoanApplicationFeePredicate(), new AddApplicationFeeToFirstMonthPaymentCalculation())
             );
	}
}
