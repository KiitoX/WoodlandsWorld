package com.mcmanuellp.woodlandsworld.block;

import com.mcmanuellp.woodlandsworld.utility.CalcHelper;

public class BlockTwig extends BlockWW
{
	public BlockTwig()
	{
		super();
		this.setBlockName("twig");//I should have called it branch ... oh well
		this.setBlockBounds(CalcHelper.of16(4), 0, CalcHelper.of16(4), CalcHelper.of16(12), CalcHelper.of16(8), CalcHelper.of16(12));
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}
}