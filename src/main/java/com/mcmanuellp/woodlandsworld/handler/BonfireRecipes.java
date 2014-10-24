package com.mcmanuellp.woodlandsworld.handler;

import com.mcmanuellp.woodlandsworld.block.BlockWW;
import com.mcmanuellp.woodlandsworld.tileentity.TileEntityBonfire;
import com.mcmanuellp.woodlandsworld.utility.SpawnHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@SuppressWarnings("unchecked")
public class BonfireRecipes
{
	private static final BonfireRecipes smeltingBase = new BonfireRecipes();

	private Map smeltingList = new HashMap();

	public static BonfireRecipes smelting()
	{
		return smeltingBase;
	}

	private BonfireRecipes()
	{
		this.addItemStackRecipeToMap(new ItemStack(Blocks.log, 1, 0),
		                             new ItemStack(Items.coal, 1, 1));
		this.addItemStackRecipeToMap(new ItemStack(Blocks.log, 1, 1),
		                             new ItemStack(Items.coal, 1, 1));
		this.addItemStackRecipeToMap(new ItemStack(Blocks.log, 1, 2),
		                             new ItemStack(Items.coal, 1, 1));
		this.addItemStackRecipeToMap(new ItemStack(Blocks.log, 1, 3),
		                             new ItemStack(Items.coal, 1, 1));

		this.addItemStackRecipeToMap(new ItemStack(Blocks.log2, 1, 0),
		                             new ItemStack(Items.coal, 1, 1));
		this.addItemStackRecipeToMap(new ItemStack(Blocks.log2, 1, 1),
		                             new ItemStack(Items.coal, 1, 1));

		this.addItemStackRecipeToMap(new ItemStack(Blocks.netherrack, 1, 0),
		                             new ItemStack(Items.netherbrick, 1, 0));
		this.addItemStackRecipeToMap(new ItemStack(Items.clay_ball, 1, 0),
		                             new ItemStack(Items.brick, 1, 0));
		this.addItemStackRecipeToMap(new ItemStack(Items.beef, 1, 0),
		                             new ItemStack(Items.cooked_beef, 1, 0));
		this.addItemStackRecipeToMap(new ItemStack(Items.chicken, 1, 0),
		                             new ItemStack(Items.cooked_chicken, 1, 0));
		this.addItemStackRecipeToMap(new ItemStack(Items.porkchop, 1, 0),
		                             new ItemStack(Items.cooked_porkchop, 1, 0));
		this.addItemStackRecipeToMap(new ItemStack(Items.wheat, 1, 0),
		                             new ItemStack(Items.bread, 1, 0));
		this.addItemStackRecipeToMap(new ItemStack(Items.potato, 1, 0),
		                             new ItemStack(Items.baked_potato, 1, 0));
		this.addItemStackRecipeToMap(new ItemStack(Items.rotten_flesh, 1, 0),
		                             new ItemStack(Items.leather, 1, 0));
		this.addItemStackRecipeToMap(new ItemStack(Items.stick, 1, 0),
		                             new ItemStack(Blocks.torch, 1, 0));
		this.addItemStackRecipeToMap(new ItemStack(Items.fish, 1, 0),
		                             new ItemStack(Items.cooked_fished, 1, 0));
		this.addItemStackRecipeToMap(new ItemStack(Items.fish, 1, 1),
		                             new ItemStack(Items.cooked_fished, 1, 1));
	}

	@Deprecated
	public void addBlockRecipeToMap(Block component, ItemStack result)
	{
		this.addItemRecipeToMap(Item.getItemFromBlock(component), result);
	}

	@Deprecated
	public void addItemRecipeToMap(Item component, ItemStack result)
	{
		this.addItemStackRecipeToMap(new ItemStack(component, 1, 32767), result);
	}

	public void addItemStackRecipeToMap(ItemStack component, ItemStack result)
	{
		if(component.stackSize != 1)
		{
			component.stackSize = 1;
		}
		if(result.stackSize != 1)
		{
			result.stackSize = 1;
		}

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
		while (!this.compareIS(component, (ItemStack) entry.getKey()));

		return (ItemStack)entry.getValue();
	}

	public boolean compareIS(ItemStack component, ItemStack result)
	{
		return component != null && result.getItem() == component.getItem() && (result.getItemDamage() == 32767 || result.getItemDamage() == component.getItemDamage());
	}

	public Map getSmeltingList()
	{
		return this.smeltingList;
	}

	public static boolean smeltItem(ItemStack itemStack, EntityPlayer entityPlayer, TileEntityBonfire tileEntity, World world, int x, int y, int z)
	{
		InventoryPlayer inv = entityPlayer.inventory;
		ItemStack result = smelting().getSmeltingResult(itemStack);
		ItemStack resultStack = new ItemStack(result.getItem(), 1, result.getItemDamage());

		BlockWW blockWW = BlockWW.blockWW();

		if(tileEntity.hasFuel())
		{
			if(inv.getFirstEmptyStack() != -1)
			{
				// TODO get an better method
				SpawnHelper.spawnItem(world, resultStack, x, y, z);
				entityPlayer.dropPlayerItemWithRandomChoice(resultStack, false);
				blockWW.addItemAndDecreaseHeldItem(entityPlayer, resultStack, 1);
				tileEntity.removeFuel(1);
			}
		}
		return true;
	}

	//--------------------------------V-Unused Methods-V-------------------------------------------------

	public static int getSlotOfItem(ItemStack itemStack, EntityPlayer entityPlayer)
	{
		ItemStack[] mInv = entityPlayer.inventory.mainInventory;

		for (int i = 0; i < mInv.length; ++i)
		{
			if (mInv[i] != null && ItemStack.areItemStacksEqual(mInv[i], itemStack))
			{
				return i;
			}
		}

		return -1;
	}

	public static int getSlotOfItemBelow64(ItemStack itemStack, EntityPlayer entityPlayer)
	{
		ItemStack[] mInv = entityPlayer.inventory.mainInventory;

		for (int i = 0; i < mInv.length; ++i)
		{
			if (mInv[i] != null && ItemStack.areItemStacksEqual(mInv[i], itemStack) && mInv[i].stackSize < 64 && mInv[i].stackSize > 0)
			{
				return i;
			}
		}

		return -1;
	}

	public static boolean areSlotOfItemBelow64Available(ItemStack itemStack, EntityPlayer entityPlayer)
	{
		ItemStack[] mInv = entityPlayer.inventory.mainInventory;

		for(ItemStack aMInv : mInv)
		{
			if(aMInv != null && ItemStack.areItemStacksEqual(aMInv, itemStack) && aMInv.stackSize < 64 && aMInv.stackSize > 0)
			{
				return true;
			}
		}
		return false;
	}
}