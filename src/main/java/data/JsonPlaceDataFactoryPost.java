package data;

import models.request.JsonPlaceModelRequestPostPut;

public class JsonPlaceDataFactoryPost {

    private final JsonPlaceModelRequestPostPut request;

    public JsonPlaceDataFactoryPost(JsonPlaceModelRequestPostPut requestBody) {
        request = requestBody;
    }

    public JsonPlaceDataFactoryPost setTitle(String value) {
        if(value.length() > 20)
            throw new IllegalArgumentException("Title is too long (max 20 characters)");
        request.setTitle(value);
        return this;
    }

    public JsonPlaceDataFactoryPost setBody(String value) {
        if(value.length() > 40)
            throw new IllegalArgumentException("Body is too long (max 20 characters)");
        request.setBody(value);
        return this;
    }

    public JsonPlaceModelRequestPostPut createRequest() {
        return request;
    }
}
