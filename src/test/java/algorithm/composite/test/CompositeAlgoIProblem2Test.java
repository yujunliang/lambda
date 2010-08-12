package algorithm.composite.test;

import org.junit.Test;

import problem2.CompositeAlgoIProblem2;
import problem2.Problem2;
import algocraft.util.Stopwatch;
import domain.Input;
import domain.Output;

public class CompositeAlgoIProblem2Test {

	@Test
	public void main() {

		Stopwatch watch = Stopwatch.start();
		Output output;
		try {
			output = createOutput();
			System.out.println(watch.stop() + "]" + output);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(0);

	}

	public static Output createOutput() throws Exception {

		Problem2 problem = getProblem();
		CompositeAlgoIProblem2 algoI = new CompositeAlgoIProblem2();
		return algoI.apply(problem).getOutput();
	}
	
	private static Problem2 getProblem() {
		Problem2 problem = new Problem2();
		Input input = TraditionalAlgorithmTest.getInput();
		problem.setInput(input);
		Output output = new Output();

		problem.setOutput(output);
		return problem;
	}

}
