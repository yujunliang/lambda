package loan.composite;


import algocraft.algorithm.engine.AbstractFunction;
import loan.atomic.*;
import loan.domain.Loan;
import loan.domain.Rate;

import java.math.BigDecimal;

import static algocraft.algorithm.engine.AlgorithmComposer.conditional;

public final class NarniaCalculation extends AbstractFunction<Loan, Loan> {

	public NarniaCalculation() {
        super(conditional(new BorrowLoanApplicationFeePredicate(), new AddApplicationFeeToPrincipalCalculation()),
              new MonthlyPaymentCalculation(),
              conditional(new NotFirstTimeBuyerPredicate(), new StampDutyOnMonthlyPaymentCalculation(Rate.valueOf(0.03))),
              new FirstMonthPaymentCalculation(),
              conditional(new PayLoanApplicationFeePredicate(), new AddApplicationFeeToFirstMonthPaymentCalculation())
             );
	}
}
