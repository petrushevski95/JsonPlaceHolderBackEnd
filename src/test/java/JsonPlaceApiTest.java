import data.JsonPlaceModelDataFactoryPost;
import data.JsonPlaceModelDataFactoryPut;
import io.restassured.response.Response;
import jsonplaceclient.JsonPlaceClient;
import models.request.JsonPlaceHolderModelPostRequest;
import models.request.JsonPlaceHolderModelPutRequest;
import models.response.JsonPlaceHolderModelGet_GetAll_Post_PutResponse;
import org.junit.Test;

import java.util.List;

import static objectbuilder.JsonPlacePost.createBodyForPostRequest;
import static objectbuilder.JsonPlacePost.createBodyForPutRequest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class JsonPlaceApiTest {

    @Test
    public void getSingleRequest(){

        Response getResponse = new JsonPlaceClient()
                .getRequest("28");

        JsonPlaceHolderModelGet_GetAll_Post_PutResponse
                response = getResponse.body().as(JsonPlaceHolderModelGet_GetAll_Post_PutResponse.class);

        String body = "non et quaerat ex quae ad maiores\n" +
                "maiores recusandae totam aut blanditiis mollitia quas illo\n" +
                "ut voluptatibus voluptatem\n" +
                "similique nostrum eum";

        assertEquals(200,getResponse.statusCode());
        assertEquals(28,response.getId());
        assertEquals(3,response.getUserId());
        assertEquals("delectus ullam et corporis nulla voluptas sequi",response.getTitle());

        assertEquals(body,response.getBody());
    }

    @Test
    public void getAllRequest(){

        Response getResponse = new JsonPlaceClient()
                .getAllRequest();

        List<JsonPlaceHolderModelGet_GetAll_Post_PutResponse> response = getResponse
                .body()
                .jsonPath()
                .getList("", JsonPlaceHolderModelGet_GetAll_Post_PutResponse.class);

        assertEquals(200,getResponse.statusCode());
        assertFalse(response.isEmpty());
    }

    @Test
    public void postDefaultValuesRequest(){

        JsonPlaceHolderModelPostRequest bodyRequest = new JsonPlaceModelDataFactoryPost(createBodyForPostRequest())
                .setBody("Default value")
                .setTitle("Default value")
                .setUserId(150)
                .createRequest();

        Response getResponse = new JsonPlaceClient()
                .postRequest(bodyRequest);

        JsonPlaceHolderModelGet_GetAll_Post_PutResponse
                response = getResponse.body().as(JsonPlaceHolderModelGet_GetAll_Post_PutResponse.class);

        assertEquals(201,getResponse.statusCode());
        assertEquals("Default value",response.getBody());
        assertEquals("Default value",response.getTitle());
        assertEquals(150,response.getUserId());
    }

    @Test
    public void postCustomValuesRequest(){

        JsonPlaceHolderModelPostRequest bodyRequest = new JsonPlaceModelDataFactoryPost(createBodyForPostRequest())
                .setBody("Chelsea has won the champions league")
                .setTitle("Chelsea has won the 2024/2025 champions league")
                .setUserId(121)
                .createRequest();

        Response getResponse = new JsonPlaceClient()
                .postRequest(bodyRequest);

        JsonPlaceHolderModelGet_GetAll_Post_PutResponse
                response = getResponse.body().as(JsonPlaceHolderModelGet_GetAll_Post_PutResponse.class);

        assertEquals(201,getResponse.statusCode());
        assertEquals("Chelsea has won the champions league",response.getBody());
        assertEquals("Chelsea has won the 2024/2025 champions league",response.getTitle());
        assertEquals(121,response.getUserId());
    }

    @Test
    public void putDefaultValuesRequest(){

        JsonPlaceHolderModelPutRequest bodyRequest = new JsonPlaceModelDataFactoryPut(createBodyForPutRequest())
                .setBody("Default Value")
                .setTitle("Default Value")
                .setUserId(28)
                .createRequest();

        Response getResponse = new JsonPlaceClient()
                .putRequest(bodyRequest,"28");

        JsonPlaceHolderModelGet_GetAll_Post_PutResponse
                response = getResponse.body().as(JsonPlaceHolderModelGet_GetAll_Post_PutResponse.class);

        assertEquals(200,getResponse.statusCode());
        assertEquals("Default Value",response.getBody());
        assertEquals("Default Value",response.getTitle());
        assertEquals(28,response.getUserId());
        assertEquals(28,response.getId());
    }

    @Test
    public void putCustomValuesRequest(){

        JsonPlaceHolderModelPutRequest bodyRequest = new JsonPlaceModelDataFactoryPut(createBodyForPutRequest())
                .setBody("Chelsea has won the champions league")
                .setTitle("Chelsea has won the 2024/2025 champions league")
                .setUserId(28)
                .createRequest();

        Response getResponse = new JsonPlaceClient()
                .putRequest(bodyRequest,"28");

        JsonPlaceHolderModelGet_GetAll_Post_PutResponse
                response = getResponse.body().as(JsonPlaceHolderModelGet_GetAll_Post_PutResponse.class);

        assertEquals(200,getResponse.statusCode());
        assertEquals("Chelsea has won the champions league",response.getBody());
        assertEquals("Chelsea has won the 2024/2025 champions league",response.getTitle());
        assertEquals(28,response.getUserId());
        assertEquals(28,response.getId());
    }

    @Test
    public void deleteRequest(){

        Response getResponse = new JsonPlaceClient()
                .deleteRequest("28");

        assertEquals(200,getResponse.statusCode());
    }

}
