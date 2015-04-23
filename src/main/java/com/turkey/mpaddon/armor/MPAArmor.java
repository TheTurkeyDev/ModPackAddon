package com.turkey.mpaddon.armor;

import com.turkey.mpaddon.MPACore;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;

public class MPAArmor
{
	public static ArmorMaterial miscArmor; 
	
	public static Item spaceHelm;
	
	public static void loadArmor()
	{
		miscArmor = EnumHelper.addArmorMaterial("Misc_Armor_Material", 0, new int[] {0, 0, 0, 0}, 0);
		
		spaceHelm = (new SpaceHelmet("Space_Helmet", miscArmor, 0)).setTextureName(MPACore.MODID + ":space_helmet");
		
		GameRegistry.registerItem(spaceHelm, "Space_Helmet");
	}
}
