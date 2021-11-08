package Repository;

import Model.AntiqueShop;
import Model.Item;

import java.util.ArrayList;

public interface IAntiqueSystemRep {
    //Item getOneItem(String name);
    void createShop(AntiqueShop shop);
    ArrayList<AntiqueShop> getAllShops();
    AntiqueShop getShop(String shopName);
   // ArrayList<Item> getAllItems();
}
