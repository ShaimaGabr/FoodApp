package com.example.foodtwo.MVVM.ui.nearMe;

import android.annotation.SuppressLint;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodtwo.Clesses.Repository.Repository;
import com.example.foodtwo.Clesses.RestFullAPI.model.Post;
import com.example.foodtwo.MVVM.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import lombok.Getter;

@Getter
@HiltViewModel
public class NearMeViewModel extends BaseViewModel {

    @Inject
    public NearMeViewModel() {
    }

    @Inject
    public MutableLiveData<List<Post>> responsePosts;

    @SuppressLint("CheckResult")
    public MutableLiveData<List<Post>> requestPost(int userId) {
         Observable.just(userId)
                 .doOnNext(__ -> getOnLoadingMutableLiveData().setValue(true))
                 .observeOn(Schedulers.io())
                 .takeWhile(this::isInternetAvailable)
                 .flatMap(id -> getRepository().getPost(id))
                 .observeOn(AndroidSchedulers.mainThread())
                 .doFinally(() -> getOnLoadingMutableLiveData().setValue(false))
                 .subscribe(response -> responsePosts.setValue(response), this::onFailure);
        return responsePosts;
    }
}
