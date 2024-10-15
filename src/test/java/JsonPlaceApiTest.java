import io.restassured.response.Response;
import jsonplaceclient.JsonPlaceClient;
import models.request.JsonPlaceHolderModelPostRequest;
import models.response.JsonPlaceHolderModelGet_GetAll_Post_PutResponse;
import org.junit.Test;
import utils.HelperClass;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class JsonPlaceApiTest {

    private Response response;
    private JsonPlaceHolderModelGet_GetAll_Post_PutResponse getSingleIdResponseBody;
    private JsonPlaceHolderModelPostRequest postPutBodyRequest;
    private JsonPlaceHolderModelGet_GetAll_Post_PutResponse postPutBodyResponse;

    @Test
    public void getSingleRequest(){
        response = new JsonPlaceClient()
                .getRequest("28");

        getSingleIdResponseBody = response.body().as(JsonPlaceHolderModelGet_GetAll_Post_PutResponse.class);

        String body = "non et quaerat ex quae ad maiores\n" +
                "maiores recusandae totam aut blanditiis mollitia quas illo\n" +
                "ut voluptatibus voluptatem\n" +
                "similique nostrum eum";

        assertEquals(200,response.statusCode());
        assertEquals(28,getSingleIdResponseBody.getId());
        assertEquals(3,getSingleIdResponseBody.getUserId());
        assertEquals("delectus ullam et corporis nulla voluptas sequi",getSingleIdResponseBody.getTitle());
        assertEquals(body,getSingleIdResponseBody.getBody());
    }

    @Test
    public void getAllRequest(){
        response = new JsonPlaceClient()
                .getAllRequest();

        List<JsonPlaceHolderModelGet_GetAll_Post_PutResponse> getAllResponseBody = response
                .body()
                .jsonPath()
                .getList("", JsonPlaceHolderModelGet_GetAll_Post_PutResponse.class);

        assertEquals(200,response.statusCode());
        assertFalse(getAllResponseBody.isEmpty());
    }

    @Test
    public void postDefaultValuesRequest(){ // ID SHOULD BE AUTOGENERATED (NOT IN THIS CASE)
        postPutBodyRequest = HelperClass.createDefaultPostRequestBody("Default value","Default value",50);

        response = new JsonPlaceClient().postRequest(postPutBodyRequest);

        postPutBodyResponse = response.body().as(JsonPlaceHolderModelGet_GetAll_Post_PutResponse.class);

        assertEquals(201,response.statusCode());
        assertEquals(postPutBodyRequest.getBody(),postPutBodyResponse.getBody());
        assertEquals(postPutBodyRequest.getTitle(),postPutBodyResponse.getTitle());
        assertEquals(postPutBodyRequest.getUserId(),postPutBodyResponse.getUserId());
    }

    @Test
    public void postCustomValuesRequest(){
        postPutBodyRequest = HelperClass.createDefaultPostRequestBody
                ("Chelsea has won the champions league",
                "Chelsea has won the 2024/2025 champions league",
                121);

        response = new JsonPlaceClient()
                .postRequest(postPutBodyRequest);

        postPutBodyResponse = response.body().as(JsonPlaceHolderModelGet_GetAll_Post_PutResponse.class);

        assertEquals(201,response.statusCode());
        assertEquals(postPutBodyRequest.getBody(),postPutBodyResponse.getBody());
        assertEquals(postPutBodyRequest.getTitle(),postPutBodyResponse.getTitle());
        assertEquals(postPutBodyRequest.getUserId(),postPutBodyResponse.getUserId());
    }

    @Test
    public void putDefaultValuesRequest(){ // id should not be set in the body request (not in this case)....
        postPutBodyRequest = HelperClass.createDefaultPostRequestBody
                ("Default Value", "Default Value", 28);

        response = new JsonPlaceClient()
                .putRequest(postPutBodyRequest,"28");

        postPutBodyResponse = response.body().as(JsonPlaceHolderModelGet_GetAll_Post_PutResponse.class);

        assertEquals(200,response.statusCode());
        assertEquals(postPutBodyRequest.getBody(),postPutBodyResponse.getBody());
        assertEquals(postPutBodyRequest.getTitle(),postPutBodyResponse.getTitle());
        assertEquals(postPutBodyRequest.getUserId(),postPutBodyResponse.getUserId());
        assertEquals(28,postPutBodyResponse.getId());
    }

    @Test
    public void putCustomValuesRequest(){
        postPutBodyRequest = HelperClass.createDefaultPostRequestBody
                ("Chelsea has won the champions league",
                        "Chelsea has won the 2024/2025 champions league",
                        28);

        response = new JsonPlaceClient()
                .putRequest(postPutBodyRequest,"28");

        postPutBodyResponse = response.body().as(JsonPlaceHolderModelGet_GetAll_Post_PutResponse.class);

        assertEquals(200,response.statusCode());
        assertEquals(postPutBodyRequest.getBody(),postPutBodyResponse.getBody());
        assertEquals(postPutBodyRequest.getTitle(),postPutBodyResponse.getTitle());
        assertEquals(postPutBodyRequest.getUserId(),postPutBodyResponse.getUserId());
        assertEquals(28,postPutBodyResponse.getId());
    }

    @Test
    public void deleteRequest(){
        response = new JsonPlaceClient()
                .deleteRequest("28");

        assertEquals(200,response.statusCode());
    }

}
