package algorithm.composite;

import algocraft.algorithm.AbstractAlgorithm;
import algocraft.creation.Singleton;
import algorithm.atomic.Algo3;
import algorithm.atomic.Algo4;
import algorithm.atomic.Problem;
import com.google.common.base.Predicate;

@Singleton
public final class CompositeAlgoII extends AbstractAlgorithm<Problem> implements
		Predicate<Problem> {

	public CompositeAlgoII() {
		add(Algo3.class);
		add(Algo4.class);
	}

	@Override
	public boolean apply(final Problem problem) {
		return problem.getInput().isCondition2();
	}

}

