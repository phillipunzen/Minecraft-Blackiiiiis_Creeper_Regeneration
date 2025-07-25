package de.phillipunzen.blackiiiiisCreeperRegeneration;

import de.phillipunzen.blackiiiiisCreeperRegeneration.listener.ListenerCreeperExplode;
import org.bukkit.plugin.java.JavaPlugin;


public final class BlackiiiiisCreeperRegeneration extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getLogger().info("[BCR] Enable Plugin...");
        this.getLogger().info("[BCR] Author: Blackiiiii");
        getServer().getPluginManager().registerEvents(new ListenerCreeperExplode(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
