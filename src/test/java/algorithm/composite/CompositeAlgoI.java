package algorithm.composite;

import algocraft.algorithm.AbstractAlgorithm;
import algocraft.creation.Singleton;
import algorithm.atomic.Algo1;
import algorithm.atomic.Algo2;
import algorithm.atomic.Problem;

@Singleton
public final class CompositeAlgoI extends AbstractAlgorithm<Problem> {

	public CompositeAlgoI() {
		add(Algo1.class);
		add(Algo2.class);
	}
}
