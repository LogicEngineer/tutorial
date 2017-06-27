package net.logicengineer.tutorial.init;

import net.logicengineer.tutorial.Tutorial;
import net.logicengineer.tutorial.item.ItemBase;
import net.logicengineer.tutorial.item.ItemModelProvider;
import net.logicengineer.tutorial.item.ItemOreDict;
import net.logicengineer.tutorial.item.ItemTutorial;
import net.logicengineer.tutorial.lib.Names;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
	
	public static String INVENTORY = "inventory";

	public static ItemTutorial tutorialItem;
	public static ItemBase chasesItem;
	public static ItemTutorial tutorialTestItem;

	public static void init() {

		tutorialItem = new ItemTutorial();
		doRegisterItem(tutorialItem, Names.TUTORIAL_ITEM);
		

		chasesItem = register(new ItemBase(Names.CHASES_ITEM));
		// Setting the registry name is how Forge tells items apart.
		//tutorialItem.setRegistryName(new ResourceLocation(Tutorial.MOD_ID, Names.TUTORIAL_ITEM));
		// Finally, register the item! Must be done AFTER setting the registry
		// name.
		//GameRegistry.register(tutorialItem);

	}

	@SideOnly(Side.CLIENT)
	public static void initClient(ItemModelMesher mesher) {

		// Create a MRL for the model. Note we have two parameters and the
		// second must be "inventory". We can reuse this
		// variable for each item of course, since most Java variables just
		// contain a reference to an object.
		// ModelResourceLocation model = new
		// ModelResourceLocation(Tutorial.RESOURCE_PREFIX + Names.TUTORIAL_ITEM,
		// "inventory");
		// Here we list all models the item can possibly have. An array will
		// work, or just list each MRL for the final
		// parameters.
		// ModelLoader.registerItemVariants(tutorialItem, model);
		// Finally, we associate each MRL (model) with different metadata values
		// for the item. This must be called for each
		// variant! And even if the variants don't depend on metadata, I believe
		// each variant must be registered to a unique
		// meta... In this case, there are no other variants, so we just pass in
		// a metadata of zero.
		// mesher.register(tutorialItem, 0, model);
		
		doRegisterItemModel(tutorialItem, mesher, Names.TUTORIAL_ITEM, INVENTORY);	
		doRegisterItemModel(chasesItem, mesher, Names.CHASES_ITEM, INVENTORY);
	}

	@SideOnly(Side.CLIENT)
	private static void doRegisterItemModel(Item item, ItemModelMesher mesher,
			String ITEM_NAMES_NAME, String MODEL_VIEW_LOCATION) {

		ModelResourceLocation model = new ModelResourceLocation(Tutorial.RESOURCE_PREFIX + ITEM_NAMES_NAME, MODEL_VIEW_LOCATION);
		ModelLoader.registerItemVariants(item, model);
		mesher.register(item, 0, model);
	}
	
	@SideOnly(Side.CLIENT)
	private static void doRegisterItem(Item item, 
			String ITEM_NAMES_NAME) {

		item.setRegistryName(new ResourceLocation(Tutorial.MOD_ID, ITEM_NAMES_NAME));
		GameRegistry.register(item);
	}
	
	private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if (item instanceof ItemModelProvider) {
            ((ItemModelProvider)item).registerItemModel(item);
        }
        if (item instanceof ItemOreDict){
            ((ItemOreDict)item).initOreDict();
        }

        return item;
    }
}
