package algocraft.singleton;

import org.apache.commons.lang.time.StopWatch;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.*;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StudentTest {

    public static final int INT = 200;


    @Test
    public void testEvict() throws Exception {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Student.valueOf("Tom", "Cruise");
        Student.valueOf("Tom", "Hanks");
        Student.valueOf("Sean", "Penn");

        Student.valueOf("Kelly", "Cruise");
        Student.valueOf("Charles", "Hanks");
        Student.valueOf("Kelly", "Hanks");


        Student.valueOf("Tom", "Cruise");
        System.out.println(Student.values());

    }

    @Test
    public void testValueOf() throws Exception {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        ExecutorService executorService = Executors.newFixedThreadPool(50);

        Future<Student>[] future = new Future[INT];

        final CountDownLatch latch = new CountDownLatch(1);

        for (int i = 0; i < INT; i++) {

            future[i] = executorService.submit(() -> {
                latch.await();
                Student.valueOf("Tom", "Cruise");
                Student.valueOf("Tom", "Hanks");
                Student.valueOf("Sean", "Penn");
                return Student.valueOf("Tom", "Cruise");
            });
        }
        latch.countDown();
        Student student = Student.valueOf("Tom", "Cruise");
        System.out.println(student);
        for (int i = 0; i < INT; i++) {
            assertTrue(student == future[i].get());
            assertFalse(student.equals(future[i]));
            assertTrue(student.equals(future[i].get()));
        }
        System.out.println(Student.values());

    }

    @Test
    public void whyNeedIt() {
        List<Student> students = newArrayList(
            Student.valueOf("Tom", "Hanks"),
            Student.valueOf("Tom", "Cruise"),
            Student.valueOf("Sean", "Penn")
        );
        List<Student> students1 = newArrayList(
            Student.valueOf("Tom", "Hanks"),
            Student.valueOf("Tom", "Cruise"),
            Student.valueOf("Sean", "Penn")
        );
        List<Student> students2 = newArrayList(
            Student.valueOf("Tom", "Hanks"),
            Student.valueOf("Tom", "Cruise"),
            Student.valueOf("Sean", "Penn")
        );

        for (int i = 0; i < students.size(); i++) {
            assertTrue(students.get(i) == students1.get(i));
            assertTrue(students1.get(i) == students2.get(i));
        }
        System.out.println(Student.values());


    }
}
