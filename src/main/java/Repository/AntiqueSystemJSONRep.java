package Repository;

import Model.AntiqueShop;
import Model.Item;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AntiqueSystemJSONRep implements IAntiqueSystemRep {
    private String fileName;
    ArrayList<AntiqueShop> shopsFromFile = new ArrayList<>();
    //ArrayList<Item> itemsFromFile = new ArrayList<>();
   // private HashMap<String, Item> itemHashMap = new HashMap<>();

    public AntiqueSystemJSONRep(String fileName) {
        this.fileName = fileName;
       // this.itemHashMap = readFromJSON(fileName);
    }

    //Print to file ------------------------------------------------------
    public void printShopsToFile(ArrayList<AntiqueShop> antiqueShopsIn){
        ObjectMapper objectMapper= new ObjectMapper();

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), antiqueShopsIn);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printItemsToFile(ArrayList<Item> itemsIn){
        ObjectMapper objectMapper= new ObjectMapper();

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), itemsIn);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Read from file -----------------------------------------------------
    public ArrayList<AntiqueShop> readShopsFromFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            AntiqueShop[] shopArray = objectMapper.readValue(new File(fileName), AntiqueShop[].class);
            shopsFromFile.addAll(Arrays.asList(shopArray));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return shopsFromFile;

    }

  /*  public ArrayList<Item> readItemsFromFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            Item[] itemArray = objectMapper.readValue(new File(fileName), Item[].class);
            itemsFromFile.addAll(Arrays.asList(itemArray));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemsFromFile;

    }*/

    @Override
    public AntiqueShop getShop(String shopName){
        for(AntiqueShop s : shopsFromFile){
            if(s.getName().equals(shopName)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public ArrayList<AntiqueShop> getAllShops(){
        return shopsFromFile;
    }

    @Override
    public void createShop(AntiqueShop shop){
        shopsFromFile.add(shop);
        printShopsToFile(shopsFromFile);
    }

    @Override
    public void createItem(String shopName,Item newItem){
        for(AntiqueShop shop : shopsFromFile){
            if(shop.getName().equals(shopName)){
                shop.addItem(newItem);
            }
        }
    }

  /*  public HashMap<String, Item> readFromJSON(String fileName) {
        ArrayList<Item> itemArrayList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Item[] itemsArray = objectMapper.readValue(new File(fileName), Item[].class);
            itemArrayList.addAll(Arrays.asList(itemsArray));

            for (Item item : itemArrayList) {
                itemHashMap.put(item.getName(), item);
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        return itemHashMap;
   } */

   /* public void writeToJSON(String fileName) {
        Thread newThread = new Thread(() ->{
            ObjectMapper objectMapper = new ObjectMapper();

            try {
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName),
                        itemHashMap.values().toArray(Item[]::new));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        newThread.start();
    } */

   /* @Override
    public ArrayList<Item> getAllItems() {
        return new ArrayList<>(itemHashMap.values());
    } */

  /*  @Override
    public Item getOneItem(String name) {
        ArrayList<Item> listOfItems = new ArrayList<>(itemHashMap.values());

        for (Item item : listOfItems) {
            if (item.getName().equals(name))
                return item;
        }
        return null;
    } */

}
