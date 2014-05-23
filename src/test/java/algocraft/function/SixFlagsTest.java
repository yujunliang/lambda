package algocraft.function;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static algocraft.function.SixFlags.*;
import static java.lang.System.out;
import static org.junit.Assert.*;

public class SixFlagsTest {

    @Test
    public void testToString() throws Exception {
        assertEquals("[flag0,flag1,flag2,flag3,flag4,flag5]", YYYYYY.description);
        assertEquals("[!flag0,!flag1,!flag2,!flag3,!flag4,!flag5]", SixFlags.______.description);
    }

    @Test
    public void testSet() {
        assertEquals(YYYYYY, YY_YYY.resolve(2, true));
        assertEquals(YYYYYY, YYYYYY.resolve(2, true));
        assertEquals(YY_YYY, YY_YYY.resolve(2, false));
        assertEquals(YY_YYY, YYYYYY.resolve(2, false));
    }

    @Test
    public void testIs() {
        assertTrue(YYYYYY.valueAt(0));
        assertFalse(YY_YYY.valueAt(2));
    }


    @Test
    public void testApplicationUsing2Flags() {
        Person john = new Person();
        john.setMarried(false);
        john.setHasChildren(true);

        assertTrue(john.hasChildren());
        assertFalse(john.isMarried());
        assertEquals("[!Married,HasChildren]", john.toString());
    }

    @Test
    public void testApplicationUsing3Flags() {
        Product product = new Product();
        product.setImported(true);
        product.setPackaged(false);
        product.setTaxfree(true);

        assertTrue(product.isImported());
        assertFalse(product.isPackaged());
        assertTrue(product.isTaxfree());
        assertEquals("[Imported,!Packaged,Taxfree]", product.toString());
    }

    @Test
    public void testDisplay() {
        out.println(SixFlags.display());
    }

    @Test
    public void testCapacity2() {
        long count = 0;

        List<Thing2> things = new ArrayList<>();
        while (true) {
            things.add(new Thing2());
            count++;
            if (count % 1000000 == 0) {
                System.out.println(count / 1000000 + "mil");
            }
        }

    }

    @Test
    public void testCapacity() {
        long count = 0;

        List<Thing> things = new ArrayList<>();
        while (true) {
            things.add(new Thing());
            count++;
            if (count % 1000000 == 0) {
                System.out.println(count / 1000000 + "mil");
            }
        }
    }


    @Test
    public void testCapacity3() {
        long count = 0;

        List<Thing3> things = new ArrayList<>();
        while (true) {
            things.add(new Thing3());
            count++;
            if (count % 1000000 == 0) {
                System.out.println(count / 1000000 + "mil");
            }
        }
    }


    class Thing {
        private boolean f1 = false,f2 = false,f3 = true,f4 = true,f5 =false,f6 = false;
    }

    class Thing2 {
        SixFlags sixFlags = SixFlags.__YY__;
    }

    class Thing3 {
        int i1 = 1;
        int i2 = 1;
        int i3 = 1;
        int i4 = 1;
        int i5 = 1;
        int i6 = 1;
    }
}
