package com.example.foodtwo.MVVM.ui.detailesItem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.navigation.Navigation;

import com.example.foodtwo.MVVM.base.BaseFragment;
import com.example.foodtwo.MVVM.ui.mainActivity.MainActivity;
import com.example.foodtwo.R;
import com.example.foodtwo.databinding.FragmentDetailsItemBinding;

import dagger.hilt.android.AndroidEntryPoint;
import maes.tech.intentanim.CustomIntent;

@AndroidEntryPoint
public class DetailsItem extends BaseFragment {
    FragmentDetailsItemBinding binding;
    int countt = 1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailsItemBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //
        Window window = getActivity().getWindow();
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getContext(), R.color.white));
        //
        binding.addToCard22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(view).navigate(R.id.action_detailsItem_to_detail_Delivery);
                CustomIntent.customType(requireContext(), "left-to-right");


            }
        });
        //back
        binding.closeId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.navController.popBackStack();


            }
        });
        ///


        binding.imageViewPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countt++;
                binding.textViewCount.setText("" + countt);
            }
        });
        binding.imageViewMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (countt <= 1) {

                } else {
                    countt--;
                    binding.textViewCount.setText("" + countt);
                }


            }
        });
    }
}