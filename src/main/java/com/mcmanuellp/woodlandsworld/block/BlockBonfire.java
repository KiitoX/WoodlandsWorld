package com.mcmanuellp.woodlandsworld.block;

import com.mcmanuellp.woodlandsworld.handler.BonfireRecipes;
import com.mcmanuellp.woodlandsworld.handler.ConfigurationHandler;
import com.mcmanuellp.woodlandsworld.tileentity.TileEntityBonfire;
import com.mcmanuellp.woodlandsworld.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Random;

public class BlockBonfire extends BlockWW implements ITileEntityProvider
{
	TileEntityBonfire tileEntity = new TileEntityBonfire();

	public BlockBonfire()
	{
		super(Material.wood);//TODO apply custom TileEntity's for every block (how?)
		this.setHardness(0.8F);
		this.setStepSound(soundTypeWood);
		this.setTickRandomly(true);
		this.setBlockName("bonfire");
		this.setBlockBoundsOf16(2, 0, 2, 14, 6, 14);
		this.isBlockContainer = true;
	}

	//-----------------------------------TileEntity---------------------------------

	public TileEntity createNewTileEntity(World world, int meta)
	{
		return tileEntity;
	}

	//-------------------------------------Metadata---------------------------------

	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings("unchecked")
	public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
	{
		for(int i = 0; i < 16; ++i)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public int damageDropped(int p_149692_1_)
	{
		return 0;
	}

	//-------------------------------------------------------------------------------

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return null;
	}

	@Override
	public boolean isBurning(IBlockAccess world, int x, int y, int z)
	{
		return this.tileEntity.hasFuel();
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public int getRenderType()
	{
		return 1;
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		return World.doesBlockHaveSolidTopSurface(world, x, y - 1, z);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		if (!World.doesBlockHaveSolidTopSurface(world, x, y - 1, z))
		{
			world.setBlockToAir(x, y, z);
			this.dropBlockAsItem(world, x, y, z, 0, 0);
		}
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		if(world.getTileEntity(x, y, z) != null)
		{
			world.addTileEntity(tileEntity);
		}
		else if(world.getTileEntity(x, y, z) != tileEntity)
		{
			world.setTileEntity(x, y, z, tileEntity);
		}
		else if(world.getTileEntity(x, y, z) == tileEntity)
		{
			this.tileEntity = (TileEntityBonfire)world.getTileEntity(x, y, z);
		}

		if(this.tileEntity.hasFuel())
		{
			this.setLightLevel(0.8F);
		}
		else
		{
			this.setLightLevel(0.0F);
		}
	}

	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer entityPlayer)
	{
		if(this.tileEntity.hasFuel())
		{
			this.setLightLevel(0.8F);
		}
		else
		{
			this.setLightLevel(0.0F);
		}
	}

