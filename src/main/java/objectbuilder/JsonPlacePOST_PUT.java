package objectbuilder;

import models.request.JsonPlaceModelRequestPOST_PUT;

public class JsonPlacePOST_PUT {

    public static JsonPlaceModelRequestPOST_PUT createBodyForPostAndPutRequest() {
        return JsonPlaceModelRequestPOST_PUT.builder()
                .title("Default value")
                .body("Default value")
                .build();
    }

}
