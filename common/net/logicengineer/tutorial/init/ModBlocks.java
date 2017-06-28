package net.logicengineer.tutorial.init;

import net.logicengineer.tutorial.Tutorial;
import net.logicengineer.tutorial.block.BlockBase;
import net.logicengineer.tutorial.block.BlockTutorial;
import net.logicengineer.tutorial.item.ItemModelProvider;
import net.logicengineer.tutorial.item.ItemOreDict;
import net.logicengineer.tutorial.lib.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {
	
	public static BlockTutorial tutorialBlock;
	public static BlockBase chasesBlock;

	/**
	 * The common initializer. Registers blocks, but not models. Should be
	 * called during preInit.
	 */
	public static void init() {

		tutorialBlock = register(new BlockTutorial(Material.IRON, Names.TUTORIAL_BLOCK));
		
		chasesBlock = register(new BlockBase(Material.IRON, Names.CHASES_BLOCK));
		
		
	}
	
	private static <T extends Block> T register(T block, ItemBlock itemBlock) {
        GameRegistry.register(block);
        if(itemBlock != null) {
            GameRegistry.register(itemBlock);

            if (block instanceof ItemModelProvider) {
                ((ItemModelProvider) block).registerItemModel(itemBlock);
            }
            if (block instanceof ItemOreDict) {
                ((ItemOreDict)block).initOreDict();
            }
            if (itemBlock instanceof ItemOreDict) {
                ((ItemOreDict)itemBlock).initOreDict();
            }
        }
        return block;
    }

    private static <T extends Block> T register(T block) {
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(block.getRegistryName());
        return register(block, itemBlock);
    }
}
