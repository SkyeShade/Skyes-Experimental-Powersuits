package net.skyeshade.expowersuits.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.network.NetworkHooks;
import net.skyeshade.expowersuits.item.ModItems;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class WorkStationBlockEntity extends BlockEntity {



    private final ItemStackHandler itemHandler = new ItemStackHandler(0) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();



        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 78;





    public WorkStationBlockEntity(BlockPos pPos, BlockState pBlockState) {

        super(ModBlockEntities.WORKSTATION.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> WorkStationBlockEntity.this.progress;
                    case 1 -> WorkStationBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> WorkStationBlockEntity.this.progress = pValue;
                    case 1 -> WorkStationBlockEntity.this.maxProgress = pValue;

                }
            }
            //2 bc we have 2 values to save
            @Override
            public int getCount() {
                return 2;
            }
        };
    }







/*
    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {

        return new WorkStationMenu(pContainerId, pPlayerInventory, this, this.data);

    }
*/







    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return  lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        nbt.put("inventory", itemHandler.serializeNBT());
        //nbt.putInt("industrial_forge_progress", this.progress);


        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));

        //progress = nbt.getInt("industrial_forge_progress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }


        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos blockPos, BlockState blockState, WorkStationBlockEntity pEntity) {
        if (level.isClientSide()) {
            return;
        }




    }


    private static boolean isTitaniumHelmet (WorkStationBlockEntity entity) {
        if (!entity.itemHandler.getStackInSlot(0).isEmpty())
            if (entity.itemHandler.getStackInSlot(0).getItem() == ModItems.TITANIUM_HELMET.get())
                return true;
        return false;
    }



}
