package com.example.foodtwo.MVVM.ui.endOrder;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.foodtwo.MVVM.base.BaseFragment;
import com.example.foodtwo.R;
import com.example.foodtwo.databinding.FragmentEndOrderBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class EndOrder extends BaseFragment {

    FragmentEndOrderBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEndOrderBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                binding.load.setImageResource(R.drawable.ic_process_step_2);
            }
        }, 1000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                binding.load.setImageResource(R.drawable.ic_process_step_3);
            }
        }, 2000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                binding.load.setImageResource(R.drawable.ic_process_step_4);
            }
        }, 3000);


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                binding.load.setImageResource(R.drawable.ic_process_step_5);
                binding.process.setText("Order successful");
                binding.whathappen.setText("Cool down, your food will arrive in 25 minutes");
            }
        }, 4000);


    }
}