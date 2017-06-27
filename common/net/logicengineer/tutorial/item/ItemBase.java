package net.logicengineer.tutorial.item;

import net.logicengineer.tutorial.Tutorial;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements ItemModelProvider{
	
	protected String name;
	
	public ItemBase(String name)
	{
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Tutorial.tabTutorial);
	}

	@Override
	public void registerItemModel(Item item) {
		Tutorial.proxy.registerItemRenderer(item, 0, name);		
	}
	
	@Override
	public ItemBase setCreativeTab(CreativeTabs tab)
	{
		super.setCreativeTab(tab);
		return this;
	}

}
