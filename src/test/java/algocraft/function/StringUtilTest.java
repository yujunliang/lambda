package algocraft.function;

import org.apache.log4j.Logger;
import org.junit.Test;

import static algocraft.function.StringUtil.concatenate;
import static algocraft.function.StringUtil.format;


public class StringUtilTest {
    Logger logger = Logger.getLogger("StringUtilTest");

    @Test
    public void testRevert() throws Exception {
          System.out.println(StringUtil.revert("1234567890"));
    }

    @Test
    public void testRevertWors() {
        System.out.println(StringUtil.revertWords("This is true"));
    }

    @Test
    public void testRevertWors2() {
        System.out.println(StringUtil.revertWords("this is true".toCharArray()));
    }


    @Test
    public void testCancatenate() {
        concatenate("1", "2", "3");
        logger.debug(concatenate("1", "2", "3"));
        logger.info(concatenate("1", "2", "3"));
        logger.info(logger.isDebugEnabled());
    }

    @Test
    public void testFormat() {
        format("%s + %s = %s", "1", "2", "3");
        logger.debug(format("%s + %s = %s", "1", "2", "3"));
        logger.info(format("%s + %s = %s", "1", "2", "3"));
        logger.info(logger.isDebugEnabled());
    }
}
