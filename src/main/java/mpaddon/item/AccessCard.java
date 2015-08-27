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
    private IIcon[] icons;

    public AccessCard()
    {
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.maxStackSize = 1;
        this.setCreativeTab(MPACore.modTab);
    }

    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    public String getUnlocalizedName(ItemStack stack)
    {
        return stack.getItemDamage() == 0 ? "item.accessCard1" : stack.getItemDamage() == 1 ? "item.accessCard2" :  stack.getItemDamage() == 2 ? "item.accessCard3" : stack.getItemDamage() == 3 ? "item.accessCard4" : "item.accessCard5";
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
    	list.add(new ItemStack(item, 1, 3));
    	list.add(new ItemStack(item, 1, 4));
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int damage)
    {
        return icons[damage];
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register)
    {
        super.registerIcons(register);
    	icons = new IIcon[5];
        icons[0] = register.registerIcon(MPACore.MODID + ":accessCard1");
        icons[1] = register.registerIcon(MPACore.MODID + ":accessCard2");
        icons[2] = register.registerIcon(MPACore.MODID + ":accessCard3");
        icons[3] = register.registerIcon(MPACore.MODID + ":accessCard4");
        icons[4] = register.registerIcon(MPACore.MODID + ":accessCard5");
    }
  
}
