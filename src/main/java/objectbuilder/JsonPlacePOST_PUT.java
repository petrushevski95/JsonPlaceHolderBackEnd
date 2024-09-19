package objectbuilder;

import models.request.JsonPlaceModelRequestPOST_PUT;

public class JsonPlacePOST_PUT {

    public static JsonPlaceModelRequestPOST_PUT createBodyForPostRequest() {
        return JsonPlaceModelRequestPOST_PUT.builder()
                .title("Default value")
                .body("Default value")
                .build();
    }

    public static JsonPlaceModelRequestPOST_PUT createBodyForPutRequest() {
        return JsonPlaceModelRequestPOST_PUT.builder()
                .title("Default value")
                .body("Default value")
                .build();
    }
}
