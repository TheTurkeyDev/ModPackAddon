package mpaddon;

import mpaddon.tools.MPATools;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingRecipies
{

	public void loadRecipies()
	{
		GameRegistry.addShapedRecipe(new ItemStack(MPATools.iceSmash), "ICC"," S ", " S ", 'I', new ItemStack(Items.iron_ingot), 'C', new ItemStack(Blocks.cobblestone), 'S', new ItemStack(Items.stick));
		GameRegistry.addShapedRecipe(new ItemStack(MPATools.claySmash), "I","C", "S", 'I', new ItemStack(Items.iron_ingot), 'C', new ItemStack(Blocks.cobblestone), 'S', new ItemStack(Items.stick));
	}
}
