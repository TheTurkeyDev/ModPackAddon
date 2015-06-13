package com.turkey.mpaddon.item;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class MPAItems
{
	public static Item podirt;
	public static Item acessCard;
	public static Item doorItem1;
	public static Item doorItem2;
	public static Item doorItem3;
	
	public static void loadItems()
	{
		podirt = new PieceOfDirt();
		acessCard  = new AcessCard();
		doorItem1 = new LockedDoorItem();
		doorItem2 = new LockedDoorItem();
		doorItem3 = new LockedDoorItem();
		
		GameRegistry.registerItem(podirt, "Peice_of_dirt");
		GameRegistry.registerItem(acessCard, "Acess_Card");
		GameRegistry.registerItem(doorItem1, "Door_Item1");
		GameRegistry.registerItem(doorItem2, "Door_Item2");
		GameRegistry.registerItem(doorItem3, "Door_Item3");
	}
}
