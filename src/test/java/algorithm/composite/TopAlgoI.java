package algorithm.composite;


import algocraft.algorithm.AbstractAlgorithm;
import algocraft.creation.Singleton;
import algorithm.atomic.Algo0;
import algorithm.atomic.Algo5;
import algorithm.atomic.Problem;

@Singleton
public final class TopAlgoI extends AbstractAlgorithm<Problem>{
	public TopAlgoI() {
		add(Algo0.class);
		add(CompositeAlgoI.class);
		add(CompositeAlgoII.class);
		add(Algo5.class);
	}
}
