package com.example.tpintegrador_lab_001.ui.registro;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.example.tpintegrador_lab_001.model.Usuario;
import com.example.tpintegrador_lab_001.request.ApiClient;

public class ViewModelRegistro extends ViewModel {
    private ApiClient ac;

    public void addUser(Context context, Usuario usuario){
        ApiClient ac = new ApiClient();
        ac.guardar(context,usuario);
    }

    public Usuario getUser(Context context){
        ApiClient ac = new ApiClient();

        return (ac.leer(context));

    }

}