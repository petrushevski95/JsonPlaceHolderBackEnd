import client.JsonPlaceClient;
import data.JsonPlaceDataFactoryPOST;
import data.JsonPlaceDataFactoryPUT;
import io.restassured.response.Response;
import models.request.JsonPlaceModelRequestPOST;
import models.request.JsonPlaceModelRequestPUT;
import models.response.JsonPlaceModelResponseGET_GETALL;
import models.response.JsonPlaceModelResponsePOST;
import models.response.JsonPlaceModelResponsePUT;
import org.junit.Test;

import java.util.List;

import static objectbuilder.JsonPlacePOST.createBodyForPostRequest;
import static objectbuilder.JsonPlacePUT.createBodyForPutRequest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class JsonPlaceApiTest {

    @Test
    public void getAllResponse(){
        Response getResponse = new JsonPlaceClient()
                .getAllPost();

        List<JsonPlaceModelResponseGET_GETALL> response = getResponse
                .body()
                .jsonPath()
                .getList("", JsonPlaceModelResponseGET_GETALL.class);

        assertEquals(200,getResponse.statusCode());
        assertFalse(response.isEmpty());

    }

    @Test
    public void getPost(){
        String body = "quia et suscipit\nsuscipit recusandae consequuntur " +
                "expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est " +
                "autem sunt rem eveniet architecto";

        Response getResponse = new JsonPlaceClient()
                .getPost("28");

        JsonPlaceModelResponseGET_GETALL
                getResponseSingleId = getResponse.body().as(JsonPlaceModelResponseGET_GETALL.class);

        assertEquals(200, getResponse.statusCode());
        assertEquals("delectus ullam et corporis nulla voluptas sequi",getResponseSingleId.getTitle());
        assertEquals(body,getResponseSingleId.getBody());
    }

    @Test
    public void updatePutDefaultValuesTest() {

        JsonPlaceModelRequestPUT requestBody = new JsonPlaceDataFactoryPUT(createBodyForPutRequest())
                .createRequest();

        Response putResponse = new JsonPlaceClient() //prakjame request put
                .updatePut(requestBody, "50");

        JsonPlaceModelResponsePUT response = putResponse.body().as(JsonPlaceModelResponsePUT.class);

        assertEquals(200, putResponse.statusCode());
        assertEquals("Default value", response.getBody());
        assertEquals("Default value", response.getTitle());

    }


    @Test
    public void updatePutTest() {

        JsonPlaceModelRequestPUT requestBody = new JsonPlaceDataFactoryPUT(createBodyForPutRequest())
                .setBody("Update Value")
                .setTitle("Update Value")
                .createRequest();

        Response putResponse = new JsonPlaceClient() //prakjame request put
                .updatePut(requestBody, "50");

        JsonPlaceModelResponsePUT response = putResponse.body().as(JsonPlaceModelResponsePUT.class);

        assertEquals(200, putResponse.statusCode());
        assertEquals("Update Value", response.getBody());
        assertEquals("Update Value", response.getTitle());

    }

    @Test
    public void createPostDefaultValuesTest() {

        JsonPlaceModelRequestPOST requestBody = new JsonPlaceDataFactoryPOST(createBodyForPostRequest())
                .createRequest();


        Response postResponse = new JsonPlaceClient()
                .createPost(requestBody);

        JsonPlaceModelResponsePOST response = postResponse.body().as(JsonPlaceModelResponsePOST.class);

        assertEquals(201, postResponse.statusCode());
        assertEquals("Default value", response.getBody());
        assertEquals("Default value", response.getTitle());

    }

    @Test
    public void createPostTest() {

        JsonPlaceModelRequestPOST requestBody = new JsonPlaceDataFactoryPOST(createBodyForPostRequest())
                .setBody("Makedonija osvoi svetsko prvenstvo")
                .setTitle("Makedonija go osvoi svetskoto prvenstvo")
                .createRequest();


        Response postResponse = new JsonPlaceClient()
                .createPost(requestBody);

        JsonPlaceModelResponsePOST response = postResponse.body().as(JsonPlaceModelResponsePOST.class);

        assertEquals(201, postResponse.statusCode());
        assertEquals("Makedonija osvoi svetsko prvenstvo", response.getBody());
        assertEquals("Makedonija go osvoi svetskoto prvenstvo", response.getTitle());

    }

    @Test
    public void deletePost(){
        Response getResponse = new JsonPlaceClient()
                .deletePost("20");

        assertEquals(200,getResponse.statusCode());
    }


}






