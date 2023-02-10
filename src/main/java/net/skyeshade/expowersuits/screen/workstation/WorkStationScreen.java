package net.skyeshade.expowersuits.screen.workstation;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.GameNarrator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.skyeshade.expowersuits.ExPowersuits;
import net.skyeshade.expowersuits.item.custom.PowersuitArmorItem;

import java.util.ArrayList;
import java.util.List;
@OnlyIn(Dist.CLIENT)
public class WorkStationScreen extends Screen {
    private static final ResourceLocation TEXTURE = new ResourceLocation(ExPowersuits.MOD_ID,"textures/gui/workstation.png");

    private static final ResourceLocation WIDGETS = new ResourceLocation(ExPowersuits.MOD_ID,"textures/gui/workstation_widgets.png");

    private static final ResourceLocation ITEMTEXTURE2 = new ResourceLocation(ExPowersuits.MOD_ID,"textures/gui/titanium_helmet.png");

    private static ArrayList<ItemStack> powerArmorItemsSorted = new ArrayList<>();

    private static final int sideBarHeight = 150;
    private Player player = Minecraft.getInstance().player;
    private ItemStack selectedItem;
    private int currentWindow = 1;
    public static final int WINDOW_WIDTH = 341;
    public static final int WINDOW_HEIGHT = 189;
    public WorkStationScreen() {
        super(GameNarrator.NO_TITLE);
    }

    @Override
    protected void init() {
        super.init();
    }
    @Override
    public boolean isPauseScreen() {
        return false;
    }


    public boolean isMouseOver(int xOffset, int yOffset, double pMouseX, double pMouseY, int hitBoxX, int hitBoxY) {
        return Math.abs(pMouseX - xOffset-hitBoxX/2f) < hitBoxX/2f && Math.abs(pMouseY - yOffset-hitBoxY/2f) < hitBoxY/2f;
    }

    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
        if (pButton == 0) {
            int y = (this.height - WINDOW_HEIGHT) / 2;
            int x = (this.width - WINDOW_WIDTH) / 2;
            //if(isMouseOver(x,y,(int)pMouseX,(int)pMouseY,10,10))
            //    currentWindow++;

            if (selectedItem != null) {
                if (isMouseOver(x+WINDOW_WIDTH,y+10,pMouseX, pMouseY, 19, 18))
                    currentWindow = 1;
                if (isMouseOver(x+WINDOW_WIDTH,y+18+10,pMouseX, pMouseY, 19, 18))
                    currentWindow = 2;
                if (isMouseOver(x+WINDOW_WIDTH,y+18*2+10,pMouseX, pMouseY, 19, 18))
                    currentWindow = 3;
                if (isMouseOver(x+WINDOW_WIDTH,y+18*3+10,pMouseX, pMouseY, 19, 18))
                    currentWindow = 4;
                if (isMouseOver(x+WINDOW_WIDTH,y+18*4+10,pMouseX, pMouseY, 19, 18))
                    currentWindow = 5;
                if (isMouseOver(x+WINDOW_WIDTH,y+18*5+10,pMouseX, pMouseY, 19, 18))
                    currentWindow = 6;
            }

            //left armor item bar hitboxes
            for (ItemStack item : powerArmorItemsSorted) {


                float iconSpacing = (powerArmorItemsSorted.indexOf(item)+1)*((float)sideBarHeight/((float)powerArmorItemsSorted.size()+1f));
                int offset = sideBarHeight/2;

                if (isMouseOver(x+10,y+WINDOW_HEIGHT/2-offset+(int)iconSpacing-8, pMouseX, pMouseY, 16,16)) {
                    selectedItem = item;
                    //player.getInventory().removeItem(item);
                }

                //blit(pPoseStack, x+10  , y+WINDOW_HEIGHT/2-offset+(int)iconSpacing-8, 0, 0, 16, 16,16,16);
            }

        }

