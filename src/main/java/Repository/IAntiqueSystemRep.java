package Repository;

import Model.AntiqueShop;
import Model.Item;

import java.util.ArrayList;

public interface IAntiqueSystemRep {

    void createShop(AntiqueShop shop);
    ArrayList<AntiqueShop> getAllShops();
    AntiqueShop getShop(String shopName);
    void createItem(String shopName,Item newItem);
    ArrayList<Item> getAllItems(String shopName);
    Item getOneItem(String shopName, String itemName);
}
