package algorithm.atomic;

import com.google.common.base.Function;
import domain.SubOutput2;

public final class Algo3 implements Function<Problem,Problem> {

	@Override
	public Problem apply(final Problem problem) {
		final SubOutput2 subOutput = new SubOutput2();
		subOutput.setDate(problem.getInput().getDate1());
		problem.getOutput().setSubOutput2(subOutput);
		return problem;
	}
}
