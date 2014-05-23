package algocraft.singleton;

import org.apache.commons.lang.time.StopWatch;
import org.junit.Test;

import java.util.concurrent.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AwardTest {

    public static final int INT = 200000;


    @Test
    public void testRemove() throws Exception {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();


        Award.valueOf(2);
        Award.valueOf(3);
        Award.valueOf(4);
        Award.valueOf(2);
        Award.valueOf(1);
        Award.valueOf(3);
        Award.valueOf(7);
        Award.valueOf(5);
        Award.valueOf(7);
        Award.valueOf(4);
        Award.valueOf(3);

        System.out.println(Award.values());
    }

    @Test
    public void testValueOf() throws Exception {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        ExecutorService executorService = Executors.newFixedThreadPool(50);

        Future<Award>[] future = new Future[INT];

        final CountDownLatch latch = new CountDownLatch(1);

        for (int i = 0; i < INT; i++) {

            future[i] = executorService.submit(() -> {

                latch.await();
                Award.valueOf(1);
                Award.valueOf(1);
                Award.valueOf(2);
                Award.valueOf(3);
                Award.valueOf(4);
                Award.valueOf(1);
                Award.valueOf(5);
                Award.valueOf(6);
                return Award.valueOf(1);
            });
        }
        latch.countDown();
        Award award = Award.valueOf(1);
        System.out.println(award);
        for (int i = 0; i < INT; i++) {
            assertFalse(award.equals(future[i]));
            assertTrue(award.equals(future[i].get()));
        }
        System.out.println(Award.values());
    }
}
