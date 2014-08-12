package com.mcmanuellp.woodlandsworld.item;
//Not Tutorial
@Deprecated
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