package com.mcmanuellp.woodlandsworld.configuration;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler
{
    public static void init(File configFile)
    {
        //create the config object from the given config file
        Configuration configuration = new Configuration(configFile);
        boolean configValue = false;
        try
        {
            //load the config file
            configuration.load();

            //read in properties from config file
            configValue = configuration.get("Woodlands goes wreckage", "configValue", true, "V example config file").getBoolean(true);
        }
        catch (Exception e)
        {
            //log the exeption
        }
        finally
        {
            //save the config file
            configuration.save();
        }

        System.out.println("Configuration Test:" + configValue);
    }
}