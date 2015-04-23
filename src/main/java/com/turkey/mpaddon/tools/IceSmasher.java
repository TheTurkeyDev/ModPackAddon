package com.turkey.mpaddon.tools;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

import com.google.common.collect.Sets;
import com.turkey.mpaddon.MPACore;

public class IceSmasher extends ItemTool
{
	private static final Set<Block> field_150915_c = Sets.newHashSet(new Block[] {Blocks.ice, Blocks.packed_ice});

	public IceSmasher()
	{
		super(2.0F, MPATools.specialTool, field_150915_c);
		super.setCreativeTab(MPACore.modTab);
		super.setUnlocalizedName("Ice_Smasher");
		super.setTextureName(MPACore.MODID + ":ice_Smasher");
		super.setMaxDamage(300);
		super.setMaxStackSize(1);
	}

	public boolean func_150897_b(Block block)
	{
		return block == Blocks.ice ? true : block == Blocks.packed_ice ? true : false;
	}

	public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_)
	{
		return 1f;
	}
}