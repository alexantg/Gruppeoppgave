package Controller;

import Model.AntiqueShop;
import Model.Item;
import Repository.IAntiqueSystemRep;
import io.javalin.http.Context;

import java.util.ArrayList;

public class ItemController {
    private IAntiqueSystemRep iAntiqueSystemRep;

    public ItemController(IAntiqueSystemRep iAntiqueSystemRep) {
        this.iAntiqueSystemRep = iAntiqueSystemRep;
    }

    public void createItem(Context context){
        String shopName = context.pathParam("shop-id");
        iAntiqueSystemRep.createItem(shopName,dataFromInputItem(context));
        context.redirect("/user/");
    }

    public void getAllItems(Context context){
        String shopName  = context.pathParam("shop-id");
        context.json(iAntiqueSystemRep.getAllItems(shopName));
    }

    public void getOneItem(Context context){
        String shopName = context.pathParam("shop-id");
        String itemName = context.pathParam("item-id");

        Item aItem = iAntiqueSystemRep.getOneItem(shopName, itemName);

        context.json(aItem);
    }


    public Item dataFromInputItem(Context context){
        String name;
        String description;
        String pictureUrl;
        String price;

        name = context.formParam("itemName");
        description = context.formParam("description");
        pictureUrl = context.formParam("pictureUrl");
        price = context.formParam("price");

        return new Item(name, description, price, pictureUrl);
    }

}
