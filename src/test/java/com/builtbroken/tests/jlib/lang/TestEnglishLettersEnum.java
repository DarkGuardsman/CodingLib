package com.builtbroken.tests.jlib.lang;

import com.builtbroken.jlib.data.Base10Numbers;
import com.builtbroken.jlib.lang.EnglishLetters;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests {@link com.builtbroken.jlib.lang.EnglishLetters}
 * Created by Dark on 9/10/2015.
 */
public class TestEnglishLettersEnum
{
    @Test
    public void testIsLetter()
    {
        for (int i = 0; i < EnglishLetters.values().length; i++)
        {
            Assert.assertTrue(EnglishLetters.isLetter(EnglishLetters.values()[i].name().charAt(0)));
        }

        for (int i = 0; i < EnglishLetters.values().length; i++)
        {
            Assert.assertTrue(EnglishLetters.isLetter(EnglishLetters.values()[i].name().toLowerCase().charAt(0)));
        }

        for (int i = 0; i < Base10Numbers.values().length; i++)
        {
            Assert.assertFalse(EnglishLetters.isLetter(Base10Numbers.values()[i].character()));
        }
    }

    @Test
    public void testUpper()
    {
        for (int i = 0; i < EnglishLetters.values().length; i++)
        {
            Assert.assertTrue(EnglishLetters.isUpperCase(EnglishLetters.values()[i].name().charAt(0)));
        }

        for (int i = 0; i < EnglishLetters.values().length; i++)
        {
            Assert.assertFalse(EnglishLetters.isUpperCase(EnglishLetters.values()[i].name().toLowerCase().charAt(0)));
        }

        for (int i = 0; i < Base10Numbers.values().length; i++)
        {
            Assert.assertFalse(EnglishLetters.isUpperCase(Base10Numbers.values()[i].character()));
        }
    }

    @Test
    public void testLower()
    {
        for (int i = 0; i < EnglishLetters.values().length; i++)
        {
            Assert.assertFalse(EnglishLetters.isLowerCase(EnglishLetters.values()[i].name().charAt(0)));
        }

        for (int i = 0; i < EnglishLetters.values().length; i++)
        {
            Assert.assertTrue(EnglishLetters.isLowerCase(EnglishLetters.values()[i].name().toLowerCase().charAt(0)));
        }

        for (int i = 0; i < Base10Numbers.values().length; i++)
        {
            Assert.assertFalse(EnglishLetters.isLowerCase(Base10Numbers.values()[i].character()));
        }
    }
}
