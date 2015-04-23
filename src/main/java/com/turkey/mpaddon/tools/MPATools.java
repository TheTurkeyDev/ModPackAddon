package com.turkey.mpaddon.tools;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;

public class MPATools
{
	public static ToolMaterial specialTool = EnumHelper.addToolMaterial("special_tool", 5, 250, 2, 1, 7);
	
	public static ItemTool claySmash;
	public static ItemTool iceSmash;

	public static void loadTools()
	{
		claySmash = new ClaySmasher();
		iceSmash = new IceSmasher();
		
		GameRegistry.registerItem(claySmash, "Clay_Smasher");
		GameRegistry.registerItem(iceSmash, "Ice_Smasher");
	}
}
