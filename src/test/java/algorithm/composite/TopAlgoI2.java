package algorithm.composite;


import algocraft.algorithm.AbstractAlgorithm;
import algocraft.creation.Singleton;
import algorithm.atomic.Algo0;
import algorithm.atomic.Algo1;
import algorithm.atomic.Algo5;
import algorithm.atomic.Problem;

@Singleton
public final class TopAlgoI2 extends AbstractAlgorithm<Problem>{
	public TopAlgoI2() {
		add(Algo0.class);
		add(Algo1.class);
		add(CompositeAlgoII.class);
		add(Algo5.class);
	}
}
