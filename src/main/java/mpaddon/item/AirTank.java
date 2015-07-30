package mpaddon.item;

import java.util.List;

import mpaddon.MPACore;
import mpaddon.MPASettings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AirTank extends Item
{
	public AirTank()
	{
		super.setCreativeTab(MPACore.modTab);
		super.setTextureName(MPACore.MODID + ":air_Tank");
		super.setUnlocalizedName("Air_Tank");
		super.setMaxDamage(MPASettings.airTankCapcity);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List list){
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, getMaxDamage()));
    }
}
