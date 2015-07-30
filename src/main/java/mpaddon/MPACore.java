package mpaddon;

import mpaddon.armor.MPAArmor;
import mpaddon.blocks.MPABlocks;
import mpaddon.events.BlockListener;
import mpaddon.events.PlayerDeathListener;
import mpaddon.events.PlayerListener;
import mpaddon.item.MPAItems;
import mpaddon.proxy.CommonProxy;
import mpaddon.tools.MPATools;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidContainerRegistry;

import org.apache.logging.log4j.Logger;

import solarcraft.core.SolarCraft;
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
	public static final String VERSION = "0.6";
	public static final String NAME = "Modpack Addon";

	@Instance(value = MODID)
	public static MPACore instance;
	@SidedProxy(clientSide="mpaddon.proxy.ClientProxy", serverSide="mpaddon.proxy.CommonProxy")
	public static CommonProxy proxy;
	public static CreativeTabs modTab = new CreativeTabs(MODID) {
		public Item getTabIconItem()
		{
			return MPAArmor.basicSpaceHelm;
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
		
		ConfigLoader.loadConfigSettings(event.getSuggestedConfigurationFile());

		MPABlocks.loadBlocks();
		MPAItems.loadItems();
		MPATools.loadTools();
		MPAArmor.loadArmor();

		MinecraftForge.EVENT_BUS.register(new BlockListener());
		MinecraftForge.EVENT_BUS.register(new PlayerDeathListener());
		MinecraftForge.EVENT_BUS.register(new PlayerListener());
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		Blocks.hardened_clay.setHardness(0.3F);
		Blocks.stained_hardened_clay.setHardness(0.3F);
		FluidContainerRegistry.registerFluidContainer(SolarCraft.LOX, new ItemStack(MPAItems.airTank, 1, 0), new ItemStack(MPAItems.airTank, 1, 1000));
	}
}