package com.mcmanuellp.woodlandsworld.block;

import com.mcmanuellp.woodlandsworld.handler.BonfireRecipes;
import com.mcmanuellp.woodlandsworld.handler.ConfigurationHandler;
import com.mcmanuellp.woodlandsworld.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class BlockBonfire extends BlockWW
{
	public static final int maxSubBlocks = 16;

	public BlockBonfire()
	{
		super(Material.wood);//TODO fix Creative Tabs & SubBlocks or change Metadata to TileEntity (how?)
		this.setHardness(0.8F);
		this.setStepSound(soundTypeWood);
		this.setTickRandomly(true);
		this.setBlockName("bonfire");
		this.setBlockBoundsOf16(2, 0, 2, 14, 6, 14);
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
	{
		for(int i = 0; i < maxSubBlocks; ++i)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}

	public int damageDropped(int p_149692_1_)
	{
		return 0;
	}

	//---------------------------------------------------

	public boolean isBurning(IBlockAccess world, int x, int y, int z)
	{
		return isMetadataAbove0(world, x, y, z);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return null;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public int getRenderType()
	{
		return 1;
	}

	public void onBlockAdded(World world, int x, int y, int z)
	{
		this.setLightLevel(isMetadataAbove0(world, x, y, z, 0.8F, 0.0F));
	}

	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer entityPlayer)
	{
		this.setLightLevel(isMetadataAbove0(world, x, y, z, 0.8F, 0.0F));

		setBlockMetadata(world, x, y, z, world.getBlockMetadata(x, y, z), maxSubBlocks);
	}

	/**
	 * WARNING: Wall of text ahead!
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		double x1 = (float)x;
		double y1 = (float)y;
		double z1 = (float)z;

		double dd04 = 0.4F;
		double dd05 = 0.5F;
		double dd06 = 0.6F;

		double d030 = 0.30F;
		double d040 = 0.40F;
		double d050 = 0.50F;
		double d060 = 0.60F;
		double d070 = 0.70F;
		double d080 = 0.80F;
		double d095 = 0.95F;

		if(isMetadataAbove0(world, x, y, z))
		{
			if(random.nextInt(24) == 0)
			{
				world.playSound((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), "fire.fire", 1.0F + random.nextFloat(), random.nextFloat() * 0.7F + 0.3F, false);
			}

			if(ConfigurationHandler.bonfireTexture)
			{
				world.spawnParticle("smoke", x1 + dd05, y1 + d095, z1 + dd05, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", x1 + dd05, y1 + d095, z1 + dd05, 0.0D, 0.0D, 0.0D);
			}
			else
			{
				world.spawnParticle("smoke", x1 + dd05, y1 + d030, z1 + dd05, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", x1 + dd05, y1 + d030, z1 + dd05, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("smoke", x1 + dd05, y1 + d040, z1 + dd05, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", x1 + dd05, y1 + d040, z1 + dd05, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("smoke", x1 + dd05, y1 + d050, z1 + dd05, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", x1 + dd05, y1 + d050, z1 + dd05, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("smoke", x1 + dd05, y1 + d060, z1 + dd05, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", x1 + dd05, y1 + d060, z1 + dd05, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("smoke", x1 + dd05, y1 + d070, z1 + dd05, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", x1 + dd05, y1 + d070, z1 + dd05, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("smoke", x1 + dd05, y1 + d080, z1 + dd05, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", x1 + dd05, y1 + d080, z1 + dd05, 0.0D, 0.0D, 0.0D);

				world.spawnParticle("smoke", x1 + dd04, y1 + d040, z1 + dd05, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", x1 + dd04, y1 + d040, z1 + dd05, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("smoke", x1 + dd04, y1 + d050, z1 + dd05, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", x1 + dd04, y1 + d050, z1 + dd05, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("smoke", x1 + dd04, y1 + d060, z1 + dd05, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", x1 + dd04, y1 + d060, z1 + dd05, 0.0D, 0.0D, 0.0D);

				world.spawnParticle("smoke", x1 + dd06, y1 + d040, z1 + dd05, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", x1 + dd06, y1 + d040, z1 + dd05, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("smoke", x1 + dd06, y1 + d050, z1 + dd05, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", x1 + dd06, y1 + d050, z1 + dd05, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("smoke", x1 + dd06, y1 + d060, z1 + dd05, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", x1 + dd06, y1 + d060, z1 + dd05, 0.0D, 0.0D, 0.0D);

				world.spawnParticle("smoke", x1 + dd05, y1 + d040, z1 + dd04, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", x1 + dd05, y1 + d040, z1 + dd04, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("smoke", x1 + dd05, y1 + d050, z1 + dd04, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", x1 + dd05, y1 + d050, z1 + dd04, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("smoke", x1 + dd05, y1 + d060, z1 + dd04, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", x1 + dd05, y1 + d060, z1 + dd04, 0.0D, 0.0D, 0.0D);

				world.spawnParticle("smoke", x1 + dd05, y1 + d040, z1 + dd06, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", x1 + dd05, y1 + d040, z1 + dd06, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("smoke", x1 + dd05, y1 + d050, z1 + dd06, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", x1 + dd05, y1 + d050, z1 + dd06, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("smoke", x1 + dd05, y1 + d060, z1 + dd06, 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", x1 + dd05, y1 + d060, z1 + dd06, 0.0D, 0.0D, 0.0D);
			}
		}
	}

	/**
	 * Called upon block activation (right click on the block.)
	 *
	 * @param world         dimension the block is in
	 * @param x             int x Coordinate
	 * @param y             int y Coordinate
	 * @param z             int z Coordinate
	 * @param entityPlayer  player that interacted
	 * @param side          int side player interacted with (0=bottom, 1=top, 2=north, 3=south, 4=west, 5=east)
	 * @param p_149727_7_   float camera yaw
	 * @param p_149727_8_   float camera yaw
	 * @param p_149727_9_   float camera yaw
	 *
	 * @return              has to be true anyways
	 */

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float p_149727_7_, float p_149727_8_, float p_149727_9_)
	{
		InventoryPlayer inv = entityPlayer.inventory;
		BonfireRecipes bbq = BonfireRecipes.smelting();

		if(entityPlayer.getHeldItem() != null)
		{
			if(bbq.compareItemStack(inv.getCurrentItem(), new ItemStack(Items.coal, 1, 0)) ||
			   bbq.compareItemStack(inv.getCurrentItem(), new ItemStack(Items.coal, 1, 1)))
			{
				if(world.getBlockMetadata(x, y, z) < maxSubBlocks - 1)
				{
					--inv.getCurrentItem().stackSize;
					increaseBlockMetadata(world, x, y, z, 8, maxSubBlocks);
					LogHelper.info("Block Metadata of: " + x + " : " + y + " : " + z + " : " + world.getBlockMetadata(x, y, z));
				}
			}
			if(bbq.compareItemStack(inv.getCurrentItem(), new ItemStack(Blocks.planks, 1, 0)) ||
			   bbq.compareItemStack(inv.getCurrentItem(), new ItemStack(Blocks.planks, 1, 1)) ||
			   bbq.compareItemStack(inv.getCurrentItem(), new ItemStack(Blocks.planks, 1, 2)) ||
			   bbq.compareItemStack(inv.getCurrentItem(), new ItemStack(Blocks.planks, 1, 3)) ||
			   bbq.compareItemStack(inv.getCurrentItem(), new ItemStack(Blocks.planks, 1, 4)) ||
			   bbq.compareItemStack(inv.getCurrentItem(), new ItemStack(Blocks.planks, 1, 5)))
			{
				if(world.getBlockMetadata(x, y, z) < maxSubBlocks - 1)
				{
					--inv.getCurrentItem().stackSize;
					increaseBlockMetadata(world, x, y, z, 1, maxSubBlocks);
					LogHelper.info("Block Metadata of: " + x + " : " + y + " : " + z + " : " + world.getBlockMetadata(x, y, z));
				}
			}
			if(bbq.compareItemStack(inv.getCurrentItem(), new ItemStack(Items.water_bucket)))
			{
				inv.consumeInventoryItem(Items.water_bucket);
				inv.addItemStackToInventory(new ItemStack(Items.bucket));
				setBlockMetadata(world, x, y, z, 0, maxSubBlocks);
			}
			if(bbq.compareItemStack(inv.getCurrentItem(), new ItemStack(Items.diamond)))
			{
				LogHelper.info("Block Metadata of: " + x + " : " + y + " : " + z + " : " + world.getBlockMetadata(x, y, z));
			}
			if(bbq.getSmeltingResult(inv.getCurrentItem()) != null)
			{
				BonfireRecipes.smeltItem(entityPlayer, world, x, y, z);
			//	inv.inventoryChanged = false;//------------------------???maybe???
			}
		}
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		if(ConfigurationHandler.bonfireTexture)
		{
			blockIcon = iconRegister.registerIcon(String.format("%s_old", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
		}
		else
		{
			blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
		}
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		return World.doesBlockHaveSolidTopSurface(world, x, y - 1, z);
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		if (!World.doesBlockHaveSolidTopSurface(world, x, y - 1, z))
		{
			world.setBlockToAir(x, y, z);
		}
	}
}