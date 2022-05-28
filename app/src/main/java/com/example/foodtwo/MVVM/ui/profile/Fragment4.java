package com.example.foodtwo.MVVM.ui.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodtwo.MVVM.base.BaseFragment;
import com.example.foodtwo.R;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class Fragment4 extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_4, container, false);
    }
}