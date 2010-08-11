package algorithm.atomic;

import algocraft.algorithm.Solution;
import algocraft.creation.Singleton;
import domain.SubOutput2;

@Singleton
public final class Algo3 implements Solution<Problem> {

	@Override
	public void solve(final Problem problem) {
		final SubOutput2 subOutput = new SubOutput2();
		subOutput.setDate(problem.getInput().getDate1());
		problem.getOutput().setSubOutput2(subOutput);
	}
}
