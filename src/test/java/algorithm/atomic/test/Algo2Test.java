package algorithm.atomic.test;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

import algorithm.atomic.Algo0;
import algorithm.atomic.Algo2;
import algorithm.atomic.Problem;
import algorithm.composite.test.TopAlgoITest;

public class Algo2Test {

	@Test
	public void testIsApplicable() {
		Problem problem = TopAlgoITest.getProblem();

		Algo2 algo2 = new Algo2();
		Assert.assertTrue(algo2.apply(problem));
	}

	@Test
	public void testSolve() throws IOException {
		Problem problem = TopAlgoITest.getProblem();

		Algo0 algo0 = new Algo0();
		algo0.solve(problem);
		Algo2 algo2 = new Algo2();
		algo2.solve(problem);
	}
	
	@Test
	public void testOtherwise() {
		Problem problem = TopAlgoITest.getProblem();

		Algo2 algo2 = new Algo2();
		algo2.otherwise(problem);
	}

}
