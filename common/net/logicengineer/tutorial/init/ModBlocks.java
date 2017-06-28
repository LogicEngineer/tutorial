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

	public static String INVENTORY = "inventory";
	
	public static BlockTutorial tutorialBlock;
	public static BlockBase chasesBlock;

	/**
	 * The common initializer. Registers blocks, but not models. Should be
	 * called during preInit.
	 */
	public static void init() {

		tutorialBlock = new BlockTutorial();
		doRegisterBlock(tutorialBlock, Names.TUTORIAL_BLOCK);
		
		chasesBlock = register(new BlockBase(Material.IRON, Names.CHASES_BLOCK));
		
	}

	/**
	 * Here we should call the addRecipes method for all blocks that have one.
	 * Should be called during the init phase.
	 */
	public static void initRecipes() {

		 tutorialBlock.addRecipes();
	}

	/**
	 * The client-side initializer. Here we handle model registration. Don't
	 * forget the @SideOnly annotation! This should be called during init.
	 */
	@SideOnly(Side.CLIENT)
	public static void initClient(ItemModelMesher mesher) {

		doRegisterBlockModel(tutorialBlock, mesher, Names.TUTORIAL_BLOCK, INVENTORY);
	}

	@SideOnly(Side.CLIENT)
	private static void doRegisterBlockModel(Block block, ItemModelMesher mesher, String BLOCK_NAMES_NAME,
			String MODEL_VIEW_LOCATION) {

		Item item = Item.getItemFromBlock(block);

		ModelResourceLocation model = new ModelResourceLocation(Tutorial.RESOURCE_PREFIX + BLOCK_NAMES_NAME,
				MODEL_VIEW_LOCATION);
		ModelLoader.registerItemVariants(item, model);
		mesher.register(item, 0, model);
	}

	@SideOnly(Side.CLIENT)
	private static void doRegisterBlock(Block block, String BLOCK_NAMES_NAME) {

		ResourceLocation location = new ResourceLocation(Tutorial.MOD_ID, BLOCK_NAMES_NAME);
		block.setRegistryName(location);
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block), location);
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
