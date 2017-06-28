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

public class BlockTutorial extends BlockBase{

	public BlockTutorial(Material materialIn, String name) {		
		super(materialIn, name);
		setHardness(4.0f);
		setResistance(10.0f);
		setSoundType(SoundType.SLIME);
		setHarvestLevel("pickaxe", 2);		
	}
}
