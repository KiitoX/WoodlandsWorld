package com.mcmanuellp.woodlandsworld.init;

import com.mcmanuellp.woodlandsworld.item.ItemHungerDebug;
import com.mcmanuellp.woodlandsworld.item.ItemWW;
import com.mcmanuellp.woodlandsworld.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final ItemWW hungerDebug = new ItemHungerDebug();

    public static void init()
    {
        GameRegistry.registerItem(hungerDebug, "hungerDebug");
    }
}