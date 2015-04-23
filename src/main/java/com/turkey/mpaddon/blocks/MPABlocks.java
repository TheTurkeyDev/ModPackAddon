package com.turkey.mpaddon.blocks;

import net.minecraft.block.Block;

import com.turkey.mpaddon.renderer.MPARenderingHandler;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class MPABlocks
{
	public static int FOREVER_FIRE_ID = 50;
	
	public static Block foreverFire;
	
	private static MPARenderingHandler renderingHandler;

	public static void loadBlocks()
	{
		renderingHandler = new MPARenderingHandler();
		
		foreverFire = new ForeverFire();
		FOREVER_FIRE_ID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(FOREVER_FIRE_ID,renderingHandler);
		GameRegistry.registerBlock(foreverFire, "Forever_Fire");
	}
}
