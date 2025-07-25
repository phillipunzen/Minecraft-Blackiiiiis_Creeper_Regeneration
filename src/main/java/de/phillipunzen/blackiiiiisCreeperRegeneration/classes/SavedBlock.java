package de.phillipunzen.blackiiiiisCreeperRegeneration.classes;

import org.bukkit.block.BlockState;
import org.bukkit.inventory.ItemStack;

public class SavedBlock {
    public final BlockState state;
    public final ItemStack[] contents;

    public SavedBlock(BlockState state, ItemStack[] contents) {
        this.state = state;
        this.contents = contents;
    }
}
