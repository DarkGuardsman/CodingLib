package com.builtbroken.jlib.model;

import com.builtbroken.jlib.data.vector.IPos3D;
import com.builtbroken.jlib.data.vector.Pos3D;

/**
 * Created by Dark on 7/29/2015.
 */
public class Vert extends Pos3D<Vert> implements IPos3D
{
    public Vert(double x, double y, double z)
    {
        super(z, y, z);
    }

    @Override
    public Vert newPos(double x, double y, double z)
    {
        return new Vert(x, y, z);
    }
}
