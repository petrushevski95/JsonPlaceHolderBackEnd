package data;

import models.request.JsonPlaceHolderModelPostRequest;

public class JsonPlaceModelDataFactoryPost {

    private static JsonPlaceHolderModelPostRequest request;

    public JsonPlaceModelDataFactoryPost(JsonPlaceHolderModelPostRequest requestBody){
        request = requestBody;
    }

    public JsonPlaceModelDataFactoryPost setTitle(String value){
        request.setTitle(value);
        return this;
    }

    public JsonPlaceModelDataFactoryPost setBody(String value){
        request.setBody(value);
        return this;
    }

    public JsonPlaceModelDataFactoryPost setUserId(int value){
        request.setUserId(value);
        return this;
    }

    public JsonPlaceHolderModelPostRequest createRequest(){
        return request;
    }
}

