package mpaddon;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigLoader 
{
	private static Configuration config;
	private static final String armCat = "Armor Settings";
	private static final String genCat = "General Settings";
	
	public static void loadConfigSettings(File file)
	{
		config = new Configuration(file);
		config.load();
		
		MPASettings.airReplenish = config.getInt("AirReplenish", armCat, 1, 0, 100, "How much air the space suit replenishes every few ticks");
		MPASettings.airTankCapcity = config.getInt("AirTankCapacity", armCat, 1000, 0, Integer.MAX_VALUE, "How much air an air tank can store");
		
		MPASettings.statopout = config.getBoolean("Stat Tracking Opout", genCat, false, "set to true to opout of anonymous stat tracking for the pack stats are displayed here http://theprogrammingturkey.com/AMStats.php");
		
		config.save();
	}
}