	public void onBlockPreDestroy(World p_149725_1_, int p_149725_2_, int p_149725_3_, int p_149725_4_, int p_149725_5_)
	{
		this.tileEntity.invalidate();
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
	 * @return              has to be true anyways?? maybe
	 */

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float p_149727_7_, float p_149727_8_, float p_149727_9_)
	{
		InventoryPlayer inv = entityPlayer.inventory;
		ItemStack invC = inv.getCurrentItem();
		BonfireRecipes bbq = BonfireRecipes.smelting();
		BlockWW bww = BlockWW.blockWW();

		onBlockClicked(world, x, y, z, entityPlayer);

		if(world.isRemote)
		{
			return true;
		}
		else
		{
			if(invC != null)
			{
				ItemStack invCi = new ItemStack(invC.getItem(), 1, invC.getItemDamage());

				if(bbq.compareIS(invCi, bww.setIS(Items.coal, 1, 0)) ||
				   bbq.compareIS(invCi, bww.setIS(Items.coal, 1, 1)))
				{
					bww.decItem(entityPlayer, invC);
					this.tileEntity.addFuel(8);
					LogHelper.info("FuelLevel: " + this.tileEntity.getFuel());
				}
				if(bbq.compareIS(invCi, bww.setIS(Blocks.planks, 1, 0)) ||
				   bbq.compareIS(invCi, bww.setIS(Blocks.planks, 1, 1)) ||
				   bbq.compareIS(invCi, bww.setIS(Blocks.planks, 1, 2)) ||
				   bbq.compareIS(invCi, bww.setIS(Blocks.planks, 1, 3)) ||
				   bbq.compareIS(invCi, bww.setIS(Blocks.planks, 1, 4)) ||
				   bbq.compareIS(invCi, bww.setIS(Blocks.planks, 1, 5)))
				{
					bww.decItem(entityPlayer, invC);

					this.tileEntity.addFuel(1);
					LogHelper.info("FuelLevel: " + this.tileEntity.getFuel());
				}
				if(bbq.compareIS(invCi, bww.setIS(Items.water_bucket)))
				{
					bww.decItem(entityPlayer, Items.water_bucket);
					bww.incItem(entityPlayer, Items.bucket);

					this.tileEntity.setFuel(0);
					LogHelper.info("FuelLevel: " + this.tileEntity.getFuel());
				}
				if(bbq.compareIS(invCi, bww.setIS(Items.diamond)))
				{
					LogHelper.info("FuelLevel: " + this.tileEntity.getFuel());
				}
				if(bbq.getSmeltingResult(invCi) != null)
				{
					BonfireRecipes.smeltItem(invCi, entityPlayer, this.tileEntity, world, x, y, z);
				}
				return true;
			}
			else
			{
				LogHelper.info("Empty Handed?");
				return false;
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		double x1 = (float)x;
		double y1 = (float)y;
		double z1 = (float)z;

		double O = 0;

		if(this.tileEntity.hasFuel())
		{
			if(random.nextInt(24) == 0)
			{
				world.playSound((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), "fire.fire", 1.0F + random.nextFloat(), random.nextFloat() * 0.7F + 0.3F, false);
			}

			if(ConfigurationHandler.bonfireTexture)
			{
				world.spawnParticle("smoke", x1 + 0.5F, y1 + 0.95F, z1 + 0.5F, O, O, O);
				world.spawnParticle("flame", x1 + 0.5F, y1 + 0.95F, z1 + 0.5F, O, O, O);
			}
			else
			{
				for(double a = 0.4F; a < 0.7F; a += 0.1F)
				{
					world.spawnParticle("smoke", x1 + 0.5F, y1 + a, z1 + 0.4F, O, O, O);
					world.spawnParticle("flame", x1 + 0.5F, y1 + a, z1 + 0.4F, O, O, O);
				}

				for(double a = 0.4F; a < 0.7F; a += 0.1F)
				{
					world.spawnParticle("smoke", x1 + 0.4F, y1 + a, z1 + 0.5F, O, O, O);
					world.spawnParticle("flame", x1 + 0.4F, y1 + a, z1 + 0.5F, O, O, O);
				}

				for(double a = 0.3F; a < 0.9F; a += 0.1F)
				{
					world.spawnParticle("smoke", x1 + 0.5F, y1 + a, z1 + 0.5F, O, O, O);
					world.spawnParticle("flame", x1 + 0.5F, y1 + a, z1 + 0.5F, O, O, O);
				}

				for(double a = 0.4F; a < 0.7F; a += 0.1F)
				{
					world.spawnParticle("smoke", x1 + 0.6F, y1 + a, z1 + 0.5F, O, O, O);
					world.spawnParticle("flame", x1 + 0.6F, y1 + a, z1 + 0.5F, O, O, O);
				}

				for(double a = 0.4F; a < 0.7F; a += 0.1F)
				{
					world.spawnParticle("smoke", x1 + 0.5F, y1 + a, z1 + 0.6F, O, O, O);
					world.spawnParticle("flame", x1 + 0.5F, y1 + a, z1 + 0.6F, O, O, O);
				}
			}
		}
	}
}