package Model;

import junit.framework.TestCase;

import java.util.ArrayList;

public class AntiqueShopTest extends TestCase {

    public void testTestGetName() {
        AntiqueShop shop = new AntiqueShop("Test", "Testmail", "Testaddress");
        String name = shop.getName();
        assertEquals("Test", name);
    }

    public void testTestSetName() {
        AntiqueShop shop = new AntiqueShop();
        shop.setName("Test");
        assertEquals("Test", shop.getName());
    }

    public void testGetEmail() {
        AntiqueShop shop = new AntiqueShop("Test", "Testmail", "Testaddress");
        String mail = shop.getEmail();
        assertEquals("Testmail", mail);
    }

    public void testSetEmail() {
        AntiqueShop shop = new AntiqueShop();
        shop.setEmail("Testmail@gmail.com");
        assertEquals("Testmail@gmail.com", shop.getEmail());
    }

    public void testGetAddress() {
        AntiqueShop shop = new AntiqueShop("Test", "Testmail", "Testaddress");
        String address = shop.getAddress();
        assertEquals("Testaddress", address);
    }

    public void testSetAddress() {
        AntiqueShop shop = new AntiqueShop("Test", "Testmail", "Testaddress");
        String address = shop.getAddress();
        assertEquals("Testaddress", address);
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
        AntiqueShop shop = new AntiqueShop();
        ArrayList<Item> items = new ArrayList<>();
        Item item = new Item("Name", "Description", "Price", "PictureURL");
        items.add(item);
        shop.setItems(items);

        assertEquals(items, shop.getItems());


    }
    public void testAddItem() {
        AntiqueShop shop = new AntiqueShop();
        Item item = new Item("Test", "Test", "Test", "Test");
        shop.addItem(item);

        assertEquals(item, shop.getItems().get(0));
    }
}