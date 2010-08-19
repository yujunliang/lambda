package amortization;


import algocraft.algorithm.engine.AbstractFunction;
import algocraft.algorithm.engine.AlgorithmComposer;
import algorithm.atomic.*;
import algorithm.composite.Condition2Predicate;

import static algocraft.algorithm.engine.AlgorithmComposer.conditional;
import static com.google.common.base.Functions.compose;

public final class NardiaCalculation extends AbstractFunction<Worksheet, Worksheet> {

	public NardiaCalculation() {
		super(compose( conditional(new StampDutyPredicate(), new StampDutyCalculation()),
                        compose( new MonthlyPaymentCalculation(),
                                 new TotalCalculation()))
        );
	}
}
