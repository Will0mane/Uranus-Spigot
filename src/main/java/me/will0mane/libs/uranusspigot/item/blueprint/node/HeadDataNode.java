package me.will0mane.libs.uranusspigot.item.blueprint.node;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import me.will0mane.libs.uranus.blueprint.node.BlueprintNode;
import me.will0mane.libs.uranusspigot.item.ItemBuilder;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class HeadDataNode extends BlueprintNode {

    private final ItemBuilder item;
    private final String data;

    public HeadDataNode(ItemBuilder item, String data){
        this.item = item;
        this.data = data;
    }

    @Override
    public List<?> inputVars() {
        return Collections.emptyList();
    }

    @Override
    public List<?> outputVars() {
        return Collections.emptyList();
    }

    @Override
    public List<ItemBuilder> executePin(Object... objects) {
        SkullMeta itemMeta = (SkullMeta) item.getOriginal().getItemMeta();
        if(itemMeta == null) return Collections.singletonList(item);

        GameProfile profile = new GameProfile(UUID.randomUUID(), "");
        profile.getProperties().put("textures", new Property("textures", data));
        Field profileField;
        try {
            profileField = itemMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(itemMeta, profile);
            profileField.setAccessible(false);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
        item.getOriginal().setItemMeta(itemMeta);
        return Collections.singletonList(item);
    }
}
