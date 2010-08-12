package algorithm.atomic;

import com.google.common.base.Function;
import domain.SubOutput1;

public final class Algo5 implements Function<Problem, Problem> {

	@Override
	public Problem apply(final Problem problem) {
		for (SubOutput1 subOutput1 : problem.getOutput().getSubOutput1List()) {
			System.out.println(subOutput1);
		}
		return problem;
	}

}
