package data;

import models.request.JsonPlaceModelRequestPOST_PUT;

public class JsonPlaceDataFactoryPOST {

    private final JsonPlaceModelRequestPOST_PUT request;

    public JsonPlaceDataFactoryPOST(JsonPlaceModelRequestPOST_PUT requestBody) {
        request = requestBody;
    }

    public JsonPlaceDataFactoryPOST setTitle(String value) {
        if(value.length() > 20)
            throw new IllegalArgumentException("Title is too long (max 20 characters)");
        request.setTitle(value);
        return this;
    }

    public JsonPlaceDataFactoryPOST setBody(String value) {
        if(value.length() > 40)
            throw new IllegalArgumentException("Body is too long (max 20 characters)");
        request.setBody(value);
        return this;
    }

    public JsonPlaceModelRequestPOST_PUT createRequest() {
        return request;
    }
}
