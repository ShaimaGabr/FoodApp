package com.example.foodtwo.MVVM.ui.productDetails;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import com.example.foodtwo.Clesses.Adapters.PopularAdapter;
import com.example.foodtwo.MVVM.base.BaseFragment;
import com.example.foodtwo.R;
import com.example.foodtwo.databinding.FragmentShowItemBinding;
import com.example.foodtwo.MVVM.ui.mainActivity.MainActivity;
import com.google.android.material.tabs.TabLayout;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ShowItem extends BaseFragment {
    FragmentShowItemBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentShowItemBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //stat bar
        Window window = getActivity().getWindow();
        window.setStatusBarColor(Color.parseColor("#E94B64"));
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        // tabLayout
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Popular"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Main Courses"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Appetizer"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Pizza & Pasta"));
        Bundle bundle = new Bundle();
        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(getActivity(), "" + tab.getPosition(), Toast.LENGTH_LONG).show();
                if (tab.getPosition() == 1) {
                    /////main_course

                    bundle.putString("amount", "Main Courses");
                    Navigation.findNavController(view).navigate(R.id.action_showItem_to_mainCourses, bundle);
                } else if (tab.getPosition() == 2) {
                    /////Appetizer
                    bundle.putString("amount", "Appetizer");
                    Navigation.findNavController(view).navigate(R.id.action_showItem_to_mainCourses, bundle);
                } else if (tab.getPosition() == 3) {
                    /////Pizza & pasta
                    bundle.putString("amount", "Pizza & Pasta");
                    Navigation.findNavController(view).navigate(R.id.action_showItem_to_mainCourses, bundle);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //Back_press
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.navController.popBackStack();
            }
        });
        ////recycler
        PopularAdapter popularAdapter = new PopularAdapter();
        binding.showitemRecycler.setAdapter(popularAdapter);

    }

}