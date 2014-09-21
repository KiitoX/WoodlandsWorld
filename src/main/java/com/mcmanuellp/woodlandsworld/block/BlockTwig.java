package com.mcmanuellp.woodlandsworld.block;

public class BlockTwig extends BlockWW
{
	public BlockTwig()
	{
		super();
		this.setBlockName("twig");//I should have called it branch ... oh well
		this.setBlockBoundsOf16(4, 0, 4, 12, 8, 12);
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