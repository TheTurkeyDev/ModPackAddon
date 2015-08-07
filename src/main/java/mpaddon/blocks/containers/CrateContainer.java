package mpaddon.blocks.containers;

import mpaddon.blocks.tileEntities.CrateTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class CrateContainer extends Container
{
	private IInventory crateInv = new InventoryBasic("Crate", true, 1);

	public CrateContainer(InventoryPlayer player, CrateTileEntity tileEntity)
	{
		for (int i = 0; i < 9; i++)
		{
			this.addSlotToContainer(new Slot(player, i, 8 + i * 18, 142));
		}

		for (int y = 0; y < 3; y++)
		{
			for (int x = 0; x < 9; x++)
			{
				this.addSlotToContainer(new Slot(player, 9 + (9 * y + x), 8 + x * 18, 84 + y * 18));
			}
		}

		this.addSlotToContainer(new Slot(crateInv, 0, 27, 33));
	}

	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_)
	{
		return true;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot)
	{
		ItemStack stack = null;
		Slot slotObject = (Slot) inventorySlots.get(slot);
		//System.out.println(slot);

		// null checks and checks if the item can be stacked (maxStackSize > 1)
		if (slotObject != null && slotObject.getHasStack())
		{
			ItemStack stackInSlot = slotObject.getStack();
			stack = stackInSlot.copy();

			// merges the item into player inventory since its in the tileEntity
			if (slot > 35)
			{
				if (!this.mergeItemStack(stackInSlot, 0, 36, true))
					return null;
			}
			// places it into the tileEntity is possible since its in the player
			// inventory
			else if(slot < 36)
			{
				if (!this.mergeItemStack(stackInSlot, 36, 37, false))
					return null;
			}

			if (stackInSlot.stackSize == 0)
			{
				slotObject.putStack(null);
			} else
			{
				slotObject.onSlotChanged();
			}

			if (stackInSlot.stackSize == stack.stackSize)
			{
				return null;
			}
			slotObject.onPickupFromSlot(player, stackInSlot);
		}
		return stack;
	}
}