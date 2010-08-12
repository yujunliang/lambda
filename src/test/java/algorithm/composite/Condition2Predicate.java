package algorithm.composite;

import algorithm.atomic.Problem;
import com.google.common.base.Predicate;

public final class Condition2Predicate implements Predicate<Problem> {

	@Override
	public boolean apply(final Problem problem) {
		return problem.getInput().isCondition2();
	}
}

