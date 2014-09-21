package com.mcmanuellp.woodlandsworld.block;

import com.mcmanuellp.woodlandsworld.creativetab.CreativeTabWW;
import com.mcmanuellp.woodlandsworld.reference.Reference;
import com.mcmanuellp.woodlandsworld.utility.CalcHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockWW extends Block
{
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


	public static void increaseBlockMetadata(World world, int x, int y, int z, int increaseWith, int maxSubBlocks)
	{
		setBlockMetadata(world, x, y, z, world.getBlockMetadata(x, y, z) + increaseWith, maxSubBlocks);
	}

	public static void decreaseBlockMetadata(World world, int x, int y, int z, int decreaseWith, int maxSubBlocks)
	{
		setBlockMetadata(world, x, y, z, world.getBlockMetadata(x, y, z) - decreaseWith, maxSubBlocks);
	}

	public static void setBlockMetadata(World world, int x, int y, int z, int setTo, int maxSubBlocks)
	{
		if(setTo < 0)               {setTo = 0;}
		if(setTo >= maxSubBlocks)   {setTo = maxSubBlocks - 1;}
		world.setBlock(x, y, z, world.getBlock(x, y, z), setTo, 1 & 2);
	}

	public static boolean isMetadataAbove0(IBlockAccess world, int x, int y, int z)
	{
		return world.getBlockMetadata(x, y, z) > 0;
	}

	public static float isMetadataAbove0(World world, int x, int y, int z, float returnsIfTrue, float returnsIfFalse)
	{
		if(world.getBlockMetadata(x, y, z) > 0) {return returnsIfTrue;}
		else                                    {return returnsIfFalse;}
	}

	public void setBlockBoundsOf16(int minX, int minY, int minZ, int maxX, int maxY, int maxZ)
	{
		this.setBlockBounds(CalcHelper.of16(minX), CalcHelper.of16(minY), CalcHelper.of16(minZ), CalcHelper.of16(maxX), CalcHelper.of16(maxY), CalcHelper.of16(maxZ));
	}
}