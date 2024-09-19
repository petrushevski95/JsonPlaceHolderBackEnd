import client.JsonPlaceClient;
import data.JsonPlaceDataFactoryPost;
import data.JsonPlaceDataFactoryPut;
import io.restassured.response.Response;
import models.request.JsonPlaceModelRequestPostPut;
import models.response.JsonPlaceModelResponseGetPostPut;
import org.junit.Test;

import java.util.List;

import static objectbuilder.JsonPlacePostPut.createBodyForPostAndPutRequest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class JsonPlaceApiTest {

    @Test
    public void getAllRequestTest() {
        Response getResponse = new JsonPlaceClient()
                .getAllPost();

        List<JsonPlaceModelResponseGetPostPut> response = getResponse
                .body()
                .jsonPath()
                .getList("", JsonPlaceModelResponseGetPostPut.class);

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

        JsonPlaceModelResponseGetPostPut
                response = getResponse.body().as(JsonPlaceModelResponseGetPostPut.class);

        assertEquals(200, getResponse.statusCode());
        assertEquals("delectus ullam et corporis nulla voluptas sequi",response.getTitle());
        assertEquals(body,response.getBody());
    }

    @Test
    public void postRequestDefaultValuesTest() {
        JsonPlaceModelRequestPostPut requestBody = new JsonPlaceDataFactoryPost(createBodyForPostAndPutRequest())
                .createRequest();


        Response postResponse = new JsonPlaceClient()
                .postRequest(requestBody);

        JsonPlaceModelResponseGetPostPut response = postResponse.body().as(JsonPlaceModelResponseGetPostPut.class);

        assertEquals(201, postResponse.statusCode());
        assertEquals("Default value", response.getBody());
        assertEquals("Default value", response.getTitle());

    }

    @Test
    public void postRequestUpdatedValuesTest() {
        JsonPlaceModelRequestPostPut requestBody = new JsonPlaceDataFactoryPost(createBodyForPostAndPutRequest())
                .setBody("Updated value")
                .setTitle("Updated value")
                .createRequest();


        Response postResponse = new JsonPlaceClient()
                .postRequest(requestBody);

        JsonPlaceModelResponseGetPostPut response = postResponse.body().as(JsonPlaceModelResponseGetPostPut.class);

        assertEquals(201, postResponse.statusCode());
        assertEquals("Updated value", response.getBody());
        assertEquals("Updated value", response.getTitle());
    }

    @Test
    public void putDefaultValuesRequestTest() {
        JsonPlaceModelRequestPostPut requestBody = new JsonPlaceDataFactoryPut(createBodyForPostAndPutRequest())
                .createRequest();

        Response putResponse = new JsonPlaceClient().putRequest(requestBody, "28");

        JsonPlaceModelResponseGetPostPut response = putResponse.body().as(JsonPlaceModelResponseGetPostPut.class);

        assertEquals(200, putResponse.statusCode());
        assertEquals("Default value", response.getBody());
        assertEquals("Default value", response.getTitle());
    }

    @Test
    public void putUpdatedValuesRequestTest() {
        JsonPlaceModelRequestPostPut requestBody = new JsonPlaceDataFactoryPut(createBodyForPostAndPutRequest())
                .setBody("Updated value")
                .setTitle("Updated value")
                .createRequest();

        Response putResponse = new JsonPlaceClient().putRequest(requestBody, "28");

        JsonPlaceModelResponseGetPostPut response = putResponse.body().as(JsonPlaceModelResponseGetPostPut.class);

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






