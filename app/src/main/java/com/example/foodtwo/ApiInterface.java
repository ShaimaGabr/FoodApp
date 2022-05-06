package com.example.foodtwo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("posts")
    public Call<List<Post>> getPost(@Query("userId") int userId);
}
