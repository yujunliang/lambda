package algorithm.atomic;

import java.util.Date;
import java.util.List;

import algocraft.util.Stopwatch;
import com.google.common.base.Function;
import domain.Input;
import domain.Output;
import domain.SubOutput1;

public final class Algo2If implements Function<Problem, Problem> {

	@Override
	public Problem apply(final Problem problem) {

		// if (i == 1) {
		// throw new RuntimeException();
		// }
		for (int i = 0; i < problem.getInput().getInt1(); i++) {
			Stopwatch.busyWork();

			final Input input = problem.getInput();
			final SubOutput1 subOutput1 = new SubOutput1();
			subOutput1.setAmount(input.getAmount1().devide(input.getInt1())
					.plus(i));
			subOutput1.setInt1(i);
			subOutput1.setDate1(new Date(input.getDate1().getTime()
					+ ((long) i) * 10000));
			final Output output = problem.getOutput();
			final List<SubOutput1> list = output.getSubOutput1List();
			list.add(subOutput1);
		}
		return problem;
	}
}
