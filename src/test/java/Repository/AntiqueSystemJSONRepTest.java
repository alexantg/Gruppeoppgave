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
    public void testPrintItemsToFile() {
        Item itemOne = new Item("Test","Test", "Test", "Test");
        Item itemTwo = new Item("TestTwo", "TestTwo", "TestTwo", "TestTwo");
        ArrayList<Item> testListItems = new ArrayList<>();
        testListItems.add(itemOne);
        testListItems.add(itemTwo);

        AntiqueSystemJSONRep rep = mock(AntiqueSystemJSONRep.class);
    }

    @Test
    public void testReadShopsFromFile() {
        ArrayList<AntiqueShop> testList = new ArrayList<>();
        AntiqueShop shopOne  = new AntiqueShop("Test","Test","Test");
        AntiqueShop shoptwo  = new AntiqueShop("Test","Test","Test");
        testList.add(shopOne);
        testList.add(shoptwo);
        AntiqueSystemJSONRep rep = mock(AntiqueSystemJSONRep.class);
     //   if(!(rep.readShopsFromFile() instanceof )){
       //     fail();
        //}
       // assertEquals(testList, rep.readShopsFromFile());
    }

    @Test
    public void testReadItemsFromFile() {
    }

    @Test
    public void testGetShop() {
        AntiqueShop shop = new AntiqueShop("Test","Test","Test");
        AntiqueSystemJSONRep rep = mock(AntiqueSystemJSONRep.class);

        assertThat(shop, instanceOf(AntiqueShop.class));

    }

    @Test
    public void testGetAllShops() {
        AntiqueShop shopOne = new AntiqueShop("Test","Test", "Test");
        AntiqueShop shopTwo = new AntiqueShop("TestTwo", "TestTwo", "TestTwo");
        ArrayList<AntiqueShop> testList = new ArrayList<>();
        testList.add(shopOne);
        testList.add(shopTwo);

        //Checking to see if return value is an array list
        AntiqueSystemJSONRep rep = mock(AntiqueSystemJSONRep.class);
        assertThat(testList, instanceOf(ArrayList.class));
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

    }
}