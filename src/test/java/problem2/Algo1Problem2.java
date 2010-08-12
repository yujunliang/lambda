package problem2;

import java.util.ArrayList;

import com.google.common.base.Function;
import domain.Output;
import domain.SubOutput1;

public final class Algo1Problem2 implements Function<Problem2,Problem2> {

	@Override
	public Problem2 apply(Problem2 problem) {
		Output output = problem.getOutput();
		ArrayList<SubOutput1> list = new ArrayList<SubOutput1>();
		for (int i = 0; i < problem.getInput().getInt1(); i++) {
			list.add(null);
		}
		output.setSubOutput1List(list);

		return problem;
	}
}
