package com.mcmanuellp.woodlandsworld.handler;

import com.mcmanuellp.woodlandsworld.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler
{
    public static Configuration configuration;
    public static boolean testValue = false;
	public static boolean bonfireTexture = false;

    public static void init(File configFile)
    {
        //create the config object from the given config file
        if(configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        testValue = configuration.getBoolean("configValue", Configuration.CATEGORY_GENERAL, false, "HI hw r u");

	    bonfireTexture = configuration.getBoolean("bonfireTexture", Configuration.CATEGORY_GENERAL, false, "If true, bonfire will have static fire texture press F3+T to refresh textures in game otherwise it needs a restart");

        if(configuration.hasChanged())
        {
            configuration.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            loadConfiguration();
        }
    }
}