package com.mcmanuellp.woodlandsworld.init;

import com.mcmanuellp.woodlandsworld.block.*;
import com.mcmanuellp.woodlandsworld.reference.Reference;
import com.mcmanuellp.woodlandsworld.utility.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockWW logPile = new BlockLogPile();
	public static final BlockWW bonfire = new BlockBonfire();
	public static final BlockWW twig = new BlockTwig();


    public static void init()
    {
	    LogHelper.info(logPile.toString());
        GameRegistry.registerBlock(logPile, "logPile");
	    GameRegistry.registerBlock(bonfire, "bonfire");
	    GameRegistry.registerBlock(twig, "twig");
    }
}