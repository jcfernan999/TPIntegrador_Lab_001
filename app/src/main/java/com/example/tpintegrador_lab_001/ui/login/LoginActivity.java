package com.example.tpintegrador_lab_001.ui.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tpintegrador_lab_001.R;

import com.example.tpintegrador_lab_001.ui.registro.RegistroActivity;



public class LoginActivity extends AppCompatActivity {
    private EditText etEmailLogin;
    private  EditText etPassLogin;
    public Button btnRegistro;
    public Button btnLogin;

    private ViewModelLogin viewModelLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       configView();
    }

    private void configView(){
        viewModelLogin = ViewModelProviders.of(this).get(ViewModelLogin.class);


        etEmailLogin = findViewById(R.id.etEmailLogin);
        etPassLogin = findViewById(R.id.etEmailLogin);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmailLogin.getText().toString();
                String pass = etPassLogin.getText().toString();


                if(viewModelLogin.iniciarSesion(getBaseContext(), email, pass)){
                    Intent i = new Intent(getApplicationContext(), RegistroActivity.class);
                    i.putExtra("nuevo", "0");

                    startActivity(i);
                }
                else{
                    AlertDialog.Builder alerta = new AlertDialog.Builder(LoginActivity.this);
                    alerta.setMessage("Email, Comtraseña Incorepto")
                            .setNegativeButton("Reintentar", null)
                            .create()
                            .show();
                }


            }

        });

        btnRegistro = findViewById(R.id.btnRegistro);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), RegistroActivity.class);
                i.putExtra("nuevo", "1");
                startActivity(i);

            }
        });
    }
}
