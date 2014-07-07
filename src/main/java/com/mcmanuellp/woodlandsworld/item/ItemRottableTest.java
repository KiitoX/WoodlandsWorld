package com.mcmanuellp.woodlandsworld.item;

public class ItemRottableTest extends ItemFoodRottable
{
    public ItemRottableTest()
    {
        super();
        this.setUnlocalizedName("rottableTest");
        this.getTickMax(10);
        this.tickEvent();
    }
}