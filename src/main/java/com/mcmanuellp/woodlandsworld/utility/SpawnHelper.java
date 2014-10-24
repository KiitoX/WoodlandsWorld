package com.mcmanuellp.woodlandsworld.utility;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SpawnHelper
{
	public static void spawnItem(World world, ItemStack itemStack, int x, int y, int z)//TODO fix?
	{
		if(itemStack != null && itemStack.stackSize != 0)
		{
			EntityItem entityitem = new EntityItem(world, x, y + 1.5, z, new ItemStack(itemStack.getItem(), 1, itemStack.getItemDamage()));
			entityitem.motionY = 0.20000000298023224D;
			entityitem.rotationYaw = (float)(Math.random() * 360.0D);
			world.spawnEntityInWorld(entityitem);
		}
	}
}
