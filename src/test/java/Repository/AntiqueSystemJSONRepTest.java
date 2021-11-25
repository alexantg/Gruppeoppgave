package Repository;

import Model.AntiqueShop;
import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mockito.*;
import static org.junit.Assert.*;



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

    }

    @Test
    public void testGetAllShops() {
        AntiqueShop shopOne = new AntiqueShop("Test","Test", "Test");
        AntiqueShop shopTwo = new AntiqueShop("TestTwo", "TestTwo", "TestTwo");
        ArrayList<AntiqueShop> testList = new ArrayList<>();
        testList.add(shopOne);
        testList.add(shopTwo);


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