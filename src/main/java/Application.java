package main.java;

import Repository.AntiqueSystemJSONRep;
import controller.ItemController;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.plugin.rendering.vue.VueComponent;
import org.jetbrains.annotations.NotNull;


public class Application{

    public static void main(String[] args) {

        Javalin app = Javalin.create().start(7000);
        app.config.enableWebjars();

        //Views/
        app.get("/", new VueComponent("login"));
        app.get("/admin/", new VueComponent("mainpage-admin"));
        app.get("/user/", new VueComponent("mainpage-user"));
        app.get("/enduser/", new VueComponent("mainpage-enduser"));

        AntiqueSystemJSONRep iAntiqueSystemJSONRep = new AntiqueSystemJSONRep("src/main/resources/items.json");
        ItemController itemController = new ItemController(iAntiqueSystemJSONRep);

        app.get("api/item/", new Handler(){
            @Override
            public void handle(@NotNull Context context) throws Exception {
                itemController.getAllItems(context);
            }
        });
    }
}
