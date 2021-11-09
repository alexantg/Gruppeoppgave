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
        ItemController itemController = new ItemController(iAntiqueSystemJSONRep);

        iAntiqueSystemJSONRep.readShopsFromFile();

        //Views/
        app.get("/", new VueComponent("login"));
        app.get("/admin/", new VueComponent("mainpage-admin"));
        app.get("/user/", new VueComponent("mainpage-user"));
        app.get("/enduser/", new VueComponent("mainpage-enduser"));
        app.get("/user/registershop/", new VueComponent("user-create-shop"));
        app.get("/user/:shop-id/", new VueComponent("user-shop-detail"));
        app.get("/user/:shop.id/additem/", new VueComponent("user-add-item-to-shop"));


        //post
        app.post("api/user/createshop",itemController::createShop);
        app.post("api/user/:shop.id/createItem", itemController::createItem);

        //Get-requests
        app.get("api/shops", itemController::getAllShops);
        app.get("api/user/:shop-id", itemController::getShop);

      /*  app.get("api/item/", new Handler(){
            @Override
            public void handle(@NotNull Context context) throws Exception {
                itemController.getAllItems(context);
            }
        });*/
    }
}
