package com.turkey.mpaddon.blocks;

import net.minecraft.block.Block;

import com.turkey.mpaddon.MPACore;
import com.turkey.mpaddon.renderer.MPARenderingHandler;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class MPABlocks
{
	public static int FOREVER_FIRE_ID = 50;
	
	public static Block foreverFire;
	public static Block lockedDoor1;
	public static Block lockedDoor2;
	public static Block lockedDoor3;
	
	private static MPARenderingHandler renderingHandler;

	public static void loadBlocks()
	{
		renderingHandler = new MPARenderingHandler();
		
		foreverFire = new ForeverFire();
		FOREVER_FIRE_ID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(FOREVER_FIRE_ID,renderingHandler);
		
		lockedDoor1 = new LockedDoor().setBlockName("Locked_Door_Tier1").setBlockTextureName(MPACore.MODID + ":door_tier1");
		lockedDoor2 = new LockedDoor().setBlockName("Locked_Door_Tier2").setBlockTextureName(MPACore.MODID + ":door_tier2");
		lockedDoor3 = new LockedDoor().setBlockName("Locked_Door_Tier3").setBlockTextureName(MPACore.MODID + ":door_tier3");
		
		GameRegistry.registerBlock(foreverFire, "Forever_Fire");
		GameRegistry.registerBlock(lockedDoor1, "Locked_Door_Tier1");
		GameRegistry.registerBlock(lockedDoor2, "Locked_Door_Tier2");
		GameRegistry.registerBlock(lockedDoor3, "Locked_Door_Tier3");
	}
}
