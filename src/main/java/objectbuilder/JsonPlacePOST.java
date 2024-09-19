package objectbuilder;

import models.request.JsonPlaceModelRequestPOST;
import models.request.JsonPlaceModelRequestPUT;

public class JsonPlacePOST {

    public static JsonPlaceModelRequestPOST createBodyForPostRequest(){
        return JsonPlaceModelRequestPOST.builder()
                .title("Default value")
                .body("Default value")
                .build();
    }
}
