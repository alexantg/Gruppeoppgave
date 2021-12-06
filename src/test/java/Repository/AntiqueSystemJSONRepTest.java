package Repository;

import Model.AntiqueShop;
import Model.Item;
import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mockito.*;
import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.instanceOf;



import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class AntiqueSystemJSONRepTest {

    @Test
    public void testPrintShopsToFile() {
        AntiqueShop shopOne = new AntiqueShop("Test","Test", "Test");
        AntiqueShop shopTwo = new AntiqueShop("TestTwo", "TestTwo", "TestTwo");
        ArrayList<AntiqueShop> testList = new ArrayList<>();
        testList.add(shopOne);
        testList.add(shopTwo);

        AntiqueSystemJSONRep rep = mock(AntiqueSystemJSONRep.class);

        doNothing().when(rep).printShopsToFile(testList);
        rep.printShopsToFile(testList);
        verify(rep,times(1)).printShopsToFile(testList);
    }


    @Test
    public void testReadShopsFromFile() {
        AntiqueShop shopOne = new AntiqueShop("Test","Test", "Test");
        AntiqueShop shopTwo = new AntiqueShop("TestTwo", "TestTwo", "TestTwo");
        ArrayList<AntiqueShop> testList = new ArrayList<>();
        testList.add(shopOne);
        testList.add(shopTwo);

        AntiqueSystemJSONRep rep = new AntiqueSystemJSONRep("Test.json");
        rep.printShopsToFile(testList);
        assertThat(rep.readShopsFromFile(), instanceOf(ArrayList.class));
    }

    @Test
    public void testGetShop() {
        AntiqueShop shopOne = new AntiqueShop("Test","Test", "Test");
        AntiqueSystemJSONRep rep = new AntiqueSystemJSONRep("Test.json");
        rep.createShop(shopOne);

        assertEquals(shopOne, rep.getShop(shopOne.getName()));
    }

    @Test
    public void testGetAllShops() {
        AntiqueShop shopOne = new AntiqueShop("Test","Test", "Test");
        ArrayList<AntiqueShop> shops = new ArrayList<>();
        shops.add(shopOne);
        AntiqueSystemJSONRep rep = new AntiqueSystemJSONRep("Test.json");
        rep.createShop(shopOne);

        assertEquals(shops, rep.getAllShops());
    }

    @Test
    public void testCreateShop() {
        AntiqueShop shopOne = new AntiqueShop("Test","Test", "Test");
        AntiqueSystemJSONRep rep = mock(AntiqueSystemJSONRep.class);

        doNothing().when(rep).createShop(shopOne);
        rep.createShop(shopOne);
        verify(rep,times(1)).createShop(shopOne);

    }

    @Test
    public void testCreateItem() {
        AntiqueShop shopOne = new AntiqueShop("Test","Test", "Test");
        Item item = new Item("TestItem", "TestItem", "TestItem", "TestItem");
        shopOne.addItem(item);
        AntiqueSystemJSONRep rep = mock(AntiqueSystemJSONRep.class);
        doNothing().when(rep).createItem("shopOne", item);
        rep.createItem("shopOne", item);
        verify(rep,times(1)).createItem("shopOne", item);

    }

    @Test
    public void testGetAllItems() {
        AntiqueShop shopOne = new AntiqueShop("Test","Test", "Test");
        Item item = new Item("TestItem", "TestItem", "TestItem", "TestItem");
        ArrayList<Item> expected = new ArrayList<>();
        expected.add(item);
        shopOne.addItem(item);
        AntiqueSystemJSONRep rep = new AntiqueSystemJSONRep("Test.json");
        rep.createShop(shopOne);

        assertEquals(expected, rep.getAllItems("Test"));

    }
    @Test
    public void testGetOneItem(){

    }

}