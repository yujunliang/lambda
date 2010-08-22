package algorithm.composite;


import algocraft.algorithm.engine.AbstractFunction;
import algocraft.algorithm.engine.AlgorithmComposer;
import algorithm.atomic.*;

import static algocraft.algorithm.engine.AlgorithmComposer.conditional;
import static com.google.common.base.Functions.compose;

public final class TopAlgoI extends AbstractFunction<Problem, Problem> {

	public TopAlgoI() {
		super(
              new Algo0(),
              conditional(new Algo2Predicate(), new Algo2If(), new Algo2Else()),
              new Algo1(),
              conditional(new Condition2Predicate(), compose(new Algo4(), new Algo3()),
			  new Algo5()					)

        );
	}
}
