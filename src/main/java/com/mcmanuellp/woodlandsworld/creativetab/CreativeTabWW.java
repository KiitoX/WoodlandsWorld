package com.mcmanuellp.woodlandsworld.creativetab;

import com.mcmanuellp.woodlandsworld.init.ModItems;
import com.mcmanuellp.woodlandsworld.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabWW
{
	public static final CreativeTabs WW_TAB = new CreativeTabs(Reference.MOD_ID)
	{
		@Override
		public Item getTabIconItem()
		{
			return ModItems.hungerDebug;
		}

		@Override
		public String getTranslatedTabLabel()
		{
			return "Woodlands World";
		}
	};
}