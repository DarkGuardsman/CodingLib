package com.builtbroken.jlib.lang;

/** Enum of useful symbols to place into strings
 * Created by robert on 1/13/2015.
 * @deprecated Removing as this looks unused and I suspect an enum already exists for it
 */
@Deprecated
public enum Symbols
{
    EXCLAMATION('!'),
    NUMBER('#'),
    DOLLAR('$'),
    PERCENT('%'),
    AMPERSAND('&'),
    OPEN_BRACKET('('),
    CLOSE_BRACKET(')'),
    COMMA(','),
    COLON(':'),
    SIMICOLON(';'),
    AT('@'),
    OPEN_SQUARE_BRACKET('['),
    CLOSE_SQUARE_BRACKET(']'),
    CARET('^'),
    UNDERSCORE('_'),
    APOSTROPHE('\''),
    QUOTE('\"'),
    DASH('-'),
    CURLY_OPEN_BRACKET('{'),
    CURLY_CLOSE_BRACKET('}'),
    TIDLE('~'),
    PLUS('+'),
    EQUALS('='),
    BACKSLASH('\\'),
    FORWARDSLASH('/'),
    LESS_THAN('<'),
    GREATER_THAN('>'),
    VERTICAL_BAR('|'),
    PERIOD('.'),
    QUESTION('?'),
    STAR('*');

    //TODO http://character-code.com http://graphemica.com
    private final char c;

    Symbols(char c)
    {
        this.c = c;
    }

    public char getChar()
    {
        return c;
    }

    @Override
    public String toString()
    {
        return name().toLowerCase() + "[ " + c + " ]";
    }
}
