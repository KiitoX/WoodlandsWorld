package com.mcmanuellp.woodlandsworld.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Recipes
{
	public static void init()
	{
	/**	GameRegistry.addShapedRecipe(new ItemStack(ModItems.hungerDebug), " p ", "ppp", " p ",
								'p', new ItemStack(Items.porkchop));  //example for shaped

		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.logPile),
										new ItemStack(Blocks.log),
										new ItemStack(Blocks.log),
										new ItemStack(Blocks.log),
										new ItemStack(Blocks.log));  //example for shapeless
	 */

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.hungerDebug), " p ", "pdp", " p ",
						  'p', new ItemStack(Items.porkchop), 'd', "dyePink"));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.logPile), "logWood", "logWood", "logWood", "logWood",
													  new ItemStack(Items.string)));
	}
}