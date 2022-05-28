package com.example.foodtwo.Clesses.RestFullAPI;

import com.example.foodtwo.Clesses.RestFullAPI.model.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("posts")
    Observable<List<Post>> getPost(@Query("userId") int userId);
}
