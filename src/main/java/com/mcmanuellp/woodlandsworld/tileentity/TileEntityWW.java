package com.mcmanuellp.woodlandsworld.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.tileentity.TileEntity;

public class TileEntityWW extends TileEntity
{
	public static void init()
	{
		GameRegistry.registerTileEntity(TileEntityBonfire.class, "Bonfire");
	}
}