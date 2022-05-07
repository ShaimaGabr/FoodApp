package com.example.foodtwo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.foodtwo.Clesses.Adapters.PostAdapter;
import com.example.foodtwo.databinding.FragmentNearMeBinding;
import com.example.foodtwo.MVVM.ui.mainActivity.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NearMe extends Fragment {

    private FragmentNearMeBinding binding;
    private PostAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentNearMeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //     Statue Bar
        Window window = getActivity().getWindow();
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getContext(), R.color.white));
        //Back_press

        binding.backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                      MainActivity.navController.popBackStack();
                      Toast.makeText(getContext(),"oook",Toast.LENGTH_SHORT).show();

            }
        });

        //     Call Api

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<List<Post>> call = apiInterface.getPost(1);
        call.enqueue(new Callback<List<Post>>() {

            private List<Post> posts;

            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                adapter = new PostAdapter();
                posts = (response.body());
                adapter.setDate(posts);
                adapter.setOnFoodClickListener(this::onItemClicked);
                binding.food.setAdapter(adapter);
            }

            private void onItemClicked(int id) {
                Log.d("Osama_Android", "onItemClicked: " + posts.get(id).getTitle());
                Toast.makeText(getActivity(), posts.get(id).getTitle(), Toast.LENGTH_SHORT).show();
                Navigation.findNavController(view).navigate(R.id.action_neerMe_to_showItem);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}