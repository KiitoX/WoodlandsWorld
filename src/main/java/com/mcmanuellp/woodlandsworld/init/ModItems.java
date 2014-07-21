package com.mcmanuellp.woodlandsworld.init;

import com.mcmanuellp.woodlandsworld.item.ItemHungerDebug;
import com.mcmanuellp.woodlandsworld.item.ItemWW;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems
{
    public static final ItemWW hungerDebug = new ItemHungerDebug();

    public static void init()
    {
        GameRegistry.registerItem(hungerDebug, "hungerDebug");
    }
}