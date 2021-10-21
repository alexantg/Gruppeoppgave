import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.VueComponent;

public class Application{

    public static void main(String[] args) {

        Javalin app = Javalin.create().start(7000);
        app.config.enableWebjars();

        //Views/
        app.get("/", new VueComponent("login"));
        app.get("/admin/", new VueComponent("admin-front"));
        app.get("/user/", new VueComponent(""));
    }
}
