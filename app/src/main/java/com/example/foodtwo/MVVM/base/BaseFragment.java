package com.example.foodtwo.MVVM.base;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.foodtwo.Clesses.Dialog.ErrorHandlerDialog;
import com.example.foodtwo.Clesses.RestFullAPI.responces.BaseResponse;
import com.example.foodtwo.R;
import com.example.foodtwo.databinding.BaseFragmentBinding;
import com.example.foodtwo.databinding.Fragment1Binding;
import com.github.ybq.android.spinkit.SpinKitView;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class BaseFragment extends Fragment {

    @Inject
    ErrorHandlerDialog errorHandlerDialog;

    public void onApiError(BaseResponse response) {
        errorHandlerDialog.setBaseResponse(response, this::onErrorHandlerDialogOkClick);
        errorHandlerDialog.show();
    }

    private void onErrorHandlerDialogOkClick(DialogInterface dialog, int which) {
        errorHandlerDialog.dismiss();
    }


    public void initNearMeStatueBar() {
        //     Statue Bar
        Window window = getActivity().getWindow();
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getContext(), R.color.white));
    }
}
