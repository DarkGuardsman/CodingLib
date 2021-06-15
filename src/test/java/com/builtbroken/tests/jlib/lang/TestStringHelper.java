package com.builtbroken.tests.jlib.lang;

import com.builtbroken.jlib.lang.StringHelpers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link com.builtbroken.jlib.lang.StringHelpers}
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 10/3/2015.
 */
public class TestStringHelper
{
    /**
     * Test for {@link com.builtbroken.jlib.lang.StringHelpers#formatNanoTime(long)}
     */
    @Test
    public void testFormatNanoTime() //TODO break into several tests
    {
        String s = StringHelpers.formatNanoTime(0);
        Assertions.assertTrue("zero".equals(s), "Output should be zero, but was " + s);

        //Test general output with a single value
        s = StringHelpers.formatNanoTime(100);
        Assertions.assertTrue("100ns".equals(s), "Output should be 100ns, but was " + s);

        s = StringHelpers.formatNanoTime(10000);
        Assertions.assertTrue("10us".equals(s), "Output should be 10us, but was " + s);

        s = StringHelpers.formatNanoTime(10000000);
        Assertions.assertTrue("10ms".equals(s), "Output should be 10ms, but was " + s);

        s = StringHelpers.formatNanoTime(10000000000L);
        Assertions.assertTrue("10s".equals(s), "Output should be 10s, but was " + s);

        s = StringHelpers.formatNanoTime(10000000000L * 60);
        Assertions.assertTrue("10m".equals(s), "Output should be 10m, but was " + s);

        //Test combined outputs
        s = StringHelpers.formatNanoTime(10001);
        Assertions.assertTrue("10us   1ns".equals(s), "Output should be 10us  1ns, but was " + s);

        //Test combined outputs
        s = StringHelpers.formatNanoTime(212001010001L);
        Assertions.assertTrue("3m  32s   1ms  10us   1ns".equals(s), "Output should be 3m  32s   1ms  10us   1ns, but was " + s);
    }
}
