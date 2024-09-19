package data;

import models.request.JsonPlaceModelRequestPOST;

public class JsonPlaceDataFactoryPOST {

    private final JsonPlaceModelRequestPOST request;

    public JsonPlaceDataFactoryPOST(JsonPlaceModelRequestPOST requestBody){
        request = requestBody;
    }

    public JsonPlaceDataFactoryPOST setTitle(String value){
        if(value.length() > 40)
            throw new IllegalArgumentException("Title is too long (max 20 characters)");
        request.setTitle(value);
        return this;
    }

    public JsonPlaceDataFactoryPOST setBody(String value){
        if(value.length() > 40)
            throw new IllegalArgumentException("Body is too long (max 40 characters)");
        request.setBody(value);
        return this;
    }

    public JsonPlaceModelRequestPOST createRequest(){
        return request;
    }
}
