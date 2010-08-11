package algorithm.atomic;

import algocraft.algorithm.Solution;
import algocraft.creation.Singleton;
import domain.SubOutput1;

@Singleton
public final class Algo5 implements Solution<Problem> {

	@Override
	public void solve(final Problem problem) {
		for (SubOutput1 subOutput1 : problem.getOutput().getSubOutput1List()) {
			System.out.println(subOutput1);
		}

	}

}
