package problem2;

import algocraft.algorithm.AbstractAlgorithm;

public final class CompositeAlgoIProblem2 extends AbstractAlgorithm<Problem2>  {

	public CompositeAlgoIProblem2() {
		add(Algo0Problem2.class);
		add(Algo1Problem2.class);
	}
}
