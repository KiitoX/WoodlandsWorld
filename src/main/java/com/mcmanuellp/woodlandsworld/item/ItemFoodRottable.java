package com.mcmanuellp.woodlandsworld.item;

import com.mcmanuellp.woodlandsworld.utility.LogHelper;

public class ItemFoodRottable extends ItemWW
{
    public static int expireMax;
    public static int expireTime;

    public int getTickMax(int max)
    {
        max = expireMax;
        LogHelper.info("Hi now look closely: " + expireMax);
        return expireMax;
    }

    public void tickEvent()
    {
        // needs regular ticks to add up

        for(int i = 0; i >= expireMax; i++)
        {
            if(expireTime <= expireMax)
            {
                LogHelper.info("State: " + expireTime + " of " + expireMax);
                expireTime++;
            }
            else
            {
                LogHelper.info("Item expired!");
            }
        }

    }
}