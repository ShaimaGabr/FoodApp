package com.example.foodtwo.MVVM.ui.nearMe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;

import com.example.foodtwo.Clesses.Adapters.PostAdapter;
import com.example.foodtwo.Clesses.RestFullAPI.model.Post;
import com.example.foodtwo.MVVM.base.BaseFragment;
import com.example.foodtwo.databinding.FragmentNearMeBinding;
import com.example.foodtwo.MVVM.ui.mainActivity.MainActivity;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;
import dagger.hilt.android.HiltAndroidApp;

@AndroidEntryPoint

public class NearMe extends BaseFragment {

    public static final int USER_ID = 1;
    private FragmentNearMeBinding binding;
    private NearMeViewModel meViewModel;
    private PostAdapter mPostAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        meViewModel = new ViewModelProvider(this).get(NearMeViewModel.class);
        binding = FragmentNearMeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initNearMeStatueBar();

        meViewModel.getOnLoadingMutableLiveData().observe(getViewLifecycleOwner(), this::onLoading);


        meViewModel.requestPost(USER_ID);
        meViewModel.responsePosts.observe(getViewLifecycleOwner(), this::responsePosts);

//        binding.backHome.setOnClickListener(this::OnclickBack);

        mPostAdapter = new PostAdapter();
        binding.food.setAdapter(mPostAdapter);
        mPostAdapter.setOnFoodClickListener(this::OnItemClicked);


    }

    private void onLoading(Boolean status) {
        binding.progressView.setVisibility(status ? View.VISIBLE : View.GONE);
    }

    private void responsePosts(List<Post> posts) {
        mPostAdapter.setDate(posts);
    }

    private void OnItemClicked(int position) {
    }

    private void OnclickBack(View view) {
        MainActivity.navController.popBackStack();
    }


}