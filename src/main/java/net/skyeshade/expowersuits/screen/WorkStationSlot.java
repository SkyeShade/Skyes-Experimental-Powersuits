package net.skyeshade.expowersuits.screen;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.skyeshade.expowersuits.block.entity.WorkStationBlockEntity;
import org.jetbrains.annotations.Nullable;

public class WorkStationSlot extends SlotItemHandler {

    private BlockEntity blockEntity;

    private boolean ACTIVE;


    public WorkStationSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition, boolean active) {
        super(itemHandler, index, xPosition, yPosition);

        ACTIVE = active;
    }


    public void setActive (boolean active) {
        ACTIVE = active;
    }
    @Override
    public boolean isActive() {

        return ACTIVE;
    }



}
