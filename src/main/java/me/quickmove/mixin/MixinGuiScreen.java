package me.quickmove.mixin;

import me.quickmove.QuickMoveMod;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.GameSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(GuiScreen.class)
public class MixinGuiScreen {

    @Overwrite
    public static boolean isShiftKeyDown() {
        return GameSettings.isKeyDown(QuickMoveMod.quickMoveKey);
    }
}
