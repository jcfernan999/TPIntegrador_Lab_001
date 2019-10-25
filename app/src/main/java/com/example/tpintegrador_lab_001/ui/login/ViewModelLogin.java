package com.example.tpintegrador_lab_001.ui.login;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tpintegrador_lab_001.request.ApiClient;

public class ViewModelLogin extends ViewModel {

    public ViewModelLogin(){
    }


    public static boolean iniciarSesion(Context context, String email, String password){
        ApiClient ac = new ApiClient();

        if(ac.login(context,email,password) != null){
            return true;
        }

        return false;

    }
}
