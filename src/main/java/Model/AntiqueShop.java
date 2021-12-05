package Model;

import java.util.ArrayList;

public class AntiqueShop {
        private String name;
        private String email;
        private String address;
        private ArrayList<Item> items = new ArrayList<Item>();

    public AntiqueShop(){

    }

    public AntiqueShop(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Item> getItems() {
        return new ArrayList<>(items);
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem(Item item){
       try{
           this.items.add(item);
       }
       catch (NullPointerException e){
            e.printStackTrace();
       }
    }

    public Item findItemByName(String itemName) {
        for (Item aItem : items) {
            if (aItem.getName().equals(itemName)) {
                return aItem;
            }
        }
        return null;
    }

}
