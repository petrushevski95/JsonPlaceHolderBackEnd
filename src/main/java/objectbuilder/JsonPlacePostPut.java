package objectbuilder;

import models.request.JsonPlaceModelRequestPostPut;

public class JsonPlacePostPut {

    public static JsonPlaceModelRequestPostPut createBodyForPostAndPutRequest() {
        return JsonPlaceModelRequestPostPut.builder()
                .title("Default value")
                .body("Default value")
                .build();
    }

}
