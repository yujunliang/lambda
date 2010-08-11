package algorithm.composite.test;



import org.junit.Assert;
import org.junit.Test;

public class ResultsTest {
	
	@Test
	public void testEquals() throws Exception {
		Assert.assertEquals(TraditionalAlgorithmTest.createOutput(), TopAlgoITest.createOutput());
	}

}
