package com.builtbroken.jlib.lang;

import com.google.common.collect.ImmutableList;

/**
 * Enum of english letters for easy look up
 * Created by robert on 1/13/2015.
 */
public enum EnglishLetters
{
    A,
    B,
    C,
    D,
    E,
    F,
    G,
    H,
    I,
    J,
    K,
    L,
    M,
    N,
    O,
    P,
    Q,
    R,
    S,
    T,
    U,
    V,
    W,
    X,
    Y,
    Z;

    private static ImmutableList<Character> all_values;
    private static ImmutableList<Character> lower_case;
    private static ImmutableList<Character> upper_case;

    private static boolean init = false;

    private static void init()
    {
        if (!init)
        {
            ImmutableList.Builder<Character> all = new ImmutableList.Builder();
            ImmutableList.Builder<Character> l = new ImmutableList.Builder();
            for (int i = 0; i < values().length; i++)
            {
                l.add(values()[i].name().toLowerCase().charAt(0));
                all.add(values()[i].name().toLowerCase().charAt(0));
            }
            lower_case = l.build();

            l = new ImmutableList.Builder();
            for (int i = 0; i < values().length; i++)
            {
                l.add(values()[i].name().charAt(0));
                all.add(values()[i].name().charAt(0));
            }
            upper_case = l.build();
            all_values = all.build();
            init = true;
        }
    }

    public static boolean isLetter(Character c)
    {
        if (!init)
        {
            init();
        }
        return all_values.contains(c);
    }

    public static boolean isUpperCase(Character c)
    {
        if (!init)
        {
            init();
        }
        return upper_case.contains(c);
    }

    public static boolean isLowerCase(Character c)
    {
        if (!init)
        {
            init();
        }
        return lower_case.contains(c);
    }
}
