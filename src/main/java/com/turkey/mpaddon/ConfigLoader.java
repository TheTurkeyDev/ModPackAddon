package com.turkey.mpaddon;

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
		
		MPASettings.airReplenish = config.get(armCat, "AirReplenish", 1.0).getDouble();
		
		config.save();
	}
}