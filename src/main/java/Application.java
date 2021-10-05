import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.VueComponent;

public class Application{

    public static void main(String[] args) {

        Javalin app = Javalin.create().start(7000);
        app.config.enableWebjars();

        //views/
        //api//
        app.get("/", new VueComponent("login"));
    }
}
