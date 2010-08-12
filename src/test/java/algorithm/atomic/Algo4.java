package algorithm.atomic;

import com.google.common.base.Function;
import domain.SubOutput2;

public final class Algo4 implements Function<Problem, Problem> {

	@Override
	public Problem apply(final Problem problem) {
		final SubOutput2 subOutput = problem.getOutput().getSubOutput2();
		subOutput.getDate().setTime(subOutput.getDate().getTime() + 6000);
		return problem;
	}
}
