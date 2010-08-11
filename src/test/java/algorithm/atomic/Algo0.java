package algorithm.atomic;

import java.util.ArrayList;

import algocraft.algorithm.Solution;
import algocraft.creation.Singleton;
import domain.Output;
import domain.SubOutput1;

@Singleton
public final class Algo0 implements Solution<Problem> {

	@Override
	public void solve(final Problem problem) {
		final Output output = problem.getOutput();
		final ArrayList<SubOutput1> list = new ArrayList<SubOutput1>();
		output.setSubOutput1List(list);
	}
}
