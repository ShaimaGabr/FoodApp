package com.example.foodtwo.Clesses.Repository;

import com.example.foodtwo.Clesses.RestFullAPI.ApiInterface;
import com.example.foodtwo.Clesses.RestFullAPI.model.Post;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.scopes.ViewModelScoped;
import io.reactivex.Observable;
import retrofit2.http.Query;

@ViewModelScoped
public class Repository {

    private final ApiInterface apiInterface;

    @Inject
    public Repository(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }


    public Observable<List<Post>> getPost(int userId) {
        return apiInterface.getPost(userId);
    }


}
