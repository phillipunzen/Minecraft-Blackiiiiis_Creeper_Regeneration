package de.phillipunzen.blackiiiiisCreeperRegeneration.listener;

import de.phillipunzen.blackiiiiisCreeperRegeneration.classes.SavedBlock;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Creeper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class ListenerCreeperExplode implements Listener {

    private final Plugin plugin;

    public ListenerCreeperExplode(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void handleCreeperExplode(EntityExplodeEvent event) {
        if (!(event.getEntity() instanceof Creeper)) return;

        List<Block> blocks = new ArrayList<>(event.blockList());
        List<SavedBlock> saved = new ArrayList<>();

        for (Block block : blocks) {
            BlockState state = block.getState();
            // Keine Inventarinhalte mehr speichern und nicht mehr leeren
            saved.add(new SavedBlock(state, null));
        }


        new BukkitRunnable() {
            int index = 0;
            @Override
            public void run() {
                if (index >= saved.size()) {
                    cancel();
                    return;
                }

                SavedBlock sb = saved.get(index++);
                Block block = sb.state.getBlock();
                block.setType(sb.state.getType());
                sb.state.update(true, false);
                // Keine Wiederherstellung des Inventars
            }
        }.runTaskTimer(plugin, 0L, 40L);
    }
}
