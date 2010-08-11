package algorithm.atomic;

import algocraft.algorithm.Solution;
import algocraft.creation.Singleton;
import algocraft.util.Stopwatch;
import domain.Output;
import domain.OutputType;

@Singleton
public final class Algo1 implements Solution<Problem> {

	@Override
	public void solve(final Problem problem) {
		Stopwatch.busyWork();
		final Output output = problem.getOutput();
		output.setType(OutputType.TYPE1);
	}
}
