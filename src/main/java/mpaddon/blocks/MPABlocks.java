package mpaddon.blocks;

import mpaddon.MPACore;
import mpaddon.blocks.tileEntities.CrateTileEntity;
import mpaddon.renderer.MPARenderingHandler;
import net.minecraft.block.Block;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class MPABlocks
{
	public static int FOREVER_FIRE_ID = 50;
	
	public static Block foreverFire;
	public static Block lockedDoor1;
	public static Block lockedDoor2;
	public static Block lockedDoor3;
	public static Block lockedDoor4;
	public static Block lockedDoor5;
	
	public static Block coarsedDirt;
	
	public static Block crate;
	
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
		lockedDoor4 = new LockedDoor().setBlockName("Locked_Door_Tier4").setBlockTextureName(MPACore.MODID + ":door_tier4");
		lockedDoor5 = new LockedDoor().setBlockName("Locked_Door_Tier5").setBlockTextureName(MPACore.MODID + ":door_tier5");
		
		coarsedDirt = new UselessCoarsedDirt();
		
		crate = new CrateBlock();
		GameRegistry.registerTileEntity(CrateTileEntity.class, coarsedDirt.getUnlocalizedName());
		
		GameRegistry.registerBlock(foreverFire, "Forever_Fire");
		GameRegistry.registerBlock(lockedDoor1, "Locked_Door_Tier1");
		GameRegistry.registerBlock(lockedDoor2, "Locked_Door_Tier2");
		GameRegistry.registerBlock(lockedDoor3, "Locked_Door_Tier3");
		GameRegistry.registerBlock(lockedDoor4, "Locked_Door_Tier4");
		GameRegistry.registerBlock(lockedDoor5, "Locked_Door_Tier5");
		GameRegistry.registerBlock(coarsedDirt, "Useless_Coarsed_Dirt");
		GameRegistry.registerBlock(crate, "Crate");
	}
}
