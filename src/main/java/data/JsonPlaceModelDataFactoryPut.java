package data;

import models.request.JsonPlaceHolderModelPutRequest;

public class JsonPlaceModelDataFactoryPut {

    JsonPlaceHolderModelPutRequest request;

    public JsonPlaceModelDataFactoryPut(JsonPlaceHolderModelPutRequest request){
        this.request = request;
    }

    public JsonPlaceModelDataFactoryPut setTitle(String value){
        request.setTitle(value);
        return this;
    }

    public JsonPlaceModelDataFactoryPut setBody(String value){
        request.setBody(value);
        return this;
    }

    public JsonPlaceModelDataFactoryPut setUserId(int value){
        request.setUserId(value);
        return this;
    }

    public JsonPlaceHolderModelPutRequest createRequest(){
        return request;
    }
}
