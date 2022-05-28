package com.example.foodtwo.MVVM.ui.mainActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.foodtwo.MVVM.base.BaseActivity;
import com.example.foodtwo.R;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import dagger.hilt.android.AndroidEntryPoint;

import static java.security.AccessController.getContext;

@AndroidEntryPoint
public class MainActivity extends BaseActivity {
    BottomNavigationView bottomNavigationView;
    BottomAppBar appbar;
    ImageView fab;
  public static   NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       navController = Navigation.findNavController(this, R.id.activity_main_nav_host_fragment);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        appbar = findViewById(R.id.bottomAppBar);
        fab = findViewById(R.id.fab);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if (destination.getId() == R.id.fragment1 || destination.getId() == R.id.fragment2 || destination.getId() == R.id.fragment3) {
                    bottomNavigationView.setVisibility(View.VISIBLE);
                    appbar.setVisibility(View.VISIBLE);
                    fab.setVisibility(View.VISIBLE);
                } else {
                    bottomNavigationView.setVisibility(View.GONE);
                    appbar.setVisibility(View.GONE);
                    fab.setVisibility(View.GONE);
                }

            }
        });
        ///


    }


}