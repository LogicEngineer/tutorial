package net.logicengineer.tutorial.recipes;

import net.logicengineer.tutorial.init.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ModRecipes {
	public static void init()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.chasesItem), ModItems.tutorialItem);
	}

}
