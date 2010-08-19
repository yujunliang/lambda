package algorithm.composite;


import algocraft.algorithm.engine.AbstractFunction;
import algocraft.algorithm.engine.AlgorithmComposer;
import algorithm.atomic.*;

import static com.google.common.base.Functions.compose;

public final class TopAlgoI extends AbstractFunction<Problem, Problem> {

	public TopAlgoI() {
		super(compose(new Algo5(),
				compose( AlgorithmComposer.conditional(new Condition2Predicate(), compose(new Algo4(), new Algo3())),
						compose(compose(new Algo1(), AlgorithmComposer.conditional(new Algo2Predicate(), new Algo2If(), new Algo2Else())),
								new Algo0())))
        );
	}
}
