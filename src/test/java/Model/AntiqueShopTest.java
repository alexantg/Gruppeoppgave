package Model;

import Model.AntiqueShop;
import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mockito.*;
import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.instanceOf;


import junit.framework.TestCase;

import java.util.ArrayList;

public class AntiqueShopTest extends TestCase {

    public void testTestGetName() {
        AntiqueShop shop = new AntiqueShop("Test", "Testmail", "Testaddress");
        String name = shop.getName();
        assertEquals("Test", name);
    }

    public void testTestSetName() {
    }

    public void testGetEmail() {
        AntiqueShop shop = new AntiqueShop("Test", "Testmail", "Testaddress");
        String mail = shop.getEmail();
        assertEquals("Testmail", mail);
    }

    public void testSetEmail() {
    }

    public void testGetAddress() {
        AntiqueShop shop = new AntiqueShop("Test", "Testmail", "Testaddress");
        String address = shop.getAddress();
        assertEquals("Testaddress", address);
    }

    public void testSetAddress() {
    }

    public void testGetItems() {
        AntiqueShop shop = new AntiqueShop("Name", "Mail", "Address");
        ArrayList<Item> items = new ArrayList<>();
        Item item = new Item("Name", "Description", "Price", "PictureURL");
        items.add(item);
        shop.addItem(item);

        assertEquals(items, shop.getItems());

    }

    public void testSetItems() {
    }

    public void testAddItem() {
    }
}