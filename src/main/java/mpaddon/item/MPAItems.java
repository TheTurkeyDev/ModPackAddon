package mpaddon.item;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class MPAItems
{
	public static Item podirt;
	public static Item accessCard;
	public static Item lockedDoor1;
	public static Item lockedDoor2;
	public static Item lockedDoor3;
	public static Item lockedDoor4;
	public static Item lockedDoor5;
	
	public static Item plasticBottle;
	
	public static Item airTank;
	
	public static void loadItems()
	{
		podirt = new PieceOfDirt();
		accessCard  = new AccessCard();
		lockedDoor1 = new LockedDoorItem(1);
		lockedDoor2 = new LockedDoorItem(2);
		lockedDoor3 = new LockedDoorItem(3);
		lockedDoor4 = new LockedDoorItem(4);
		lockedDoor5 = new LockedDoorItem(5);
		
		plasticBottle = new PlasticBottle();
		
		airTank = new AirTank();
		
		GameRegistry.registerItem(podirt, "Peice_of_dirt");
		GameRegistry.registerItem(accessCard, "Access_Card");
		GameRegistry.registerItem(lockedDoor1, "Locked_Door1");
		GameRegistry.registerItem(lockedDoor2, "Locked_Door2");
		GameRegistry.registerItem(lockedDoor3, "Locked_Door3");
		GameRegistry.registerItem(lockedDoor4, "Locked_Door4");
		GameRegistry.registerItem(lockedDoor5, "Locked_Door5");
		GameRegistry.registerItem(plasticBottle, "Plastic_Bottle");
		GameRegistry.registerItem(airTank, "Air_Tank");
	}
}
