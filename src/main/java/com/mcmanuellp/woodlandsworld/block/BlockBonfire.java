package com.mcmanuellp.woodlandsworld.block;

import com.mcmanuellp.woodlandsworld.handler.ConfigurationHandler;
import com.mcmanuellp.woodlandsworld.utility.CalcHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.World;

import java.util.Random;

public class BlockBonfire extends BlockWW_BUSH
{
	public BlockBonfire()
	{
		super(Material.wood);
		this.setTickRandomly(true);
		this.setBlockName("bonfire");
		this.setLightLevel(0.5F);
		this.setBlockBounds(CalcHelper.of16(1), 0, CalcHelper.of16(1), CalcHelper.of16(14), CalcHelper.of16(6), CalcHelper.of16(14));
	}

	/**
	 * WARNING: Wall of text ahead!
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if(true)
		{
			double x = (float)par2;
			double y = (float)par3;
			double z = (float)par4;

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

			if(ConfigurationHandler.bonfireTexture)
			{
				par1World.spawnParticle("smoke", x + dd05, y + d095, z + dd05, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", x + dd05, y + d095, z + dd05, 0.0D, 0.0D, 0.0D);
			}
			else
			{
				par1World.spawnParticle("smoke", x + dd05, y + d030, z + dd05, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", x + dd05, y + d030, z + dd05, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("smoke", x + dd05, y + d040, z + dd05, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", x + dd05, y + d040, z + dd05, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("smoke", x + dd05, y + d050, z + dd05, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", x + dd05, y + d050, z + dd05, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("smoke", x + dd05, y + d060, z + dd05, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", x + dd05, y + d060, z + dd05, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("smoke", x + dd05, y + d070, z + dd05, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", x + dd05, y + d070, z + dd05, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("smoke", x + dd05, y + d080, z + dd05, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", x + dd05, y + d080, z + dd05, 0.0D, 0.0D, 0.0D);

				par1World.spawnParticle("smoke", x + dd04, y + d040, z + dd05, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", x + dd04, y + d040, z + dd05, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("smoke", x + dd04, y + d050, z + dd05, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", x + dd04, y + d050, z + dd05, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("smoke", x + dd04, y + d060, z + dd05, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", x + dd04, y + d060, z + dd05, 0.0D, 0.0D, 0.0D);

				par1World.spawnParticle("smoke", x + dd06, y + d040, z + dd05, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", x + dd06, y + d040, z + dd05, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("smoke", x + dd06, y + d050, z + dd05, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", x + dd06, y + d050, z + dd05, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("smoke", x + dd06, y + d060, z + dd05, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", x + dd06, y + d060, z + dd05, 0.0D, 0.0D, 0.0D);

				par1World.spawnParticle("smoke", x + dd05, y + d040, z + dd04, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", x + dd05, y + d040, z + dd04, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("smoke", x + dd05, y + d050, z + dd04, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", x + dd05, y + d050, z + dd04, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("smoke", x + dd05, y + d060, z + dd04, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", x + dd05, y + d060, z + dd04, 0.0D, 0.0D, 0.0D);

				par1World.spawnParticle("smoke", x + dd05, y + d040, z + dd06, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", x + dd05, y + d040, z + dd06, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("smoke", x + dd05, y + d050, z + dd06, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", x + dd05, y + d050, z + dd06, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("smoke", x + dd05, y + d060, z + dd06, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", x + dd05, y + d060, z + dd06, 0.0D, 0.0D, 0.0D);
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		if(ConfigurationHandler.bonfireTexture)
		{
			blockIcon = iconRegister.registerIcon(String.format("%s_", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
		}
		else
		{
			blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
		}
	}

	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
	{
		return World.doesBlockHaveSolidTopSurface(par1World, par2, par3 - 1, par4);
	}

	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5Block)
	{
		if (!World.doesBlockHaveSolidTopSurface(par1World, par2, par3 - 1, par4))
		{
			par1World.setBlockToAir(par2, par3, par4);
		}
	}
}