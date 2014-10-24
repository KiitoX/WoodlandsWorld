package com.mcmanuellp.woodlandsworld.block;

import com.mcmanuellp.woodlandsworld.creativetab.CreativeTabWW;
import com.mcmanuellp.woodlandsworld.reference.Reference;
import com.mcmanuellp.woodlandsworld.utility.CalcHelper;
import com.mcmanuellp.woodlandsworld.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockWW extends Block
{
	private static final BlockWW block = new BlockWW();

	public static BlockWW blockWW()
	{
		return block;
	}

	public BlockWW(Material material, CreativeTabs tab)
	{
		super(material);
		this.setCreativeTab(tab);
	}

	public BlockWW(Material material)
	{
		super(material);
		this.setCreativeTab(CreativeTabWW.WW_TAB);
	}

	public BlockWW()
	{
		super(Material.rock);
		this.setCreativeTab(CreativeTabWW.WW_TAB);
	}

	@Override
	public String getUnlocalizedName()
	{
		return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));

	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

	//---------------------------------------Own Added Methods------------------------

	public void setBlockBoundsOf16(int minX, int minY, int minZ, int maxX, int maxY, int maxZ)
	{
		this.setBlockBounds(CalcHelper.of16(minX), CalcHelper.of16(minY), CalcHelper.of16(minZ), CalcHelper.of16(maxX), CalcHelper.of16(maxY), CalcHelper.of16(maxZ));
	}

	public ItemStack setIS(Item item, int meta, int size)
	{
		return new ItemStack(item, meta, size);
	}

	public ItemStack setIS(Item item)
	{
		return new ItemStack(item);
	}

	public ItemStack setIS(Block block, int meta, int size)
	{
		return new ItemStack(block, meta, size);
	}

	public ItemStack setIS(Block block)
	{
		return new ItemStack(block);
	}

	public void incItem(EntityPlayer entityPlayer, ItemStack toAdd)
	{
		entityPlayer.inventory.addItemStackToInventory(toAdd);
	}

	public void incItem(EntityPlayer entityPlayer, Item toAdd, int meta, int size)
	{
		entityPlayer.inventory.addItemStackToInventory(setIS(toAdd, meta, size));
	}

	public void incItem(EntityPlayer entityPlayer, Item toAdd)
	{
		entityPlayer.inventory.addItemStackToInventory(setIS(toAdd));
	}

	public void decItem(EntityPlayer entityPlayer, ItemStack toRem)
	{
		entityPlayer.inventory.consumeInventoryItem(toRem.getItem());
	}

	public void decItem(EntityPlayer entityPlayer, Item toRem)
	{
		entityPlayer.inventory.consumeInventoryItem(toRem);
	}

	public void decreaseSizeHeldItem(EntityPlayer entityPlayer, int decreaseBy)
	{
		entityPlayer.inventory.getCurrentItem().stackSize -= decreaseBy;
	}

	public void addItemAndDecreaseHeldItem(EntityPlayer entityPlayer, ItemStack toAdd, int decreaseBy)
	{
		decreaseSizeHeldItem(entityPlayer, decreaseBy);
		incItem(entityPlayer, toAdd);
	}
}