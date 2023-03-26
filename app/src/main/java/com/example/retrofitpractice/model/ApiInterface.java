package com.example.retrofitpractice.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    //Get request method and pass the url endpoint
    @GET("posts")
    Call<List<PostModel>> getPosts();
}
