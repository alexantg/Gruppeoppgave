package Model;

import java.util.ArrayList;

public class AntiqueShop {
        private String name;
        private String email;
        private String address;
        private ArrayList<Item> items;

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

}
