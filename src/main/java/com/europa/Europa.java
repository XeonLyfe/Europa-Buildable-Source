/*
 * Decompiled with CFR 0.151.
 */
package com.europa;

import com.europa.api.manager.command.CommandManager;
import com.europa.api.manager.element.ElementManager;
import com.europa.api.manager.event.EventManager;
import com.europa.api.manager.friend.FriendManager;
import com.europa.api.manager.misc.ChatManager;
import com.europa.api.manager.misc.ConfigManager;
import com.europa.api.manager.module.ModuleManager;
import com.europa.api.utilities.math.TPSUtils;
import com.europa.api.utilities.misc.IconUtils;
import com.europa.api.utilities.sound.SoundRegisterListener;
import com.europa.client.gui.click.ClickGuiScreen;
import com.europa.client.gui.font.FontManager;
import com.europa.client.gui.hud.HudEditorScreen;
import com.europa.client.gui.special.EuropaMainMenu;
import com.europa.client.minecraft.Minecraft;
import com.europa.client.modules.client.notifications.NotificationProcessor;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.stream.IntStream;
import javax.imageio.ImageIO;
import net.minecraft.util.Util;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

@Mod(modid="europa", name="Europa", version="1.1.5")
public class Europa {
    public static String MODID = "europa";
    public static String VERSION = "1.1.5";
    public static String NAME = "Europa";
    public static Logger LOGGER = LogManager.getLogger((String)"Europa");
    @Mod.Instance(value="europa")
    public static Europa INSTANCE;
    public static NotificationProcessor NOTIFICATION_PROCESSOR;
    public static ChatManager CHAT_MANAGER;
    public static ModuleManager MODULE_MANAGER;
    public static ElementManager ELEMENT_MANAGER;
    public static CommandManager COMMAND_MANAGER;
    public static FriendManager FRIEND_MANAGER;
    public static EventManager EVENT_MANAGER;
    public static SoundRegisterListener SOUND_MANAGER;
    public static FontManager FONT_MANAGER;
    public static ClickGuiScreen CLICK_GUI;
    public static HudEditorScreen HUD_EDITOR;
    public static EuropaMainMenu MAIN_MENU;
    public static ConfigManager CONFIG_MANAGER;

    @Mod.EventHandler
    public void initialize(FMLInitializationEvent fMLInitializationEvent) {
        LOGGER.info("Started Initialization process for Europa v1.1.5!");
        this.setEuropaIcon();
        CHAT_MANAGER = new ChatManager();
        MODULE_MANAGER = new ModuleManager();
        ELEMENT_MANAGER = new ElementManager();
        COMMAND_MANAGER = new CommandManager();
        FRIEND_MANAGER = new FriendManager();
        EVENT_MANAGER = new EventManager();
        SOUND_MANAGER = new SoundRegisterListener();
        FONT_MANAGER = new FontManager();
        FONT_MANAGER.load();
        CLICK_GUI = new ClickGuiScreen();
        HUD_EDITOR = new HudEditorScreen();
        MAIN_MENU = new EuropaMainMenu();
        NOTIFICATION_PROCESSOR = new NotificationProcessor();
        CONFIG_MANAGER = new ConfigManager();
        CONFIG_MANAGER.load();
        CONFIG_MANAGER.attach();
        new TPSUtils();
        LOGGER.info("Finished Initialization process for Europa v1.1.5!");
    }

    @Mod.EventHandler
    public void postInitialize(FMLPostInitializationEvent fMLPostInitializationEvent) {
        LOGGER.info("Started Post-Initialization process for Europa v1.1.5!");
        Display.setTitle((String)"Europa 1.1.5 | Looking up at Jupiter");
        LOGGER.info("Finished Post-Initialization process for Europa v1.1.5!");
    }

    public static ModuleManager getModuleManager() {
        return MODULE_MANAGER;
    }


    public void setWindowIcon() {
        //Why am I skidding Zori's setWindowIcon? I don't even know.
        if (Util.getOSType() != Util.EnumOS.OSX) {
            try (InputStream inputStream16x = Minecraft.class.getResourceAsStream("/assets/europa/img16.png");
                 InputStream inputStream32x = Minecraft.class.getResourceAsStream("/assets/europa/img32.png")) {
                ByteBuffer[] icons = new ByteBuffer[]{IconUtils.INSTANCE.readImageToBuffer(inputStream16x), IconUtils.INSTANCE.readImageToBuffer(inputStream32x)};
                Display.setIcon(icons);
            } catch (Exception e) {
                Europa.LOGGER.error("Couldn't set Windows Icon", e);
            }
        }
    }


    public void setEuropaIcon() {
        this.setWindowIcon();
    }
}

