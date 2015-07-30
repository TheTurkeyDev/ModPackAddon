package mpaddon;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigLoader 
{
	private static Configuration config;
	private static final String armCat = "Armor Settings";
	
	public static void loadConfigSettings(File file)
	{
		config = new Configuration(file);
		config.load();
		
		MPASettings.airReplenish = config.getInt("AirReplenish", armCat, 1, 0, 100, "How much air the space suit replenishes every few ticks");
		MPASettings.airTankCapcity = config.getInt("AirTankCapacity", armCat, 1000, 0, Integer.MAX_VALUE, "How much air an air tank can store");
		
		config.save();
	}
}