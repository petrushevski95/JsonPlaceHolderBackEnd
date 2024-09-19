package objectbuilder;

import models.request.JsonPlaceModelRequestPUT;

public class JsonPlacePUT {

    public static JsonPlaceModelRequestPUT createBodyForPutRequest() {
        return JsonPlaceModelRequestPUT.builder()
                .title("Default value")
                .body("Default value")
                .build();
    }
}
