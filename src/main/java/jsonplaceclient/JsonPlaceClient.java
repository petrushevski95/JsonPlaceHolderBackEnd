package jsonplaceclient;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.request.JsonPlaceHolderModelPostRequest;
import models.request.JsonPlaceHolderModelPutRequest;

import static utils.Configuration.BASE_URL;

public class JsonPlaceClient {

    public Response getRequest(String id){
        return RestAssured
                .given()
                .when().log().all()
                .get(BASE_URL + "/" + id)
                .thenReturn();
    }

    public Response getAllRequest(){
        return RestAssured
                .given()
                .when().log().all()
                .get(BASE_URL)
                .thenReturn();
    }

    public Response postRequest(JsonPlaceHolderModelPostRequest requestBody){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(requestBody)
                .post(BASE_URL)
                .thenReturn();
    }

    public Response putRequest(JsonPlaceHolderModelPostRequest requestBody, String id){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(requestBody)
                .put(BASE_URL + "/" + id)
                .thenReturn();
    }

    public Response deleteRequest(String id){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .delete(BASE_URL + "/" + id)
                .thenReturn();
    }


}
