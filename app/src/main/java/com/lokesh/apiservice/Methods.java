package com.lokesh.apiservice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Methods {
    @GET("GetVehicleClass?plaza_id=1")
    Call<List<Model>> getVehicleClass();

    // create pojo class for api response https://codebeautify.org/json-to-java-converter


    @POST("UserRegister")
    Call<UserRegister> postUserRegister(@Body UserRegister request);


}
