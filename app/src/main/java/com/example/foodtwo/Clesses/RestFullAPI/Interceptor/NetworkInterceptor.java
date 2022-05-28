package com.example.foodtwo.Clesses.RestFullAPI.Interceptor;

import android.content.Context;

import com.example.foodtwo.Clesses.RestFullAPI.responces.BaseResponse;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import javax.inject.Inject;

import dagger.hilt.android.scopes.ViewModelScoped;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import timber.log.Timber;

@ViewModelScoped
public class NetworkInterceptor implements Interceptor {


    @Inject
    public NetworkInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) {
        Gson gson = new Gson();

        Request request = chain.request();

        try {
            Response response = chain.proceed(request);
            ResponseBody body = response.body();
            String bodyString = body.string();
            MediaType contentType = body.contentType();
            if (response.code() != 200) {
                BaseResponse baseResponse = gson.fromJson(bodyString, BaseResponse.class);
                baseResponse.setStatusCode(response.code());
                return response.newBuilder().body(ResponseBody.create(gson.toJson(baseResponse), contentType)).code(200).build();
            } else {
                return response.newBuilder().body(ResponseBody.create(bodyString, contentType)).build();
            }
        } catch (IOException e) {
            Timber.e(" From NetworkInterceptor %s",e.toString());
            return new Response.Builder()
                    .body(ResponseBody.create(gson.toJson(BaseResponse.builder().message(e.toString()).success(false).build()), null)) // Whatever body
                    .protocol(Protocol.HTTP_2)
                    .message("")
                    .request(request)
                    .build();
        }


    }



}