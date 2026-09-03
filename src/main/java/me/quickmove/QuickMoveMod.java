package me.quickmove;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

@Mod(modid = "quickmove", name = "Quick Move Rebind", version = "1.0", clientSideOnly = true)
public class QuickMoveMod {

    public static KeyBinding quickMoveKey;

    @Mod.EventHandler
    @SideOnly(Side.CLIENT)
    public void init(FMLInitializationEvent event) {
        quickMoveKey = new KeyBinding("key.quickmove", Keyboard.KEY_LSHIFT, "key.categories.inventory");
        ClientRegistry.registerKeyBinding(quickMoveKey);
    }
}
