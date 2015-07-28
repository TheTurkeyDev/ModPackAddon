package mpaddon.armor;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;

public class MPAArmor
{
	public static ArmorMaterial basicSpaceSuit;
	public static ArmorMaterial reinforcedSpaceSuit; 
	public static ArmorMaterial hardenedSpaceSuit; 
	
	public static Item basicSpaceHelm;
	public static Item basicSpaceChest;
	public static Item basicSpaceLegs;
	public static Item basicSpaceBoots;
	
	public static Item reinforcedSpaceHelm;
	public static Item reinforcedSpaceChest;
	public static Item reinforcedSpaceLegs;
	public static Item reinforcedSpaceBoots;
	
	public static Item hardenedSpaceHelm;
	public static Item hardenedSpaceChest;
	public static Item hardenedSpaceLegs;
	public static Item hardenedSpaceBoots;
	
	public static void loadArmor()
	{
		basicSpaceSuit = EnumHelper.addArmorMaterial("Basic_Space_Suit", 0, new int[] {1, 3, 2, 1}, 15);
		reinforcedSpaceSuit = EnumHelper.addArmorMaterial("Reinforced_Space_Suit", 0, new int[] {2, 4, 3, 2}, 15);
		hardenedSpaceSuit = EnumHelper.addArmorMaterial("Hardened_Space_Suit", 0, new int[] {3, 5, 4, 3}, 15);
		
		basicSpaceHelm = (new SpaceSuitItemArmor("Basic_Space_Helmet", basicSpaceSuit, 0));
		basicSpaceChest = (new SpaceSuitItemArmor("Basic_Space_Chestplate", basicSpaceSuit, 1));
		basicSpaceLegs = (new SpaceSuitItemArmor("Basic_Space_Leggings", basicSpaceSuit, 2));
		basicSpaceBoots = (new SpaceSuitItemArmor("Basic_Space_Boots", basicSpaceSuit, 3));
		
		reinforcedSpaceHelm = (new SpaceSuitItemArmor("Reinforced_Space_Helmet", reinforcedSpaceSuit, 0));
		reinforcedSpaceChest = (new SpaceSuitItemArmor("Reinforced_Space_Chestplate", reinforcedSpaceSuit, 1));
		reinforcedSpaceLegs = (new SpaceSuitItemArmor("Reinforced_Space_Leggings", reinforcedSpaceSuit, 2));
		reinforcedSpaceBoots = (new SpaceSuitItemArmor("Reinforced_Space_Boots", reinforcedSpaceSuit, 3));
		
		hardenedSpaceHelm = (new SpaceSuitItemArmor("Hardened_Space_Helmet", hardenedSpaceSuit, 0));
		hardenedSpaceChest = (new SpaceSuitItemArmor("Hardened_Space_Chestplate", hardenedSpaceSuit, 1));
		hardenedSpaceLegs = (new SpaceSuitItemArmor("Hardened_Space_Leggings", hardenedSpaceSuit, 2));
		hardenedSpaceBoots = (new SpaceSuitItemArmor("Hardened_Space_Boots", hardenedSpaceSuit, 3));
		
		GameRegistry.registerItem(basicSpaceHelm, "Basic_Space_Helmet");
		GameRegistry.registerItem(basicSpaceChest, "Basic_Space_Chestplate");
		GameRegistry.registerItem(basicSpaceLegs, "Basic_Space_Leggings");
		GameRegistry.registerItem(basicSpaceBoots, "Basic_Space_Boots");
		
		GameRegistry.registerItem(reinforcedSpaceHelm, "Reinforced_Space_Helmet");
		GameRegistry.registerItem(reinforcedSpaceChest, "Reinforced_Space_Chestplate");
		GameRegistry.registerItem(reinforcedSpaceLegs, "Reinforced_Space_Leggings");
		GameRegistry.registerItem(reinforcedSpaceBoots, "Reinforced_Space_Boots");
		
		GameRegistry.registerItem(hardenedSpaceHelm, "Hardened_Space_Helmet");
		GameRegistry.registerItem(hardenedSpaceChest, "Hardened_Space_Chestplate");
		GameRegistry.registerItem(hardenedSpaceLegs, "Hardened_Space_Leggings");
		GameRegistry.registerItem(hardenedSpaceBoots, "Hardened_Space_Boots");
	}
}
