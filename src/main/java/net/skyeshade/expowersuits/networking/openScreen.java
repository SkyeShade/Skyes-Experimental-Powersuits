package net.skyeshade.expowersuits.networking;

import net.minecraft.client.Minecraft;
import net.skyeshade.expowersuits.screen.workstation.WorkStationScreen;

public class openScreen {

    public static void open () {
        Minecraft.getInstance().setScreen(new WorkStationScreen());
    }
}
