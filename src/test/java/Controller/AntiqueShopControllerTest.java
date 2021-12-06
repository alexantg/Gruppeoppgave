package Controller;

import Model.AntiqueShop;
import Repository.AntiqueSystemJSONRep;
;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.plugin.json.JavalinJson;
import junit.framework.TestCase;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.Unirest.*;
import org.eclipse.jetty.client.api.Response;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;
import io.javalin.Javalin;

import javax.servlet.http.HttpServletRequest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class AntiqueShopControllerTest extends TestCase {
    Javalin app = Javalin.create();

    @Test
    public void testGetAllShops() {

        app.start(8000);

        AntiqueSystemJSONRep iAntiqueSystemJSONRep = new AntiqueSystemJSONRep("src/main/resources/test.json");
        AntiqueShopController antiqueShopController = new AntiqueShopController(iAntiqueSystemJSONRep);
        iAntiqueSystemJSONRep.readShopsFromFile();

        app.get("api/shops", antiqueShopController::getAllShops);

        HttpResponse<JsonNode> response = Unirest.get("http://localhost:8000/api/shops").asJson();
        assertThat(response.getStatus()).isEqualTo(201);

        app.stop();

    }

    public void testGetShop() {

    }

    public void testCreateShop() {
    }

    public void testDataFromInputShop() {
    }
}