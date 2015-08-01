package com.builtbroken.jlib.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MathHelper
{
    public static final Random rand = new Random();
	/**
	 * Interpolates between point a and point b
	 *
	 * @param f A percentage value between 0 to 1
	 * @return The interpolated value
	 */
	public static double lerp(double a, double b, double f)
	{
		return a + f * (b - a);
	}

	public static float lerp(float a, float b, float f)
	{
		return a + f * (b - a);
	}

	/**
	 * Caps a value between -bounds to +bounds
	 *
	 * @return A value capped between two bounds.
	 */
	public static double absCap(double value, double bounds)
	{
		return Math.min(Math.max(value, -bounds), bounds);
	}

	public static float absCap(float value, float bounds)
	{
		return Math.min(Math.max(value, -bounds), bounds);
	}


    public static short randomShort()
    {
        return (short)(rand.nextInt(Short.MAX_VALUE * 2) - Short.MAX_VALUE);
    }

	/**
	 * Generates an array of random numbers
	 *
	 * @param random    - random instance to be used
	 * @param maxNumber - max size of the int to use
	 * @param arraySize - length of the array
	 * @return array of random numbers
	 */
	public static int[] generateRandomIntArray(Random random, int maxNumber, int arraySize)
	{
		return MathHelper.generateRandomIntArray(random, 0, maxNumber, arraySize);
	}

	public static int[] generateSqeuncedArray(int start, int size)
	{
		int[] array = new int[size];
		for (int i = 0; i < array.length; i++)
		{
			array[i] = start + i;
		}
		return array;
	}

	public static List<Integer> getSquencedList(int start, int end, int... ignore)
	{
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> remove = new ArrayList<Integer>();

		//Create remove list
		if (ignore != null & ignore.length > 0)
		{
			for (int i = 0; i <= ignore.length; i++)
			{
				remove.add(ignore[i]);
			}
		}

		//Create sequence list void of the remove list's items
		for (int i = 0; i <= end; i++)
		{
			if (!remove.contains(start + i))
			{
				list.add(start + i);
			}
		}

		return list;
	}

	/**
	 * Generates an array of random numbers
	 *
	 * @param random    - random instance to be used
	 * @param minNumber - smallest random Integer to use. Warning can lead to longer than normal
	 *                  delay in returns
	 * @param maxNumber - max size of the int to use
	 * @param arraySize - length of the array
	 * @return array of random numbers
	 */
	public static int[] generateRandomIntArray(Random random, int minNumber, int maxNumber, int arraySize)
	{
		int[] array = new int[arraySize];
		for (int i = 0; i < array.length; i++)
		{
			int number = random.nextInt(maxNumber);
			if (minNumber != 0)
			{
				while (number < minNumber)
				{
					number = random.nextInt(maxNumber);
				}
			}
			array[i] = number;
		}
		return array;
	}

	/**
	 * Clamps the angles to a min max by adding or subtracting the min max. This way it maintanes
	 * the change in angle in the chance it goes out of bounds
	 */
	public static float clampAngle(float var, float min, float max)
	{
		while (var < min)
		{
			var += 360;
		}

		while (var > max)
		{
			var -= 360;
		}

		return var;
	}

	public static double clampAngle(double var, double min, float max)
	{
		while (var < min)
		{
			var += max;
		}
		while (var > max)
		{
			var -= max;
		}
		return var;
	}

	public static float clamp(float var, float min, float max)
	{
		if (var < min)
		{
			return min;
		}
		else if (var > max)
		{
			return max;
		}
		else
		{
			return var;
		}
	}

	public static double dclamp(double var, double min, double max)
	{
		if (var < min)
		{
			return min;
		}
		else if (var > max)
		{
			return max;
		}
		else
		{
			return var;
		}
	}

	/**
	 * Clamps an angle to 360 degree circle
	 */
	public static float clampAngleTo360(float var)
	{
		return MathHelper.clampAngle(var, 0, 360);
	}

	public static double clampAngleTo360(double var)
	{
		return MathHelper.clampAngle(var, 0, 360);
	}

	public static float clampAngleTo180(float var)
	{
		return MathHelper.clampAngle(var, -180, 180);
	}

	public static double clampAngleTo180(double var)
	{
		return MathHelper.clampAngle(var, -180, 180);
	}

	/**
	 * Find the shortest delta change to the angle goal from the current angle
	 */
	public static float shortestAngleTo360(float angle, float angleGoal)
	{
		angle = clampAngleTo360(angle);
		angleGoal = clampAngleTo360(angleGoal);

		if (angle == angleGoal)
		{
			return 0;
		}
		else if (angle > angleGoal)
		{
			return angleGoal - angle;
		}
		else
		{
			return angle - angleGoal;
		}
	}

    /** Gets the volume of a sphere
     *
     * @param radius - distance from center
     * @return exact volume
     */
    public static double getSphereVolume(double radius)
    {
        return (4 * Math.PI * (radius * radius * radius)) / 3;
    }


    /**
     * MC method that has been copies to remove the @SideOnly(Side.CLIENT)
     * @param p_154353_0_
     * @return
     */
    public static int func_154353_e(double p_154353_0_)
    {
        return (int)(p_154353_0_ >= 0.0D ? p_154353_0_ : -p_154353_0_ + 1.0D);
    }

}
