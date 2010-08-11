package problem2;

import java.util.ArrayList;

import algocraft.algorithm.Solution;
import algocraft.creation.Singleton;
import domain.Output;
import domain.SubOutput1;

@Singleton
public final class Algo0Problem2 implements Solution<Problem2> {

	@Override
	public void solve(Problem2 problem) {
		Output output = problem.getOutput();
		ArrayList<SubOutput1> list = new ArrayList<SubOutput1>();
		for (int i = 0; i < problem.getInput().getInt1(); i++) {
			list.add(null);
		}
		output.setSubOutput1List(list);
	}
}
