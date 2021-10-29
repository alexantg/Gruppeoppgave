package Repository;

import Model.Item;

import java.util.ArrayList;

public class AntiqueSystemRep implements IAntiqueSystemRep {
    private ArrayList<Item> items = new ArrayList<>();

    public AntiqueSystemRep() {
      /*Item Vase = new Item("Gammel vase", "Gammel vase fra 50-tallet", 500, "https://bit.ly/3ErtIFH"); */
    }


    @Override
    public ArrayList<Item> getAllItems() {
        return items;
    }

    @Override
    public Item getOneItem(String name) {
        for (Item aItem : items) {
            if (aItem.getName().equals(name))
                return aItem;
        }
        return null;
    }
}
