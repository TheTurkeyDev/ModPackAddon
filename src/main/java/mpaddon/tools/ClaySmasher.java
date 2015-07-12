package mpaddon.tools;

import java.util.Set;

import mpaddon.MPACore;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

import com.google.common.collect.Sets;

public class ClaySmasher extends ItemTool
{
    private static final Set<Block> field_150915_c = Sets.newHashSet(new Block[] {Blocks.hardened_clay, Blocks.stained_hardened_clay});

    public ClaySmasher()
    {
        super(2.0F, MPATools.specialTool, field_150915_c);
        super.setCreativeTab(MPACore.modTab);
        super.setUnlocalizedName("Clay_Smasher");
        super.setTextureName(MPACore.MODID + ":clay_Smasher");
        super.setMaxDamage(300);
		super.setMaxStackSize(1);
    }

    public boolean func_150897_b(Block block)
    {
        return block == Blocks.hardened_clay ? true : block == Blocks.stained_hardened_clay ? true : false;
    }

    public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_)
    {
        return 1f;
    }
}