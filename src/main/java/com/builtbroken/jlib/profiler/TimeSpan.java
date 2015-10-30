package com.builtbroken.jlib.profiler;

/**
 * Created by robert on 12/10/2014.
 */
public class TimeSpan
{
    public Long start;
    public Long end;

    public TimeSpan()
    {

    }

    public TimeSpan(Long start)
    {
        this.start = start;
    }

    public Long getDelta()
    {
        return end - start;
    }
}
