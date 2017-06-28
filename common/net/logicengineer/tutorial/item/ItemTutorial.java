package net.logicengineer.tutorial.item;

import net.logicengineer.tutorial.Tutorial;
import net.logicengineer.tutorial.lib.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemTutorial extends ItemBase{

	public ItemTutorial(String name) {   
		super(name);
	  }

	  /**
	   * Called when the item is right-clicked. By overriding this method, we can changed the behavior of the item! Note
	   * the @Override annotation. You should use these EVERY TIME you override a method. If the method signatures change
	   * between Minecraft versions (and that happens fairly often), you will get a compiler error. This makes porting much,
	   * much easier! Otherwise, you'll have a hard time figuring out why certain methods suddenly aren't being called.
	   */
	  @Override
	  public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {

	    if (!world.isRemote)
	      player.sendMessage(new TextComponentString("You used my item!"));

	    return super.onItemRightClick(world, player, hand);
	  }

	  
}
