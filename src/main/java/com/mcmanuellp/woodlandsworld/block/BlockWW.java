package com.mcmanuellp.woodlandsworld.block;

import com.mcmanuellp.woodlandsworld.creativetab.CreativeTabWW;
import com.mcmanuellp.woodlandsworld.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;

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
}