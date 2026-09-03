package me.quickmove.mixin;

import me.quickmove.QuickMoveMod;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.settings.GameSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GuiContainer.class)
public class MixinGuiContainer {

    @Redirect(method = "mouseClicked", at = @At(value = "INVOKE", target = "Lorg/lwjgl/input/Keyboard;isKeyDown(I)Z"))
    private boolean redirectShiftCheck(int key) {
        if (key == 42 || key == 54) {
            return GameSettings.isKeyDown(QuickMoveMod.quickMoveKey);
        }
        return org.lwjgl.input.Keyboard.isKeyDown(key);
    }
}
