package algocraft.util;

import java.util.Random;

import org.apache.log4j.Logger;

/**
 * 
 * @author yujunliang
 * 
 */
public final class Stopwatch {

	private static final Logger LOG = Logger.getLogger(Stopwatch.class);

	private static final int THIRTY_MIL = 30000000;
	private static final int MILLION = 1000000;
	private static final int TWO_SECOND = 2000;

	private Stopwatch() {
	}

	private long date = System.nanoTime();
	private long lapse;
	private boolean stopped;

	public static Stopwatch start() {
		return new Stopwatch();
	}

	public long stop() {
		if (!stopped) {

			stopped = true;
			lapse += System.nanoTime() - date;

		}
		return lapse / MILLION;
	}

	public void restart() {
		stopped = false;
		date = System.nanoTime();
	}

	public void reset() {
		stopped = false;
		date = System.nanoTime();
		lapse = 0;
	}

	public static void pretendToWork() {
		try {
			Thread.sleep(TWO_SECOND);
		} catch (Exception e) {
			LOG.info("Ignore");
		}
	}

	public static void busyWork() {
		// pretendToWork();
		hardWork();
	}

	public static void hardWork() {
		countTo(THIRTY_MIL);
	}

	private static void countTo(final int num ) {
		int item = 0;
		for (int l = 0; l < num; l++) {
			if (l != System.nanoTime()) {
				item = l;
				
			}
		}
		LOG.info("Delayed " + item);
	}

	public static void randomDelay() {
		final Random random = new Random();
		final int delay = Math.abs(random.nextInt(THIRTY_MIL));
		LOG.info("Delaying " + delay);
		countTo(delay);
	}
}
