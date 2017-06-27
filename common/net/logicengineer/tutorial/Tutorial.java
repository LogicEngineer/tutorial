package net.logicengineer.tutorial;

import java.util.Random;

import net.logicengineer.tutorial.init.ModItems;
import net.logicengineer.tutorial.recipes.ModRecipes;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = Tutorial.MOD_ID, name = Tutorial.MOD_NAME, version = Tutorial.VERSION, dependencies = Tutorial.DEPENDENCIES)
public class Tutorial {

	// constants
	public static final String MOD_ID = "tutorial";
	public static final String MOD_NAME = "JOE'S TUTORIAL MOD";
	public static final String VERSION = "@VERSION@";
	public static final String DEPENDENCIES = "required-after:forge@[13.20.0.2228,)";
	public static final String RESOURCE_PREFIX = MOD_ID.toLowerCase() + ":";

	// variables
	public static Random random = new Random();

	@Instance(MOD_ID)
	public static Tutorial instance;

	@SidedProxy(clientSide = "net.logicengineer.tutorial.ClientProxy", serverSide = "net.logicengineer.tutorial.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	@EventHandler
	public void Init(FMLInitializationEvent event) {
		proxy.init(event);
		ModRecipes.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}

	public static CreativeTabs tabTutorial = new CreativeTabs(Tutorial.RESOURCE_PREFIX + "creative_tab") {

		@Override
		public ItemStack getTabIconItem() {

			return new ItemStack(ModItems.tutorialItem);
		}
	};
}
