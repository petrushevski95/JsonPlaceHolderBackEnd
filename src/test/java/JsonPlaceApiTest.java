import client.JsonPlaceClient;
import data.JsonPlaceDataFactoryPOST;
import data.JsonPlaceDataFactoryPUT;
import io.restassured.response.Response;
import models.request.JsonPlaceModelRequestPOST_PUT;
import models.response.JsonPlaceModelResponseGET_POST_PUT;
import org.junit.Test;

import java.util.List;

import static objectbuilder.JsonPlacePOST_PUT.createBodyForPostRequest;
import static objectbuilder.JsonPlacePOST_PUT.createBodyForPutRequest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class JsonPlaceApiTest {

    @Test
    public void getAllRequestTest() {
        Response getResponse = new JsonPlaceClient()
                .getAllPost();

        List<JsonPlaceModelResponseGET_POST_PUT> response = getResponse
                .body()
                .jsonPath()
                .getList("", JsonPlaceModelResponseGET_POST_PUT.class);

        assertEquals(200,getResponse.statusCode());
        assertFalse(response.isEmpty());
    }

    @Test
    public void getSingleRequestTest() {
        String body = "non et quaerat ex quae ad maiores\n" +
                "maiores recusandae totam aut blanditiis mollitia quas illo\n" +
                "ut voluptatibus voluptatem\n" +
                "similique nostrum eum";

        Response getResponse = new JsonPlaceClient()
                .getSingleRequest("28");

        JsonPlaceModelResponseGET_POST_PUT
                response = getResponse.body().as(JsonPlaceModelResponseGET_POST_PUT.class);

        assertEquals(200, getResponse.statusCode());
        assertEquals("delectus ullam et corporis nulla voluptas sequi",response.getTitle());
        assertEquals(body,response.getBody());
    }

    @Test
    public void postRequestDefaultValuesTest() {
        JsonPlaceModelRequestPOST_PUT requestBody = new JsonPlaceDataFactoryPOST(createBodyForPostRequest())
                .createRequest();


        Response postResponse = new JsonPlaceClient()
                .postRequest(requestBody);

        JsonPlaceModelResponseGET_POST_PUT response = postResponse.body().as(JsonPlaceModelResponseGET_POST_PUT.class);

        assertEquals(201, postResponse.statusCode());
        assertEquals("Default value", response.getBody());
        assertEquals("Default value", response.getTitle());

    }

    @Test
    public void postRequestUpdatedValuesTest() {
        JsonPlaceModelRequestPOST_PUT requestBody = new JsonPlaceDataFactoryPOST(createBodyForPostRequest())
                .setBody("Updated value")
                .setTitle("Updated value")
                .createRequest();


        Response postResponse = new JsonPlaceClient()
                .postRequest(requestBody);

        JsonPlaceModelResponseGET_POST_PUT response = postResponse.body().as(JsonPlaceModelResponseGET_POST_PUT.class);

        assertEquals(201, postResponse.statusCode());
        assertEquals("Updated value", response.getBody());
        assertEquals("Updated value", response.getTitle());
    }

    @Test
    public void putDefaultValuesRequestTest() {
        JsonPlaceModelRequestPOST_PUT requestBody = new JsonPlaceDataFactoryPUT(createBodyForPutRequest())
                .createRequest();

        Response putResponse = new JsonPlaceClient().putRequest(requestBody, "28");

        JsonPlaceModelResponseGET_POST_PUT response = putResponse.body().as(JsonPlaceModelResponseGET_POST_PUT.class);

        assertEquals(200, putResponse.statusCode());
        assertEquals("Default value", response.getBody());
        assertEquals("Default value", response.getTitle());
    }

    @Test
    public void putUpdatedValuesRequestTest() {
        JsonPlaceModelRequestPOST_PUT requestBody = new JsonPlaceDataFactoryPUT(createBodyForPutRequest())
                .setBody("Updated value")
                .setTitle("Updated value")
                .createRequest();

        Response putResponse = new JsonPlaceClient().putRequest(requestBody, "28");

        JsonPlaceModelResponseGET_POST_PUT response = putResponse.body().as(JsonPlaceModelResponseGET_POST_PUT.class);

        assertEquals(200, putResponse.statusCode());
        assertEquals("Updated value", response.getBody());
        assertEquals("Updated value", response.getTitle());
    }

    @Test
    public void deleteRequestTest() {
        Response getResponse = new JsonPlaceClient()
                .deleteRequest("20");

        assertEquals(200,getResponse.statusCode());
    }

}






