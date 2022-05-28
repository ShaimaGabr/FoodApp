package com.example.foodtwo.MVVM.ui.homeFragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.foodtwo.Clesses.Adapters.DiscountAdapter;
import com.example.foodtwo.MVVM.base.BaseFragment;
import com.example.foodtwo.R;
import com.example.foodtwo.databinding.Fragment1Binding;

import dagger.hilt.android.AndroidEntryPoint;
import me.relex.circleindicator.CircleIndicator2;
@AndroidEntryPoint
public class HomeFragment extends BaseFragment {
   RecyclerView recyclerView;

    // TextView seeAll;
    Fragment1Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding=Fragment1Binding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       // seeAll=view.findViewById(R.id.textView7);
        //////statue Bar
        Window window = getActivity().getWindow();
         window.setStatusBarColor(Color.parseColor("#E94B64"));
         ////////nave to neer_me fragment
        binding.seeall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_fragment1_to_neerMe);
            }
        });
        ////////////search
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
//////////////SlidDots With ViewPager
        recyclerView =  getView().findViewById(R.id.viewPager);

        //sliderDotspanel = (LinearLayout) getView().findViewById(R.id.SliderDots);


        DiscountAdapter adapter = new DiscountAdapter();

        recyclerView .setAdapter(adapter);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(recyclerView);

        CircleIndicator2 indicator = view.findViewById(R.id.indicator);
        indicator.attachToRecyclerView(recyclerView, pagerSnapHelper);

// optional
        adapter.registerAdapterDataObserver(indicator.getAdapterDataObserver());
        ///
        Bundle bundle = new Bundle();
        binding.neermeCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Navigation.findNavController(view).navigate(R.id.action_fragment1_to_neerMe);
            }
        });
        binding.popularCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("amount", "Popular");

                Navigation.findNavController(view).navigate(R.id.action_fragment1_to_mainCourses,bundle);

            }
        });


    }

}