package me.will0mane.libs.uranusspigot.item.blueprint;

import me.will0mane.libs.uranus.blueprint.Blueprint;
import me.will0mane.libs.uranus.blueprint.node.BlueprintNode;
import me.will0mane.libs.uranusspigot.item.ItemBuilder;
import me.will0mane.libs.uranusspigot.item.blueprint.node.HeadDataNode;
import me.will0mane.libs.uranusspigot.item.blueprint.types.BlueprintC;

import java.util.Collections;
import java.util.List;

public class BlueprintCItemHeadData extends Blueprint<BlueprintC> {

    private final HeadDataNode node;

    public BlueprintCItemHeadData(ItemBuilder item, String data){
        this.node = new HeadDataNode(item, data);
    }

    @Override
    public List<BlueprintNode> getNodes() {
        return Collections.singletonList(node);
    }

    @Override
    public void execPin() {
        node.executePin();
    }

    public List<ItemBuilder> run(){
        return node.executePin();
    }

    @Override
    public void finishPin() {
    }
}