package com.mcmanuellp.woodlandsworld.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemHungerDebug extends ItemWW
{
    public ItemHungerDebug()
    {
        super();
        this.setUnlocalizedName("hungerDebug");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
    {
	    if(entityPlayer.isSneaking())
	    {
		    if(entityPlayer.getFoodStats().getFoodLevel() > 0)
		    {
		    	entityPlayer.getFoodStats().setFoodLevel(0);
		    }
		    else
		    {
			    entityPlayer.getFoodStats().setFoodLevel(20);
		    }
	    }
	    else
	    {
		    if(entityPlayer.getFoodStats().getFoodLevel() > 1)
		    {
			    entityPlayer.getFoodStats().addStats(-2, 0F);
		    }
		    else
		    {
			    entityPlayer.getFoodStats().setFoodLevel(0);
		    }
	    }
        return itemStack;
    }
}