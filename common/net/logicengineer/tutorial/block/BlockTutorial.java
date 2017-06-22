package net.logicengineer.tutorial.block;

import net.logicengineer.tutorial.Tutorial;
import net.logicengineer.tutorial.lib.Names;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class BlockTutorial extends Block{

	public BlockTutorial() {
		
		super(Material.IRON);
		setHardness(4.0f);
		setResistance(10.0f);
		setSoundType(SoundType.SLIME);
		setHarvestLevel("pickaxe", 2);
		setCreativeTab(Tutorial.tabTutorial);
		
	}
	
	public void addRecipes() {

	    /* Shaped recipes require a specific layout, while shapless do not. Let's break down the first one here:
	     * @formatter:off (this turns off the formatter (Ctrl+Shift+F) so it doesn't screw up this comment)
	     * 
	     * GameRegistry.addShapedRecipe(  // addShapedRecipe is for shaped recipes not using the ore
	     *                                // dicitonary. If you need the oredict, use
	     *                                // addRecipe(new ShapedOreRecipe(...)) instead.
	     *    new ItemStack(this),        // The output. You can also specify and count and meta data
	     *                                // if needed. See the other ItemStack constructors.
	     *    " l ",                      // First row. You can have 1-3 rows. Each row can have 1-3
	     *                                // characters, but each row must be the same length! Use
	     *                                // spaces if you want nothing in that slot. Do not remove
	     *                                // leading or trailing spaces!
	     *    "lwl",                      // Second row
	     *    " l ",                      // Third row
	     *    'l', Blocks.LADDER,         // The remaining parameters should be pairs of characters
	     *                                // followed by Blocks, Items, or ItemStacks. You can use
	     *                                // oredict keys as well in ShapedOreRecipes.
	     *    'w', new ItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE));
	     *                                // OreDictionary.WILDCARD_VALUE allows any damage/meta value
	     *                                // to be used.
	     * @formatter:on (turn the formatter back on past the section you don't want it to touch)
	     */

	    GameRegistry.addShapedRecipe(new ItemStack(this), " l ", "lwl", " l ", 'l', Blocks.LADDER, 'w',
	        new ItemStack(Blocks.WOOL, 1, OreDictionary.WILDCARD_VALUE));
	    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(this), "dld", "lwl", "dld", 'l',
	        Blocks.LADDER, 'w', Blocks.WOOL, 'd', "dyeBlack"));
	  }

	
	@Override
	public String getUnlocalizedName()
	{
		return "tile." + Tutorial.RESOURCE_PREFIX + Names.TUTORIAL_BLOCK;
	}
}
