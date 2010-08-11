package algorithm.composite;

import algocraft.algorithm.AbstractAlgorithm;
import algocraft.algorithm.Applicability;
import algocraft.creation.Singleton;
import algorithm.atomic.Algo3;
import algorithm.atomic.Algo4;
import algorithm.atomic.Problem;

@Singleton
public final class CompositeAlgoII extends AbstractAlgorithm<Problem> implements
		Applicability<Problem> {

	public CompositeAlgoII() {
		add(Algo3.class);
		add(Algo4.class);
	}

	@Override
	public boolean isApplicable(final Problem problem) {
		return problem.getInput().isCondition2();
	}

}

