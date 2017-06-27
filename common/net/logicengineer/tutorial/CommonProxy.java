package net.logicengineer.tutorial;

import net.logicengineer.tutorial.init.ModBlocks;
import net.logicengineer.tutorial.init.ModItems;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	
	public void registerItemRenderer(Item item, int meta, String id){
		
	}

	public void preInit(FMLPreInitializationEvent event) {
		ModItems.init();
		ModBlocks.init();
	}
	
	public void init(FMLInitializationEvent event) {
		
	}
	
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
