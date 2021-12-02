package Repository;

import Model.AntiqueShop;
import Model.Item;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class AntiqueSystemJSONRep implements IAntiqueSystemRep {
    private String fileName;
    ArrayList<AntiqueShop> shopsFromFile = new ArrayList<>();


    public AntiqueSystemJSONRep(String fileName) {
        this.fileName = fileName;
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
    public void createItem(String shopName, Item newItem){
        for(AntiqueShop shop : shopsFromFile){
            if(shop.getName().equals(shopName)){
                shop.addItem(newItem);
            }
        }
        printShopsToFile(shopsFromFile);
    }

    @Override
    public ArrayList<Item> getAllItems(String shopName) {
        for(AntiqueShop s : shopsFromFile){
            if(s.getName().equals(shopName)){
                return s.getItems();
            }
        }
        return null;
    }

    /*
    @Override
    public Item getOneItem(String shopName, String itemName) {
        return getShop(shopName).finditemByName(itemName);
    }

     */
}

