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
		
		//TutorialItems
		tutorialItem = register(new ItemTutorial(Names.TUTORIAL_ITEM));
		
		//ItemBase
		chasesItem = register(new ItemBase(Names.CHASES_ITEM));		

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
