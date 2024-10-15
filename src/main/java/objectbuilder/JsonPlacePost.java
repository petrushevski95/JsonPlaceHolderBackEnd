package objectbuilder;

import models.request.JsonPlaceHolderModelPostRequest;
import models.request.JsonPlaceHolderModelPutRequest;

public class JsonPlacePost {

    public static JsonPlaceHolderModelPostRequest createBodyForPostPutRequest(){
         return JsonPlaceHolderModelPostRequest.builder()
                 .title("Deafult value")
                 .body("Deafult Value")
                 .userId(0)
                 .build();
    }
}
