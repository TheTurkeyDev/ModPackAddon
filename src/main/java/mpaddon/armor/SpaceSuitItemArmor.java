package mpaddon.armor;

import mpaddon.MPACore;
import mpaddon.MPASettings;
import mpaddon.item.MPAItems;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import tonius.simplyjetpacks.item.ItemPack;
import tonius.simplyjetpacks.item.ItemPack.ItemJetpack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import enviromine.handlers.EM_StatusManager;
import enviromine.trackers.EnviroDataTracker;

public class SpaceSuitItemArmor extends ItemArmor
{
	public SpaceSuitItemArmor(String unlocalizedName, ArmorMaterial material, int pos)
	{
		super(material, 0, pos);
		super.setUnlocalizedName(unlocalizedName);
		super.setCreativeTab(MPACore.modTab);
		super.setTextureName(MPACore.MODID + ":" + unlocalizedName);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
		if(!world.isRemote)
		{
			if(!itemStack.getItem().equals(MPAArmor.basicSpaceHelm) && !itemStack.getItem().equals(MPAArmor.hardenedSpaceHelm) && !itemStack.getItem().equals(MPAArmor.reinforcedSpaceHelm))
				return;

			if(itemStack.getTagCompound() == null)
				itemStack.setTagCompound(new NBTTagCompound());

			NBTTagCompound nbt = itemStack.getTagCompound();
			if(!nbt.hasKey("TickDelay"))
				nbt.setByte("TickDelay", (byte) 30);

			for(ItemStack stack : player.inventory.armorInventory)
				if(stack == null || !(stack.getItem() instanceof SpaceSuitItemArmor || stack.getItem() instanceof ItemPack))
					return;

			byte delay = nbt.getByte("TickDelay");

			if(delay == 0)
			{
				ItemStack tank = null;

				for(ItemStack stack : player.inventory.mainInventory)
				{
					if(stack != null && stack.getItem().equals(MPAItems.airTank) && stack.getItemDamage() != MPASettings.airTankCapcity)
					{
						tank = stack;
					}
				}

				if(tank == null)
					return;

				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 60, 9, true));

				EnviroDataTracker tracker = EM_StatusManager.lookupTracker(player);
				if(tracker.airQuality + MPASettings.airReplenish <= 100.0D && tank.getItemDamage() + MPASettings.airReplenish <= tank.getMaxDamage())
				{
					tracker.airQuality = ((float) (tracker.airQuality + MPASettings.airReplenish));
					tank.setItemDamage(tank.getItemDamage() + MPASettings.airReplenish);
				}
				else if(tracker.airQuality + MPASettings.airReplenish > 100.0D && tank.getItemDamage() + MPASettings.airReplenish <= tank.getMaxDamage())
				{
					float sub = 100.0F - tracker.airQuality;
					tracker.airQuality = 100.0F;
					tank.setItemDamage(tank.getItemDamage() + ((int) Math.floor(sub)));
				}
				else if(tracker.airQuality + MPASettings.airReplenish <= 100.0D && tank.getItemDamage() + MPASettings.airReplenish > tank.getMaxDamage())
				{
					tracker.airQuality = ((float) (tracker.airQuality + tank.getItemDamage()));
					tank.setItemDamage(tank.getMaxDamage());
				}
				delay = (byte) 30;
			}
			else
				delay--;
			nbt.setByte("TickDelay", delay);
		}
	}

	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot)
	{
		if(armorSlot == 0)
		{
			if(entityLiving instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer) entityLiving;
				if(player.inventory.armorInventory[2] != null && player.inventory.armorInventory[2].getItem() instanceof ItemJetpack)
					return ModelSpaceCombined.modelCombined;
			}
			return ModelSpaceHelmet.modelHelm;
		}
		else if(armorSlot == 1)
		{
			return ModelSpaceChestplate.modelChest;
		}
		else if(armorSlot == 2)
		{
			return ModelSpaceLeggings.modelLeggings;
		}
		else if(armorSlot == 3)
		{
			return ModelSpaceBoots.modelBoots;
		}
		return null;
	}
}