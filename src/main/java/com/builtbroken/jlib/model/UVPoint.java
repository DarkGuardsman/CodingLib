package com.builtbroken.jlib.model;

import com.builtbroken.jlib.data.vector.IPos2D;
import com.builtbroken.jlib.data.vector.Pos2D;

/**
 * Created by Dark on 7/29/2015.
 */
public class UVPoint extends Pos2D<UVPoint> implements IPos2D
{
    public UVPoint(double x, double y)
    {
        super(x, y);
    }

    @Override
    public UVPoint newPos(double x, double y)
    {
        return new UVPoint(x, y);
    }
}
