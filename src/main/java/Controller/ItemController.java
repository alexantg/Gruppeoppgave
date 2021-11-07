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

  /*  public void getAllItems(Context context) {
        ArrayList<Item> allItems = iAntiqueSystemRep.getAllItems();

        context.json(allItems);
    } */

   /* public void getOneItem(Context context) {
        String itemID = context.pathParam(":item-id");

        Item aItem = iAntiqueSystemRep.getOneItem(itemID);

        context.json(aItem);
    } */

    public void getAllShops(Context context){
        context.json(iAntiqueSystemRep.getAllShops());
    }

    public void createShop(Context context){
        iAntiqueSystemRep.createShop(dataFromInputShop(context));
        context.redirect("/user/");
    }

    //get data from form-input when creating
    public AntiqueShop dataFromInputShop(Context context){
        String name;
        String email;
        String address;

        name = context.formParam("shopName");
        email = context.formParam("email");
        address = context.formParam("address");

        AntiqueShop shop = new AntiqueShop(name,email,address);
         return shop;
    }

}
