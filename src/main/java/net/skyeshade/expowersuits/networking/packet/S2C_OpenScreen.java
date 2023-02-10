package net.skyeshade.expowersuits.networking.packet;


import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;


import net.skyeshade.expowersuits.networking.openScreen;
import net.skyeshade.expowersuits.screen.workstation.WorkStationScreen;

import java.util.function.Supplier;

public class S2C_OpenScreen {


    public S2C_OpenScreen() {

    }

    public S2C_OpenScreen(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE CLIENT!
            openScreen.open();
            //Minecraft.getInstance().setScreen(new WorkStationScreen());
        });
        return true;
    }
}
