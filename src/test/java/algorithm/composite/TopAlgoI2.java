package algorithm.composite;


import algocraft.algorithm.engine.AlgorithmComposer;
import algorithm.atomic.*;
import com.google.common.base.Function;

import static com.google.common.base.Functions.compose;

public final class TopAlgoI2 implements Function<Problem, Problem> {
	private Function<Problem,Problem> topAlgorithm;

	public TopAlgoI2() {
		Function<Problem,Problem> compositeAlgo1 = compose(new Algo1(), AlgorithmComposer.conditional(new Algo2Predicate(), new Algo2If(), new Algo2Else()));
		Function<Problem, Problem> compositeAlgo2 = AlgorithmComposer.conditional(new Condition2Predicate(), compose(new Algo3(), new Algo4()));

		topAlgorithm = compose(new Algo5(),
								compose(compositeAlgo2,
										compose(new Algo1(),
												new Algo0())));
	}


	@Override
	public Problem apply(Problem from) {
		return topAlgorithm.apply(from);
	}

}
