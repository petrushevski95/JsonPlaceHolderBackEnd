package data;

import models.request.JsonPlaceModelRequestPOST_PUT;

public class JsonPlaceDataFactoryPUT {

    private final JsonPlaceModelRequestPOST_PUT request;

    public JsonPlaceDataFactoryPUT(JsonPlaceModelRequestPOST_PUT requestBody) {
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

    public JsonPlaceModelRequestPOST_PUT createRequest() {
        return request;
    }

}
