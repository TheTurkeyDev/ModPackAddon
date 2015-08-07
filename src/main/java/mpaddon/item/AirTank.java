package mpaddon.item;

import java.util.List;

import solarcraft.core.SolarCraft;
import mpaddon.MPACore;
import mpaddon.MPASettings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AirTank extends Item implements IFluidHandler
{
	public AirTank()
	{
		super.setCreativeTab(MPACore.modTab);
		super.setTextureName(MPACore.MODID + ":air_Tank");
		super.setUnlocalizedName("Air_Tank");
		super.setMaxDamage(MPASettings.airTankCapcity);
		super.setMaxStackSize(1);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List list){
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, getMaxDamage()));
    }

	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill)
	{
		if(resource.getFluid().equals(SolarCraft.LOX))
		{
			return MPASettings.airTankCapcity;
		}
		return 0;
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain)
	{
		return null;
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain)
	{
		return null;
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid)
	{
		return fluid.equals(SolarCraft.LOX);
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid)
	{
		return false;
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from)
	{
		return null;
	}
}
