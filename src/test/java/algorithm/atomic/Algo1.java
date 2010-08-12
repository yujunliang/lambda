package algorithm.atomic;

import algocraft.util.Stopwatch;
import com.google.common.base.Function;
import domain.Output;
import domain.OutputType;

public final class Algo1 implements Function<Problem, Problem> {

	@Override
	public Problem apply(final Problem problem) {
		Stopwatch.busyWork();
		final Output output = problem.getOutput();
		output.setType(OutputType.TYPE1);
		return problem;
	}
}
