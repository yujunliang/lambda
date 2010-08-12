package algorithm.atomic;

import com.google.common.base.Predicate;


/**
 * Created by cosmin on Aug 11, 2010
 */
public class Algo2Predicate implements Predicate<Problem> {
	@Override
	public boolean apply(final Problem problem) {
		return problem.getInput().isCondition1();
	}
}
