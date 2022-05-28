package com.example.foodtwo.MVVM.base;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodtwo.Clesses.Repository.Repository;
import com.example.foodtwo.Clesses.RestFullAPI.model.Post;
import com.example.foodtwo.Clesses.RestFullAPI.responces.BaseResponse;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.disposables.CompositeDisposable;
import lombok.Getter;
import timber.log.Timber;

@Getter
@HiltViewModel
public class BaseViewModel extends ViewModel {

    @Inject
    public BaseViewModel() {
    }

    @Inject
    Repository repository;

    @Inject
    MutableLiveData<BaseResponse> onApiErrorMutableLiveData;

    @Inject
    MutableLiveData<Boolean> onLoadingMutableLiveData;


    public boolean isInternetAvailable(Object object) {
        try {
            int timeoutMs = 5000;
            Socket sock = new Socket();
            SocketAddress sockaddr = new InetSocketAddress("8.8.8.8", 53);

            sock.connect(sockaddr, timeoutMs);
            sock.close();

            return true;
        } catch (IOException e) {
            onApiErrorMutableLiveData.postValue(BaseResponse.builder().statusCode(503).success(false).build());
            return false;
        }

    }

    public boolean isSuccess(BaseResponse response) {
        if (!response.isSuccess()) {
            onApiErrorMutableLiveData.setValue(response);
            Timber.e("From new BaseViewModel %s", response.getMessage());
            return false;
        } else
            return true;
    }

    protected void onFailure(Throwable throwable) {
        onApiErrorMutableLiveData.setValue(BaseResponse.builder().message(throwable.toString()).success(false).build());
        Timber.e(throwable);

    }
}

