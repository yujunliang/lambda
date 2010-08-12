package algorithm.composite.test;

import java.util.Date;

import org.junit.Test;

import algocraft.util.Stopwatch;
import algorithm.tranditional.TraditionalAlgorithm;
import domain.Amount;
import domain.Input;
import domain.Output;

public class TraditionalAlgorithmTest  {

	private static final Date DATE1 = new Date();

	public static void main(String[] args) {
		TraditionalAlgorithmTest test = new TraditionalAlgorithmTest();

		test.test();
	}

	@Test
	public void test() {
		Stopwatch watch = Stopwatch.start();
		Output output = createOutput();
		System.out.println(watch.stop() + "]" + output);
	}

	public static Output createOutput() {

		TraditionalAlgorithm algo_I = new TraditionalAlgorithm();
		Input input = getInput();
		return algo_I.solve(input);
	}

	public static Input getInput() {
		Input input = new Input();
		input.setAmount(Amount.valueOf(2000));
		input.setCondition1(true);
		input.setCondition2(true);
		input.setDate1(new Date(DATE1.getTime()));
		input.setInt1(4);
		return input;
	}
}
