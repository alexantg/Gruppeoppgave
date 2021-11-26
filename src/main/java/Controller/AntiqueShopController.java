package Controller;

import Model.AntiqueShop;
import Repository.IAntiqueSystemRep;
import io.javalin.http.Context;

public class AntiqueShopController {
    private IAntiqueSystemRep iAntiqueSystemRep;

    public AntiqueShopController(IAntiqueSystemRep iAntiqueSystemRep) {
        this.iAntiqueSystemRep = iAntiqueSystemRep;
    }

    public void getShop(Context context){
        String name = context.pathParam("shop-id");
        context.json(iAntiqueSystemRep.getShop(name));
    }

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