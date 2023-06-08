package me.will0mane.libs.uranusspigot.item;

import me.will0mane.libs.uranusspigot.item.blueprint.BlueprintCItemHeadData;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class ItemBuilder {

    private final ItemStack original;

    public ItemBuilder(ItemStack itemStack){
        this.original = itemStack;
    }

    public ItemBuilder(Material material){
        this(new ItemStack(material));
    }

    public ItemStack build(){
        return original;
    }

    public ItemBuilder setHead(String head) {
        if (original.getType() != Material.PLAYER_HEAD) {
            return this;
        }

        new BlueprintCItemHeadData(this, head).execPin();
        return this;
    }

    public ItemBuilder rename(String name){
        ItemMeta meta = getMeta();
        meta.setDisplayName(name);
        original.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setLore(List<String> lore){
        ItemMeta meta = getMeta();
        meta.setLore(lore);
        original.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setLore(String... lore){
        this.setLore(new ArrayList<>(Arrays.asList(lore)));
        return this;
    }

    public ItemBuilder setCustomModelData(int data){
        ItemMeta meta = getMeta();
        meta.setCustomModelData(data);
        original.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setUnbreakable(boolean var0){
        ItemMeta meta = getMeta();
        meta.setUnbreakable(var0);
        original.setItemMeta(meta);
        return this;
    }

    public ItemMeta getItemMeta(){
        return getMeta();
    }

    private ItemMeta getMeta() {
        return original.getItemMeta();
    }

    public ItemStack getOriginal() {
        return original;
    }
}
