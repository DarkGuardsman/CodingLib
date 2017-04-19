package com.builtbroken.jlib.data.vector;

/**
 * Useful interface to define that an object has a 3D location.
 *
 * @author DarkGuardsman
 */
public interface IPos3D
{
    double x();

    double y();

    double z();

    default float xf()
    {
        return (float) x();
    }

    default float yf()
    {
        return (float) y();
    }

    default float zf()
    {
        return (float) z();
    }

    default int xi()
    {
        return (int) Math.floor(x());
    }

    default int yi()
    {
        return (int) Math.floor(y());
    }

    default int zi()
    {
        return (int) Math.floor(z());
    }
}
