package loan;


import algocraft.algorithm.engine.AbstractFunction;

import static algocraft.algorithm.engine.AlgorithmComposer.conditional;

public final class NarniaCalculation extends AbstractFunction<Worksheet, Worksheet> {

	public NarniaCalculation() {
        super(new TotalCalculation(),
              new MonthlyPaymentCalculation(),
              conditional(new FirstTimeBuyerPredicate(), new StampDutyOnMonthlyPayment()));
	}
}
