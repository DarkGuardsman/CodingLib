package com.builtbroken.jlib.lang;


import org.apache.logging.log4j.Logger;

/**
 * Object used to log debug information with nested layers for easy readability
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 4/7/2017.
 */
public class DebugPrinter
{
    protected final Logger logger;

    protected int nest = 0;
    protected String spacer;

    public DebugPrinter(Logger logger)
    {
        this.logger = logger;
    }

    public void nest()
    {
        nest++;
        buildSpacer();
    }

    public void unnest()
    {
        nest--;
        buildSpacer();
    }

    protected void buildSpacer()
    {
        spacer = "";
        for (int i = 0; i < nest; i++)
        {
            spacer += "\t";
        }
    }

    public void log(String msg)
    {
        logger.info(spacer + msg);
    }

    public void error(String msg)
    {
        logger.error(spacer + msg);
    }

    public void error(String msg, Throwable e)
    {
        logger.error(spacer + msg, e);
    }

    public void start(String msg)
    {
        log(msg);
        nest();
    }

    public void end(String msg)
    {
        unnest();
        log(msg);
    }

    public void end()
    {
        unnest();
    }
}
