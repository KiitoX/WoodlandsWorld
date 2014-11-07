package com.mcmanuellp.woodlandsworld.item;

import com.mcmanuellp.woodlandsworld.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemSpawnEntity extends ItemWW
{
	public ItemSpawnEntity()
	{
		super();
		this.setUnlocalizedName("spawnEntity");
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int sideClickedOn, float p_77648_8_, float p_77648_9_, float p_77648_10_)
	{//TODO make it wÖÖÖÖÖÖÖÖÖÖÖrk!
		if(world.isRemote)
		{
			return true;
		}
		else
		{
			if(entityPlayer.isSneaking())
			{
				if(itemStack.hasDisplayName())
				{
					setEntity(itemStack, itemStack.getDisplayName());
					LogHelper.info("EntityName set to: " + itemStack.getTagCompound().getString("Entity"));
					itemStack.func_135074_t();
				}
				else
				{
					setEntity(itemStack, null);
					LogHelper.info("EntityName now set to: -null");
				}

				return true;
			}
			else
			{
				EntityItem entity = new EntityItem(world, x, y + 1.5, z, new ItemStack(itemStack.getItem()));
				entity.motionY = 0.20000000298023224D;
				entity.rotationYaw = (float)(Math.random() * 360.0D);
				world.spawnEntityInWorld(entity);
				return true;
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean yn)
	{
		if(itemStack.getTagCompound().hasNoTags())
		{
			setEntity(itemStack, null);
		}

		NBTTagString nbttagstring;

		if(itemStack.stackTagCompound.getString("Entity") != null)
		{
			nbttagstring = new NBTTagString(itemStack.stackTagCompound.getString("Entity"));
		}
		else
		{
			nbttagstring = new NBTTagString("null");
		}

		list.add(StatCollector.translateToLocal("info.woodlandsworld.spawnEntity.info_0") + ":");

		list.add(StatCollector.translateToLocal("entity." + nbttagstring + ".name"));

		list.add(StatCollector.translateToLocal("info.woodlandsworld.general.pressShift"));

		if(entityPlayer.isSneaking())//TODO get shift called while in inv?
		{
			list.add(StatCollector.translateToLocal("info.woodlandsworld.spawnEntity.info_1"));
			list.add(StatCollector.translateToLocal("info.woodlandsworld.spawnEntity.info_2"));
			list.add(StatCollector.translateToLocal("info.woodlandsworld.spawnEntity.info_3"));
			list.add(StatCollector.translateToLocal("info.woodlandsworld.spawnEntity.info_4") + ": Bat, Creeper, PigZombie, MinecartTNT");
		}
	}

	public void setEntity(ItemStack itemStack, String entity)
	{
		String string;

		if(entity != null)
		{
			string = entity;
		}
		else
		{
			string = "null";
		}

		if (!itemStack.hasTagCompound())
		{
			itemStack.setTagCompound(new NBTTagCompound());
		}

		itemStack.getTagCompound().setString("Entity", string);
	}
}
