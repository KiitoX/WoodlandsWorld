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
        return itemStack;//drain either 2 or 20/max saturation
    }
}