package com.builtbroken.tests.jlib.lang;

import com.builtbroken.jlib.lang.StringHelpers;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Unit test for {@link com.builtbroken.jlib.lang.StringHelpers}
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 10/3/2015.
 */
public class TestStringHelper extends TestCase
{
    /**
     * Test for {@link com.builtbroken.jlib.lang.StringHelpers#formatNanoTime(long)}
     */
    @Test
    public void testFormatNanoTime()
    {
        String s = StringHelpers.formatNanoTime(0);
        assertTrue("Output should be zero, but was " + s, "zero".equals(s));

        //Test general output with a single value
        s = StringHelpers.formatNanoTime(100);
        assertTrue("Output should be 100ns, but was " + s, "100ns".equals(s));

        s = StringHelpers.formatNanoTime(10000);
        assertTrue("Output should be 10us, but was " + s, "10us".equals(s));

        s = StringHelpers.formatNanoTime(10000000);
        assertTrue("Output should be 10ms, but was " + s, "10ms".equals(s));

        s = StringHelpers.formatNanoTime(10000000000L);
        assertTrue("Output should be 10s, but was " + s, "10s".equals(s));

        s = StringHelpers.formatNanoTime(10000000000L * 60);
        assertTrue("Output should be 10m, but was " + s, "10m".equals(s));

        //Test combined outputs
        s = StringHelpers.formatNanoTime(10001);
        assertTrue("Output should be 10us  1ns, but was " + s, "10us   1ns".equals(s));

        //Test combined outputs
        s = StringHelpers.formatNanoTime(212001010001L);
        assertTrue("Output should be 3m  32s   1ms  10us   1ns, but was " + s, "3m  32s   1ms  10us   1ns".equals(s));
    }
}
