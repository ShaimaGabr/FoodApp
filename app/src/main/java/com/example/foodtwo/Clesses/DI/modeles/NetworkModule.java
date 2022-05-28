package com.example.foodtwo.Clesses.DI.modeles;

import androidx.lifecycle.MutableLiveData;

import com.example.foodtwo.Clesses.Others.CONSTANTS;
import com.example.foodtwo.Clesses.RestFullAPI.ApiInterface;
import com.example.foodtwo.Clesses.RestFullAPI.Interceptor.HeadersInterceptor;
import com.example.foodtwo.Clesses.RestFullAPI.Interceptor.NetworkInterceptor;
import com.example.foodtwo.Clesses.RestFullAPI.model.Post;
import com.example.foodtwo.Clesses.RestFullAPI.responces.BaseResponse;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.scopes.ViewModelScoped;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;


@Module
@InstallIn(ViewModelComponent.class)
public class NetworkModule {

    @Provides
    @ViewModelScoped
    public ApiInterface provideApiInterface(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(CONSTANTS.API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
                .create(ApiInterface.class);
    }


    @Provides
    @ViewModelScoped
    public OkHttpClient okHttpClient(HttpLoggingInterceptor httpLoggingInterceptor, HeadersInterceptor headersInterceptor, NetworkInterceptor networkInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(networkInterceptor)
                .addInterceptor(headersInterceptor)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }


    @Provides
    @ViewModelScoped
    public HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(message -> Timber.i(message));
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }


    @Provides
    public MutableLiveData<List<Post>> listMutableLiveData() {
        return new MutableLiveData<>();
    }

    @Provides
    public MutableLiveData<BaseResponse> mBaseResponseMutableLiveData() {
        return new MutableLiveData<>();
    }

    @Provides
    public MutableLiveData<Boolean> onLoadingMutableLiveData(){
        return new MutableLiveData<>();
    }

}
