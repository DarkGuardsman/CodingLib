package com.builtbroken.jlib.debug;


import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Object used to log debug information with nested layers for easy readability
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 4/7/2017.
 */
public class DebugPrinter
{
    /** Logger to use for actual output */
    protected final Logger logger;

    /** Current nest level */
    protected int nest = 0;
    /** Prefix spacer for output */
    protected String spacer;
    /** Value to use for indents to make spacer */
    protected String indent = "\t";
    /** Name of the current debug section */
    protected String sectionName;
    /** Is the logger enabled */
    protected boolean enabled = true;
    /** Used in start section and end section to restore enable status of previous nest */
    protected boolean prev_enabled = true;

    List<IDebugPrintListener> listeners = new ArrayList();

    /**
     * Creates a new debug printer
     *
     * @param logger - logger to use, can't be null
     */
    public DebugPrinter(Logger logger)
    {
        this.logger = logger;
        if (logger == null)
        {
            throw new IllegalArgumentException("Logger was null");
        }
    }

    public void add(IDebugPrintListener listener)
    {
        this.listeners.add(listener);
    }

    /**
     * Increases the spacer amount
     * to act as a nested indent
     */
    public void nest()
    {
        nest++;
        buildSpacer();
    }

    /**
     * Decreases the spacer amount
     * to act as a nested indent
     */
    public void unnest()
    {
        nest--;
        buildSpacer();
    }

    /**
     * Generates the spacer to use for output
     */
    protected void buildSpacer()
    {
        spacer = "";
        for (int i = 0; i < nest; i++)
        {
            spacer += indent;
        }
    }

    /**
     * Outputs a log
     *
     * @param msg - message to output
     */
    public void log(String msg)
    {
        if (enabled)
        {
            if (spacer == null)
            {
                buildSpacer();
            }
            logger.info(spacer + getSectionPrefix() + msg);
            for (IDebugPrintListener listener : listeners)
            {
                listener.onMessage(msg, getSectionPrefix(), spacer, false);
            }
        }
    }

    /**
     * Outputs an error log
     *
     * @param msg - message to output
     */
    public void error(String msg)
    {
        if (enabled)
        {
            logger.error(spacer + getSectionPrefix() + msg);
            for (IDebugPrintListener listener : listeners)
            {
                listener.onMessage(msg, getSectionPrefix(), spacer, true);
            }
        }
    }

    /**
     * Outputs an error log
     *
     * @param msg - message to output
     * @param e   - error
     */
    public void error(String msg, Throwable e)
    {
        if (enabled)
        {
            logger.error(spacer + getSectionPrefix() + msg, e);
            for (IDebugPrintListener listener : listeners)
            {
                listener.onMessageWithError(msg, getSectionPrefix(), spacer, e);
            }
        }
    }

    /**
     * Gets the prefix to use for sections
     *
     * @return section if not null, or empty string
     */
    protected String getSectionPrefix()
    {
        if (sectionName != null && !sectionName.isEmpty())
        {
            return sectionName + ": ";
        }
        return "";
    }

    /**
     * Starts a new section, indents the section
     *
     * @param msg - message to output
     */
    public void start(String msg)
    {
        log(msg);
        nest();
    }

    /**
     * Starts a new section, indents the section
     *
     * @param sectionName - name of a section
     * @param msg         - message to output
     */
    public void start(String sectionName, String msg)
    {
        this.sectionName = sectionName;
        log(msg);
        nest();
    }

    /**
     * Starts a new section, indents the section
     *
     * @param sectionName - name of a section
     * @param msg         - message to output
     * @param enable      - changes the enabled state, used for procedural logic
     */
    public void start(String sectionName, String msg, boolean enable)
    {
        prev_enabled = this.enabled;
        this.enabled = enable;
        start(sectionName, msg);
    }

    /**
     * Ends an existing section, always
     * last section create and will
     * decrease indent
     *
     * @param msg - message to output
     */
    public void end(String msg)
    {
        enabled = prev_enabled;
        unnest();
        log(msg);
        sectionName = null;
    }

    /**
     * Ends an existing section, always
     * last section create and will
     * decrease indent
     */
    public void end()
    {
        unnest();
        sectionName = null;
    }

    /**
     * Enables logging globally,
     * changes previous status as well
     */
    public void enable()
    {
        enabled = true;
        prev_enabled = true;
    }

    /**
     * Disable logging globally,
     * changes previous status as well
     */
    public void disable()
    {
        enabled = false;
        prev_enabled = false;
    }

    /**
     * Sets the spacer value to use as an indent
     *
     * @param value - string to use, forces null to space
     */
    public void setIndent(String value)
    {
        this.indent = value;
        if (value == null)
        {
            this.indent = " ";
        }
    }
}
