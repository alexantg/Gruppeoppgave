package Controller;

import Model.AntiqueShop;
import Repository.IAntiqueSystemRep;
import io.javalin.http.BadRequestResponse;
import io.javalin.http.Context;
import kong.unirest.HttpStatus;

public class AntiqueShopController {
    private IAntiqueSystemRep iAntiqueSystemRep;

    public AntiqueShopController(IAntiqueSystemRep iAntiqueSystemRep) {
        this.iAntiqueSystemRep = iAntiqueSystemRep;
    }

    public void getShop(Context context){
        String name = context.pathParam("shop-id");
        if(name ==null || name.length()<10){
            context.status(HttpStatus.BAD_REQUEST);
        }
        context.json(iAntiqueSystemRep.getShop(name));
        context.status(HttpStatus.ACCEPTED);

    }

    public void getAllShops(Context context){
        context.json(iAntiqueSystemRep.getAllShops());
        context.status(201);
    }

    // method for creating shops
    public void createShop(Context context){
        iAntiqueSystemRep.createShop(dataFromInputShop(context));
        context.redirect("/user/");
        context.status(202);
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