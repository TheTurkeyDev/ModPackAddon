package mpaddon.armor;

import mpaddon.MPACore;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		String itemName = stack.getItem().getUnlocalizedName().replace("item.", "").replace(".name", "");
		return MPACore.MODID + ":models/armor/" + itemName + ".png";
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
		if(!world.isRemote)
		{
			// TODO: Add code here for taking air from tanks in inventory
		}
	}

	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot)
	{
		if(armorSlot == 0)
		{
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