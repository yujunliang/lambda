package algorithm.atomic;

import com.google.common.base.Function;
import domain.Output;
import domain.SubOutput1;

import java.util.ArrayList;

public final class Algo0 implements Function<Problem,Problem> {

	@Override
	public Problem apply(final Problem problem) {
		final Output output = problem.getOutput();
		final ArrayList<SubOutput1> list = new ArrayList<SubOutput1>();
		output.setSubOutput1List(list);
		return problem;
	}
}
