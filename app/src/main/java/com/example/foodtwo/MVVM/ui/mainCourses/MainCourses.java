package com.example.foodtwo.MVVM.ui.mainCourses;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodtwo.Clesses.Adapters.MinAptizPiza;
import com.example.foodtwo.R;
import com.example.foodtwo.databinding.FragmentMainCoursesBinding;
import com.example.foodtwo.databinding.ToastBinding;

import java.util.zip.Inflater;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainCourses extends Fragment {
    FragmentMainCoursesBinding binding;
    MinAptizPiza adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMainCoursesBinding.inflate(inflater, container, false);
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
        adapter = new MinAptizPiza();
        binding.mainRecycler.setAdapter(adapter);
        adapter.setOnClicked(this::callApi);
        //
        binding.goToOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(v).navigate(R.id.action_mainCourses_to_detailsItem);
            }
        });
        ///textToolbar
        binding.textToolbar.setText(getArguments().getString("amount"));
    }

    private void callApi(int i, String s, View view) {
        if (s == "add") {
            binding.itemId.setText("" + i + " item");
            binding.toastLayoutRoot.setVisibility(View.VISIBLE);
        } else if (s=="hid") {
            binding.toastLayoutRoot.setVisibility(View.INVISIBLE);
        }
        }

    }




