package algorithm.composite.test;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import algocraft.util.Stopwatch;
import algorithm.atomic.Problem;
import algorithm.composite.TopAlgoI;
import domain.Input;
import domain.Output;

public class TopAlgoITest  {
	
	private static final AtomicInteger count = new AtomicInteger();
	
	public class StopSign {
		private final Stopwatch watch;

		StopSign(Stopwatch watch) {
			this.watch = watch;
		}


		public Problem call(Problem problem) {
			System.out.println("Timer[" + count.incrementAndGet() +  "]" + watch.stop() + "]" + problem.getOutput());
			return null;
		}

	}

	public static Output createOutput() throws Exception {
		Problem problem = getProblem();
		TopAlgoI algoI = new TopAlgoI();
		return algoI.apply(problem).getOutput();
	}

	public static Problem getProblem() {
		Problem problem = new Problem();
		Input input = TraditionalAlgorithmTest.getInput();
		problem.setInput(input);
		Output output = new Output();

		problem.setOutput(output);
		return problem;
	}

	public static void main(String[] args) {
		TopAlgoITest test = new TopAlgoITest();
		test.test();
	}

	@Test
	public void test() {

		try {
			Problem problem = getProblem();
			TopAlgoI algoI = new TopAlgoI();
			Stopwatch watch = Stopwatch.start();
			algoI.apply(problem);
			new StopSign(watch).call(problem);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
