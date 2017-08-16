package com.builtbroken.jlib.debug;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 8/16/2017.
 */
public interface IDebugPrintListener
{
    void onMessage(String msg, String prefix, String spacer, boolean error);

    void onMessageWithError(String msg, String prefix, String spacer, Throwable e);
}
