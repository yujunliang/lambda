package loan.composite;


import algocraft.algorithm.engine.AbstractFunction;
import loan.atomic.FirstTimeBuyerPredicate;
import loan.atomic.MonthlyPaymentCalculation;
import loan.atomic.StampDutyOnMonthlyPayment;
import loan.atomic.TotalCalculation;
import loan.domain.Worksheet;

import static algocraft.algorithm.engine.AlgorithmComposer.conditional;

public final class NarniaCalculation extends AbstractFunction<Worksheet, Worksheet> {

	public NarniaCalculation() {
        super(new TotalCalculation(),
              new MonthlyPaymentCalculation(),
              conditional(new FirstTimeBuyerPredicate(), new StampDutyOnMonthlyPayment()));
	}
}
