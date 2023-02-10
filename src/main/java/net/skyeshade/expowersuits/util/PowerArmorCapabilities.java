package net.skyeshade.expowersuits.util;

import net.minecraft.nbt.CompoundTag;

public class PowerArmorCapabilities {

    private final long MIN_MAXMANA = 0;
    private long mana;

    private long max_mana;

    public long getMana() {return mana;}

    public void setMaxMana(long set) {
        this.max_mana = Math.max(set, MIN_MAXMANA);
    }

    public void addMana(long add) {this.mana = Math.min(mana + add, max_mana);}


    public void copyFrom(PowerArmorCapabilities source) {
        this.mana = source.mana;

    }
    public void saveNBTData(CompoundTag nbt) {
        //System.out.prlongln("Saving NBT"+"\n"+mana+"\n"+max_mana);
        nbt.putLong("mana", mana);



    }

    public void loadNBTData(CompoundTag nbt) {
        //System.out.prlongln("Loading NBT"+"\n"+mana+"\n"+max_mana);
        mana = nbt.getLong("mana");

    }
}
