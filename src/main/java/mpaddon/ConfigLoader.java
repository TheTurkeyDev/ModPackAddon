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

		MPASettings.randomleafDelay = config.getInt("RandomLeafDelay", genCat, 2, 0, 10, "How many random ticks the custom leaf blocks will wait before dying");

		MPASettings.witherHealthMultiplier = config.getFloat("WitherHealthMultiplier", genCat, 1.0f, 1.0f, 10.0f, "Wither health multiplier");
		MPASettings.dragonHealthMultiplier = config.getFloat("DragonHealthMultiplier", genCat, 1.0f, 1.0f, 5.0f, "Dragon health multiplier");

		config.save();
	}
}