package com.mcmanuellp.woodlandsworld.init;

import com.mcmanuellp.woodlandsworld.item.ItemFoodRottable;
import com.mcmanuellp.woodlandsworld.item.ItemHungerDebug;
import com.mcmanuellp.woodlandsworld.item.ItemRottableTest;
import com.mcmanuellp.woodlandsworld.item.ItemWW;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems
{
    public static final ItemWW hungerDebug = new ItemHungerDebug();
    public static final ItemFoodRottable rottableTest = new ItemRottableTest();

    public static void init()
    {
        GameRegistry.registerItem(hungerDebug, "hungerDebug");
        GameRegistry.registerItem(rottableTest, "rottableTest");
    }
}