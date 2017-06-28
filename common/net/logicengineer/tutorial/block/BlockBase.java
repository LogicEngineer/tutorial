package net.logicengineer.tutorial.block;

import net.logicengineer.tutorial.Tutorial;
import net.logicengineer.tutorial.item.ItemModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockBase extends Block implements ItemModelProvider {
	protected String name;

	public BlockBase(Material materialIn, String name) {
		super(materialIn);
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
    public BlockBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

}
