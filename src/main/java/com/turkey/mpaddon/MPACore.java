package com.turkey.mpaddon;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.Logger;

import com.turkey.mpaddon.armor.MPAArmor;
import com.turkey.mpaddon.blocks.MPABlocks;
import com.turkey.mpaddon.events.BlockListener;
import com.turkey.mpaddon.events.PlayerDeathListener;
import com.turkey.mpaddon.events.PlayerListener;
import com.turkey.mpaddon.item.MPAItems;
import com.turkey.mpaddon.proxy.CommonProxy;
import com.turkey.mpaddon.tools.MPATools;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MPACore.MODID, version = MPACore.VERSION)
public class MPACore
{
	public static final String MODID = "modpackaddon";
	public static final String VERSION = "0.1";
	public static final String NAME = "Modpack Addon";

	@Instance(value = MODID)
	public static MPACore instance;
	@SidedProxy(clientSide="com.turkey.mpaddon.proxy.ClientProxy", serverSide="com.turkey.mpaddon.proxy.CommonProxy")
	public static CommonProxy proxy;
	public static CreativeTabs modTab = new CreativeTabs(MODID) {
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(MPABlocks.foreverFire);
		}
	};
	public static Logger logger;

	@EventHandler
	public void init(FMLInitializationEvent event)
	{

	}

	@EventHandler
	public void load(FMLPreInitializationEvent event)
	{
		logger = event.getModLog();

		MPABlocks.loadBlocks();
		MPAItems.loadItems();
		MPATools.loadTools();
		MPAArmor.loadArmor();

		ConfigLoader.loadConfigSettings(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new UpdateNotificationHandler());
		MinecraftForge.EVENT_BUS.register(new BlockListener());
		MinecraftForge.EVENT_BUS.register(new PlayerDeathListener());
		MinecraftForge.EVENT_BUS.register(new PlayerListener());
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		Blocks.hardened_clay.setHardness(0.3F);
		Blocks.stained_hardened_clay.setHardness(0.3F);
	}
}