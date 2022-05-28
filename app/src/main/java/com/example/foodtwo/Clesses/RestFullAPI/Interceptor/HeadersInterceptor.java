package com.example.foodtwo.Clesses.RestFullAPI.Interceptor;


import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import dagger.hilt.android.scopes.ViewModelScoped;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import timber.log.Timber;

@ViewModelScoped
public class HeadersInterceptor implements Interceptor {


    @Inject
    public HeadersInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder();

        requestBuilder.addHeader("lang", "en");
        requestBuilder.addHeader("Accept", "application/json");

        requestBuilder.addHeader("Authorization", "osama android");

        return chain.proceed(requestBuilder.build());
    }


}
