package algorithm.atomic;

import algocraft.algorithm.Solution;
import algocraft.creation.Singleton;
import domain.SubOutput2;

@Singleton
public final class Algo4 implements Solution<Problem> {

	@Override
	public void solve(final Problem problem) {
		final SubOutput2 subOutput = problem.getOutput().getSubOutput2();
		subOutput.getDate().setTime(subOutput.getDate().getTime() + 6000);
	}
}
