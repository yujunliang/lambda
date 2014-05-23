package algocraft.function;

import org.junit.Test;

import java.util.NoSuchElementException;

public class SortedCounterTest {

    @Test
    public void testCollect() throws Exception {

    }

    @Test
    public void testAccept() throws Exception {

    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveFirst() throws Exception {
        new SortedCounter<String>().removeFirst();
    }

    @Test
    public void testContainsKey() throws Exception {

    }
}
