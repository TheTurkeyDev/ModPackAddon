package com.turkey.mpaddon.item;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class MPAItems
{
	public static Item podirt;
	
	public static void loadItems()
	{
		podirt = new PieceOfDirt();
		
		GameRegistry.registerItem(podirt, "Peice_of_dirt");
	}
}
