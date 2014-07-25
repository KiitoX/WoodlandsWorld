package com.mcmanuellp.woodlandsworld.init;

import com.mcmanuellp.woodlandsworld.block.BlockLogPile;
import com.mcmanuellp.woodlandsworld.block.BlockWW;
import com.mcmanuellp.woodlandsworld.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockWW logPile = new BlockLogPile();

    public static void init()
    {
        GameRegistry.registerBlock(logPile, "logPile");
    }
}