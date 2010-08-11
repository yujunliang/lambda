package algorithm.atomic;

import org.junit.Test;

import algocraft.util.Stopwatch;

public class BusyWorkTest {

	@Test
	public void main() {

		Stopwatch watch = Stopwatch.start();
		Stopwatch.busyWork();
		System.out.println(watch.stop() + "]");
	}

}
