package controller;

import Model.Item;
import Repository.IAntiqueSystemRep;
import io.javalin.http.Context;

import java.util.ArrayList;

public class ItemController {
    private IAntiqueSystemRep iAntiqueSystemRep;

    public ItemController(IAntiqueSystemRep iAntiqueSystemRep) {
        this.iAntiqueSystemRep = iAntiqueSystemRep;
    }

    public void getAllItems(Context context) {
        ArrayList<Item> allItems = iAntiqueSystemRep.getAllItems();

        context.json(allItems);
    }

    public void getOneItem(Context context) {
        String itemID = context.pathParam(":item-id");

        Item aItem = iAntiqueSystemRep.getOneItem(itemID);

        context.json(aItem);
    }
}
