package data;

import models.request.JsonPlaceModelRequestPUT;

public class JsonPlaceDataFactoryPUT {

    private final JsonPlaceModelRequestPUT request;

    public JsonPlaceDataFactoryPUT(JsonPlaceModelRequestPUT requestBody) {
        request = requestBody;
    }

    public JsonPlaceDataFactoryPUT setTitle(String value) {
        if(value.length() > 20)
            throw new IllegalArgumentException("Title is too long (max 20 characters)");
        request.setTitle(value);
        return this;
    }

    public JsonPlaceDataFactoryPUT setBody(String value) {
        if(value.length() > 40)
            throw new IllegalArgumentException("Body is too long (max 40 characters)");
        request.setBody(value);
        return this;
    }

    public JsonPlaceModelRequestPUT createRequest() {
        return request;
    }

}
