package client;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.request.JsonPlaceModelRequestPOST;
import models.request.JsonPlaceModelRequestPUT;

import static utils.Configuration.*;

public class JsonPlaceClient {

    public Response updatePut(JsonPlaceModelRequestPUT request, String id){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(request)
                .put(BASE_URL + "/" + id)
                .thenReturn();
    }

    public Response createPost(JsonPlaceModelRequestPOST request){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(request)
                .post(BASE_URL)
                .thenReturn();
    }

    public Response getAllPost(){
        return RestAssured
                .given()
                .when().log().all()
                .get(BASE_URL)
                .thenReturn();
    }

    public Response getPost(String id){
        return RestAssured
                .given()
                .when().log().all()
                .get(BASE_URL + "/" + id)
                .thenReturn();
    }

    public Response deletePost(String id){
        return RestAssured
                .given()
                .when().log().all()
                .get(BASE_URL + "/" + id)
                .thenReturn();
    }

}


