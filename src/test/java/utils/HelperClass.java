package utils;

import data.JsonPlaceModelDataFactoryPost;
import models.request.JsonPlaceHolderModelPostRequest;

import static objectbuilder.JsonPlacePost.createBodyForPostPutRequest;

public class HelperClass {

    public static JsonPlaceHolderModelPostRequest createDefaultPostRequestBody(String body, String title, int userId) {
        return new JsonPlaceModelDataFactoryPost(createBodyForPostPutRequest())
                .setBody(body)
                .setTitle(title)
                .setUserId(userId)
                .createRequest();
    }
}
