package com.mcmanuellp.woodlandsworld;

import com.mcmanuellp.woodlandsworld.configuration.ConfigurationHandler;
import com.mcmanuellp.woodlandsworld.proxy.IProxy;
import com.mcmanuellp.woodlandsworld.reference.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class WoodlandsWorld
{
    @Mod.Instance(Reference.MOD_ID)
    public static WoodlandsWorld instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        //init network handling, mod config, items & blocks

        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        //init gui's, tile entities, crafting, general event handlers

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        //init wrapping up everything

    }
}