package com.mcmanuellp.woodlandsworld.handler;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BonfireRecipes
{
	private static final BonfireRecipes smeltingBase = new BonfireRecipes();

	private Map smeltingList = new HashMap();
	private Map experienceList = new HashMap();

	public static BonfireRecipes smelting()
	{
		return smeltingBase;
	}

	private BonfireRecipes()
	{
		this.addBlockRecipeToMap(Blocks.log, new ItemStack(Items.coal, 1, 1));
		this.addBlockRecipeToMap(Blocks.log2, new ItemStack(Items.coal, 1, 1));
		this.addBlockRecipeToMap(Blocks.netherrack, new ItemStack(Items.netherbrick));

		this.addItemRecipeToMap(Items.clay_ball, new ItemStack(Items.brick));
		this.addItemRecipeToMap(Items.beef, new ItemStack(Items.cooked_beef));
		this.addItemRecipeToMap(Items.chicken, new ItemStack(Items.cooked_chicken));
		this.addItemRecipeToMap(Items.porkchop, new ItemStack(Items.cooked_porkchop));
		this.addItemRecipeToMap(Items.wheat, new ItemStack(Items.bread));
		this.addItemRecipeToMap(Items.potato, new ItemStack(Items.baked_potato));
		this.addItemRecipeToMap(Items.rotten_flesh, new ItemStack(Items.leather));
		this.addItemRecipeToMap(Items.stick, new ItemStack(Blocks.torch));

		this.addItemStackRecipeToMap(new ItemStack(Items.fish, 1, 0), new ItemStack(Items.cooked_fished, 1, 0));
		this.addItemStackRecipeToMap(new ItemStack(Items.fish, 1, 1), new ItemStack(Items.cooked_fished, 1, 1));
	}

	public void addBlockRecipeToMap(Block component, ItemStack result)
	{
		this.addItemRecipeToMap(Item.getItemFromBlock(component), result);
	}

	public void addItemRecipeToMap(Item component, ItemStack result)
	{
		this.addItemStackRecipeToMap(new ItemStack(component, 1, 32767), result);
	}

	public void addItemStackRecipeToMap(ItemStack component, ItemStack result)
	{
		this.smeltingList.put(component, result);
	}

	public ItemStack getSmeltingResult(ItemStack component)
	{
		Iterator iterator = this.smeltingList.entrySet().iterator();
		Map.Entry entry;

		do
		{
			if (!iterator.hasNext())
			{
				return null;
			}

			entry = (Map.Entry)iterator.next();
		}
		while (!this.compareItemStack(component, (ItemStack) entry.getKey()));

		return (ItemStack)entry.getValue();
	}

	private boolean compareItemStack(ItemStack component, ItemStack result)
	{
		if(component != null)
		{
			return result.getItem() == component.getItem() && (result.getItemDamage() == 32767 || result.getItemDamage() == component.getItemDamage());
		}
		else return false;
	}

	public Map getSmeltingList()
	{
		return this.smeltingList;
	}

	@Deprecated
	public float getSmeltingExperience(ItemStack component)
	{
		float ret = component.getItem().getSmeltingExperience(component);
		if (ret != -1) return ret;

		Iterator iterator = this.experienceList.entrySet().iterator();
		Map.Entry entry;

		do
		{
			if (!iterator.hasNext())
			{
				return 0.0F;
			}

			entry = (Map.Entry)iterator.next();
		}
		while (!this.compareItemStack(component, (ItemStack)entry.getKey()));

		return (Float) entry.getValue();
	}

	public static int getSlotOfItem(ItemStack itemStack, EntityPlayer entityPlayer)
	{
		for (int i = 0; i < entityPlayer.inventory.mainInventory.length; ++i)
		{
			if (entityPlayer.inventory.mainInventory[i] != null && itemStack.areItemStacksEqual(entityPlayer.inventory.mainInventory[i], itemStack))
			{
				return i;
			}
		}

		return -1;
	}

	public static int getSlotOfItemBelow64(ItemStack itemStack, EntityPlayer entityPlayer)
	{
		for (int i = 0; i < entityPlayer.inventory.mainInventory.length; ++i)
		{
			if (entityPlayer.inventory.mainInventory[i] != null && itemStack.areItemStacksEqual(entityPlayer.inventory.mainInventory[i], itemStack) && entityPlayer.inventory.mainInventory[i].stackSize < 64)
			{
				return i;
			}
		}

		return -1;
	}

	public static boolean areSlotOfItemBelow64Available(ItemStack itemStack, EntityPlayer entityPlayer)
	{
		for (int i = 0; i < entityPlayer.inventory.mainInventory.length; ++i)
		{
			if (entityPlayer.inventory.mainInventory[i] != null && itemStack.areItemStacksEqual(entityPlayer.inventory.mainInventory[i], itemStack) && entityPlayer.inventory.mainInventory[i].stackSize < 64)
			{
				return true;
			}
		}

		return false;
	}

	public static boolean smeltItem(EntityPlayer entityPlayer)
	{
		InventoryPlayer inv = entityPlayer.inventory;

		entityPlayer.inventory.inventoryChanged = true;

		if(inv.getFirstEmptyStack() != -1) //space in inv
		{
			if(inv.hasItemStack(smelting().getSmeltingResult(inv.getCurrentItem()))) //does have item
			{
				if(areSlotOfItemBelow64Available(smelting().getSmeltingResult(inv.getCurrentItem()), entityPlayer)) //stack < 64 is available
				{
					--inv.getCurrentItem().stackSize;
					++inv.mainInventory[getSlotOfItemBelow64(smelting().getSmeltingResult(inv.getCurrentItem()), entityPlayer)].stackSize;
					return true;
				}
				else //no stack < 64 available
				{
					--inv.getCurrentItem().stackSize;
					inv.mainInventory[inv.getFirstEmptyStack()] = smelting().getSmeltingResult(inv.getCurrentItem());
					return true;
				}
			}
			else // doesn't have item
			{
				--inv.getCurrentItem().stackSize;
				inv.mainInventory[inv.getFirstEmptyStack()] = smelting().getSmeltingResult(inv.getCurrentItem());
				return true;
			}
		}
		else //no space in inv
		{
			if(inv.hasItemStack(smelting().getSmeltingResult(inv.getCurrentItem()))) //does have item
			{
				if(areSlotOfItemBelow64Available(smelting().getSmeltingResult(inv.getCurrentItem()), entityPlayer)) //stack < 64 is available
				{
					--inv.getCurrentItem().stackSize;
					++inv.mainInventory[getSlotOfItemBelow64(smelting().getSmeltingResult(inv.getCurrentItem()), entityPlayer)].stackSize;
					return true;
				}
				else //no stack < 64 available
				{
					return true;
				}
			}
			else // doesn't have item
			{
				return true;
			}
		}
	}
}