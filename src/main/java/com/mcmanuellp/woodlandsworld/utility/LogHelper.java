package com.mcmanuellp.woodlandsworld.utility;

/**
 * Maybe !(stolen) adapted from someone (P*a~h%i>m?a#r)
 */

import com.mcmanuellp.woodlandsworld.reference.Reference;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Level;

public class LogHelper
{
    public static void log(Level logLevel, Object object)
    {
        FMLLog.log(Reference.MOD_NAME, logLevel, String.valueOf(object));
    }

    public static void off(Object object)
    {
        log(Level.OFF, object);
    }

    public static void fatal(Object object)
    {
        log(Level.FATAL, object);
    }

    public static void error(Object object)
    {
        log(Level.ERROR, object);
    }

    public static void warn(Object object)
    {
        log(Level.WARN, object);
    }

    public static void info(Object object)
    {
        log(Level.INFO, object);
    }

    // below doesn't output in log

    public static void debug(Object object)
    {
        log(Level.DEBUG, object);
    }

    public static void trace(Object object)
    {
        log(Level.TRACE, object);
    }

    public static void all(Object object)
    {
        log(Level.ALL, object);
    }
}