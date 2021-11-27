import Controller.AntiqueShopController;
import Repository.AntiqueSystemJSONRep;
import Controller.ItemController;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.plugin.rendering.vue.VueComponent;
import org.jetbrains.annotations.NotNull;


public class Application{

    public static void main(String[] args) {

        Javalin app = Javalin.create().start(7000);
        app.config.enableWebjars();

        AntiqueSystemJSONRep iAntiqueSystemJSONRep = new AntiqueSystemJSONRep("src/main/resources/db.json");
        AntiqueShopController antiqueShopController = new AntiqueShopController(iAntiqueSystemJSONRep);
        ItemController itemController = new ItemController(iAntiqueSystemJSONRep);

        iAntiqueSystemJSONRep.readShopsFromFile();

        //Views/
        app.get("/", new VueComponent("login"));
        app.get("/admin/", new VueComponent("mainpage-admin"));


        app.get("/enduser/", new VueComponent("mainpage-enduser"));
        app.get("/enduser/:shop-id/", new VueComponent("enduser-detail"));


        app.get("/user/", new VueComponent("mainpage-user"));
        app.get("/user/registershop/", new VueComponent("user-create-shop"));
        app.get("/user/:shop-id/", new VueComponent("user-shop-detail"));
        app.get("/user/:shop-id/add", new VueComponent("add-item-user"));


        //post
        app.post("api/user/createshop",antiqueShopController::createShop);
        app.post("api/user/:shop-id/createItem", itemController::createItem);

        //Get-requests
        app.get("api/items/:shop-id", itemController::getAllItems);
        app.get("api/shops", antiqueShopController::getAllShops);
        app.get("api/user/:shop-id", antiqueShopController::getShop);

    }
}
