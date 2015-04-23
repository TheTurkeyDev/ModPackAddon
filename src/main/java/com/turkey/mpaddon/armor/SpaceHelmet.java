package com.turkey.mpaddon.armor;

import java.util.List;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import solarcraft.core.SolarCraft;

import com.turkey.mpaddon.MPACore;
import com.turkey.mpaddon.MPASettings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import enviromine.handlers.EM_StatusManager;
import enviromine.trackers.EnviroDataTracker;

public class SpaceHelmet extends ItemArmor
{

	private int maxAir = 1000;

	private int count = 0;

	public SpaceHelmet(String unlocalizedName, ArmorMaterial material, int pos) 
	{
		super(material, 0, pos);
		super.setUnlocalizedName(unlocalizedName);
		super.setCreativeTab(MPACore.modTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(stack.getItem().getUnlocalizedName().equalsIgnoreCase("item.Space_Helmet"))
			return MPACore.MODID + ":models/armor/SpaceHelm.png";
		else
			return MPACore.MODID + ":models/armor/SpaceHelm.png";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) 
	{
		list.add("Air percent left: " + (int)(((double)this.getDamage(stack)/(double)this.maxAir)*100) + "%");
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) 
	{
		if(world.isRemote)
		{
			int airHeld = this.getDamage(itemStack);
			if(itemStack.getItem().equals(MPAArmor.spaceHelm))
			{
				int blocks = 0;
				for(int y = -1; y<2; y++)
				{
					for(int x = -1; x<2; x++)
					{
						for(int z = -1; z<2; z++)
						{
							if(world.getBlock((int)(player.posX + x), (int)(player.posY + y), (int)(player.posZ + z)).equals(SolarCraft.spaceAir))
								blocks++;
						}
					}
				}
				if(blocks > 0)
				{
					count++;
					if(count >= 30)
					{
						airHeld += MPASettings.airReplenish;
						if(airHeld > this.maxAir)
							airHeld = this.maxAir;
						count = 0;
					}
				}
				else
				{
					count++;
					if(count >= 30)
					{
						if(airHeld <= 0)
						{
							airHeld = 0;
							return;
						}
						EnviroDataTracker tracker = EM_StatusManager.lookupTracker(player);
						if(tracker.airQuality + MPASettings.airReplenish < 100)
						{
							tracker.airQuality += MPASettings.airReplenish;
							airHeld-= MPASettings.airReplenish;
						}
						else
						{
							float sub = 100 - tracker.airQuality;
							tracker.airQuality = 100;
							airHeld-=sub;
						}
						count = 0;
					}
				}
			}
			this.setDamage(itemStack, airHeld);
		}
	}

	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot)
	{
		if(itemStack.getItem().getUnlocalizedName().equalsIgnoreCase("item.Space_Helmet"))
		{
			return ModelSpaceHelmet.modelHelm;
		}
		return null;
	}
}