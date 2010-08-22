package algorithm.composite;


import algocraft.algorithm.engine.AbstractFunction;
import algorithm.atomic.*;

import static algocraft.algorithm.engine.AlgorithmComposer.conditional;
import static com.google.common.base.Functions.compose;

public final class TopAlgoI2 extends AbstractFunction<Problem, Problem> {

	public TopAlgoI2() {
        super(new Algo0(),
              new Algo1(),
              conditional(new Condition2Predicate(),
                          compose(new Algo3(), new Algo4()),
                          new Algo5()
                         )
              );
	}
}
