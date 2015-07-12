package mpaddon.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mpaddon.MPACore;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class AccessCard extends Item
{
    @SideOnly(Side.CLIENT)
    private IIcon icon2;
    @SideOnly(Side.CLIENT)
    private IIcon icon3;

    public AccessCard()
    {
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.maxStackSize = 1;
        this.setCreativeTab(MPACore.modTab);
        super.setTextureName(MPACore.MODID + ":accessCard1");
    }

    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    public String getUnlocalizedName(ItemStack stack)
    {
        return stack.getItemDamage() == 0 ? "item.accessCard1" : stack.getItemDamage() == 1 ? "item.accessCard2" :  "item.accessCard3";
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tabs, List list)
    {
    	list.add(new ItemStack(item, 1, 0));
    	list.add(new ItemStack(item, 1, 1));
    	list.add(new ItemStack(item, 1, 2));
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int damage)
    {
        return damage == 0 ? this.itemIcon : damage == 1 ? this.icon2 : this.icon3;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register)
    {
        super.registerIcons(register);
        this.icon2 = register.registerIcon(MPACore.MODID + ":accessCard2");
        this.icon3 = register.registerIcon(MPACore.MODID + ":accessCard3");
    }
  
}
