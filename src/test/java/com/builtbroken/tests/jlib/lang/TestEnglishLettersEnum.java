package com.builtbroken.tests.jlib.lang;

import com.builtbroken.jlib.data.Base10Numbers;
import com.builtbroken.jlib.lang.EnglishLetters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests {@link com.builtbroken.jlib.lang.EnglishLetters}
 * Created by Dark on 9/10/2015.
 */
public class TestEnglishLettersEnum
{
    @Test
    public void testIsLetter() //TODO remake as a permutation test
    {
        for (int i = 0; i < EnglishLetters.values().length; i++)
        {
            Assertions.assertTrue(EnglishLetters.isLetter(EnglishLetters.values()[i].name().charAt(0)));
        }

        for (int i = 0; i < EnglishLetters.values().length; i++)
        {
            Assertions.assertTrue(EnglishLetters.isLetter(EnglishLetters.values()[i].name().toLowerCase().charAt(0)));
        }

        for (int i = 0; i < Base10Numbers.values().length; i++)
        {
            Assertions.assertFalse(EnglishLetters.isLetter(Base10Numbers.values()[i].character()));
        }
    }

    @Test
    public void testUpper() //TODO remake as a permutation test
    {
        for (int i = 0; i < EnglishLetters.values().length; i++)
        {
            Assertions.assertTrue(EnglishLetters.isUpperCase(EnglishLetters.values()[i].name().charAt(0)));
        }

        for (int i = 0; i < EnglishLetters.values().length; i++)
        {
            Assertions.assertFalse(EnglishLetters.isUpperCase(EnglishLetters.values()[i].name().toLowerCase().charAt(0)));
        }

        for (int i = 0; i < Base10Numbers.values().length; i++)
        {
            Assertions.assertFalse(EnglishLetters.isUpperCase(Base10Numbers.values()[i].character()));
        }
    }

    @Test
    public void testLower() //TODO remake as a permutation test
    {
        for (int i = 0; i < EnglishLetters.values().length; i++)
        {
            Assertions.assertFalse(EnglishLetters.isLowerCase(EnglishLetters.values()[i].name().charAt(0)));
        }

        for (int i = 0; i < EnglishLetters.values().length; i++)
        {
            Assertions.assertTrue(EnglishLetters.isLowerCase(EnglishLetters.values()[i].name().toLowerCase().charAt(0)));
        }

        for (int i = 0; i < Base10Numbers.values().length; i++)
        {
            Assertions.assertFalse(EnglishLetters.isLowerCase(Base10Numbers.values()[i].character()));
        }
    }
}
