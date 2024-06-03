package com.example.littlepaws.retrofit;

import com.example.littlepaws.model.*;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserApi {

    @POST("/add-user")
    Call <User> save (@Body User user);
    //Working
//    @POST("/login")
//    Call <ResponseBody> login(@Body User user);
    @POST("/login")
    Call <User> login(@Body User user);

    @POST("/api/add-message")
    Call <Message> save (@Body Message message);

    @POST("/api/add-pet")
    Call <Pet> save (@Body Pet pet);

    @GET("/api/pets")
    Call<List<Pet>> getAllPets();

    @DELETE("/api/delete-pet/{id}")
    Call<Void> deletePet(@Path("id") int petId);

    @POST("/api/add-adopt-message")
    Call <Adopt> save (@Body Adopt adopt);

}