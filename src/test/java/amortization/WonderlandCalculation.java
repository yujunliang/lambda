package amortization;


import algocraft.algorithm.engine.AbstractFunction;

import static algocraft.algorithm.engine.AlgorithmComposer.conditional;
import static com.google.common.base.Functions.compose;

public final class WonderlandCalculation extends AbstractFunction<Worksheet, Worksheet> {

	public WonderlandCalculation() {
		super(compose( new StampDutyCalculation(),
                        new MonthlyPaymentCalculation()
                                )
        );
	}
}
