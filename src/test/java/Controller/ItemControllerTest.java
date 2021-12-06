package Controller;

import junit.framework.TestCase;
import Model.AntiqueShop;
import Repository.AntiqueSystemJSONRep;
import io.javalin.Javalin;
import io.javalin.http.Context;
import junit.framework.TestCase;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemControllerTest extends TestCase {
    Javalin app = Javalin.create();

    public void testCreateItem() {
        app.start(8000);

        AntiqueSystemJSONRep iAntiqueSystemJSONRep = new AntiqueSystemJSONRep("src/main/resources/test.json");
        ItemController itemController = new ItemController(iAntiqueSystemJSONRep);
        iAntiqueSystemJSONRep.readShopsFromFile();

        app.post("api/user/:shop-id/createItem", itemController::createItem);

        HttpResponse<JsonNode> response = Unirest.post("http://localhost:8000/api/user/TestStore/createItem").asJson();
        assertThat(response.getStatus()).isEqualTo(201);

        app.stop();

    }

    public void testGetAllItems() {
        app.start(8000);

        AntiqueSystemJSONRep iAntiqueSystemJSONRep = new AntiqueSystemJSONRep("src/main/resources/test.json");
        ItemController controller = new ItemController(iAntiqueSystemJSONRep);
        iAntiqueSystemJSONRep.readShopsFromFile();

        app.get("api/items/:shop-id", controller::getAllItems);

        HttpResponse<JsonNode> response = Unirest.get("http://localhost:8000/api/items/TestStore").asJson();
        assertThat(response.getStatus()).isEqualTo(201);

        app.stop();

    }

    public void testGetOneItem(){
        app.start(8000);

        AntiqueSystemJSONRep iAntiqueSystemJSONRep = new AntiqueSystemJSONRep("src/main/resources/test.json");
        ItemController controller = new ItemController(iAntiqueSystemJSONRep);
        iAntiqueSystemJSONRep.readShopsFromFile();

        app.get("api/enduser/:shop-id/items/:item-id/", controller::getOneItem);

        HttpResponse<JsonNode> response = Unirest.get("http://localhost:8000/api/enduser/TestStore/items/Vase/").asJson();
        assertThat(response.getStatus()).isEqualTo(201);

        app.stop();
    }

    public void testDataFromInputItem() {

    }
}