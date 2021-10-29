package Repository;

import Model.Item;

import java.util.ArrayList;

public interface IAntiqueSystemRep {
    ArrayList<Item> getAllItems();
    Item getOneItem(String name);

}