        return super.mouseClicked(pMouseX, pMouseY, pButton);

    }




    protected void renderWindow(PoseStack pPoseStack, int x, int y, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);

        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);

        //System.out.println(selectedItem);

        blit(pPoseStack, x, y, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, 512, 512);
        RenderSystem.setShaderTexture(0, WIDGETS);
        /*
        if (isPowerSuitItem(menu.getSlot(36).getItem())) {
            renderSideScreen(pPoseStack, pMouseX, pMouseY, x, y);
            renderPowersuitScreens(pPoseStack, pMouseX, pMouseY, x, y);
        } else {
            currentWindow = 1;
        }

         */




    }




    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        int x = (this.width - WINDOW_WIDTH) / 2;
        int y = (this.height - WINDOW_HEIGHT) / 2;
        renderBackground(pPoseStack);
        renderWindow(pPoseStack,x,y,mouseX,mouseY);

        renderPowerArmorIcons(pPoseStack, mouseX, mouseY, x, y);

        if (selectedItem != null) {
            renderSideScreen(pPoseStack, mouseX, mouseY, x, y);
            renderPowersuitScreens(pPoseStack, mouseX, mouseY, x, y);
        }

        super.render(pPoseStack, mouseX, mouseY, delta);
        //renderTooltip(pPoseStack, mouseX, mouseY);
    }


    public void renderPowerArmorIcons (PoseStack pPoseStack, int pMouseX, int pMouseY, int offsetX, int offsetY) {

        if (!player.getInventory().items.contains(selectedItem))
            selectedItem = null;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);


        powerArmorItemsSorted.clear();




        ArrayList<ItemStack> powerArmorHelmets = new ArrayList<>();
        ArrayList<ItemStack> powerArmorBodies = new ArrayList<>();
        ArrayList<ItemStack> powerArmorLegs = new ArrayList<>();
        ArrayList<ItemStack> powerArmorFeet = new ArrayList<>();
        //ArrayList<ItemStack> powerArmorItemsSorted = new ArrayList<>();

        for (ItemStack item : player.getInventory().items) {
            if (isPowerSuitItem(item)) {
                if (((PowersuitArmorItem)item.getItem()).getSortingID() == 1)
                    powerArmorHelmets.add(item);
                if (((PowersuitArmorItem)item.getItem()).getSortingID() == 2)
                    powerArmorBodies.add(item);
                if (((PowersuitArmorItem)item.getItem()).getSortingID() == 3)
                    powerArmorLegs.add(item);
                if (((PowersuitArmorItem)item.getItem()).getSortingID() == 4)
                    powerArmorFeet.add(item);
            }
        }
        powerArmorItemsSorted.addAll(powerArmorHelmets);
        powerArmorItemsSorted.addAll(powerArmorBodies);
        powerArmorItemsSorted.addAll(powerArmorLegs);
        powerArmorItemsSorted.addAll(powerArmorFeet);
        //System.out.println(player.getInventory().items);
        //System.out.println(powerArmorItemsSorted);
        for (ItemStack item : powerArmorItemsSorted) {
            ResourceLocation ITEMTEXTURE = new ResourceLocation(ExPowersuits.MOD_ID,"textures/item/"+(new ArrayList<String>(List.of(item.getDescriptionId().split("\\.")))).get(2)+".png");
            //System.out.println((new ArrayList<String>(List.of(item.getDescriptionId().split("\\.")))).get(2));

            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.setShaderTexture(0, ITEMTEXTURE);

            float iconSpacing = (powerArmorItemsSorted.indexOf(item)+1)*((float)sideBarHeight/((float)powerArmorItemsSorted.size()+1f));
            int offset = sideBarHeight/2;
            blit(pPoseStack, offsetX+10  , offsetY+WINDOW_HEIGHT/2-offset+(int)iconSpacing-8, 0, 0, 16, 16,16,16);

        }


    }

    public void renderPowersuitScreens (PoseStack pPoseStack, int pMouseX, int pMouseY, int offsetX, int offsetY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, WIDGETS);


        if (currentWindow == 2)
            renderArmorScreen(pPoseStack, pMouseX, pMouseY, offsetX, offsetY);

    }

    public void renderArmorScreen (PoseStack pPoseStack, int pMouseX, int pMouseY, int offsetX, int offsetY) {
        this.blit(pPoseStack, offsetX + WINDOW_WIDTH/2-19/2, offsetY+ WINDOW_HEIGHT/2-19/2, 40, 0, 19, 19);
    }



    public void renderSideScreen (PoseStack pPoseStack, int pMouseX, int pMouseY, int offsetX, int offsetY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, WIDGETS);


        this.blit(pPoseStack, offsetX + WINDOW_WIDTH, offsetY+10, 0, 0, 19, 109);
        renderActiveWindowOnPanel(pPoseStack, offsetX, offsetY);
    }


    public void renderActiveWindowOnPanel (PoseStack pPoseStack, int offsetX, int offsetY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, WIDGETS);


        this.blit(pPoseStack, offsetX + WINDOW_WIDTH, offsetY+10+currentWindow*18-18, 20, currentWindow*18-18, 19, 19);
    }

    public boolean isPowerSuitItem (ItemStack itemStack) {

        return itemStack.getItem() instanceof PowersuitArmorItem;

    }



}