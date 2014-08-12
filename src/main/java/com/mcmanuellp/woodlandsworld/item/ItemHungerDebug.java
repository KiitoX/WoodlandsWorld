package com.mcmanuellp.woodlandsworld.item;

import com.mcmanuellp.woodlandsworld.creativetab.CreativeTabWW;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemHungerDebug extends ItemWW
{
    public ItemHungerDebug()
    {
        super();
        this.setUnlocalizedName("hungerDebug");
	    this.setCreativeTab(CreativeTabWW.WW_TAB);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
    {
        return itemStack;//TODO drain either 2 or 20/max saturation
    }
}