package com.example.foodtwo;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import me.relex.circleindicator.CircleIndicator2;

public class Fragment1 extends Fragment {
   RecyclerView recyclerView;

     TextView seeAll;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        seeAll=view.findViewById(R.id.textView7);
        //////statue Bar
        Window window = getActivity().getWindow();
         window.setStatusBarColor(Color.parseColor("#E94B64"));
         ////////nave to neer_me fragment
        seeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_fragment1_to_neerMe);
            }
        });
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


    }

}