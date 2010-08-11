package algorithm.atomic;

import java.util.Date;
import java.util.List;

import algocraft.algorithm.Otherwise;
import algocraft.algorithm.Solution;
import algocraft.creation.Singleton;
import algocraft.util.Stopwatch;
import domain.Input;
import domain.Output;
import domain.SubOutput1;

@Singleton
public final class Algo2 implements Solution<Problem>, Otherwise<Problem> {

	@Override
	public void solve(final Problem problem) {

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
	}

	@Override
	public boolean isApplicable(final Problem problem) {
		return problem.getInput().isCondition1();
	}

	@Override
	public void otherwise(final Problem problem) {
		System.out
				.println("algorithm.primitive.Algo2@7a187814 is not applicable.");
	}

}