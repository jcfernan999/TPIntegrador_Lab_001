package com.example.tpintegrador_lab_001.ui.registro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tpintegrador_lab_001.R;
import com.example.tpintegrador_lab_001.model.Usuario;
import com.example.tpintegrador_lab_001.ui.login.LoginActivity;

public class RegistroActivity extends AppCompatActivity {
    private EditText etDni;
    private EditText etApellido;
    private EditText etNombre;
    private EditText etEmail;
    private EditText etPassword;

    private Button btnGuardar;

    private ViewModelRegistro viewModelRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        viewModelRegistro = ViewModelProviders.of(this).get(ViewModelRegistro.class);

        etDni = findViewById(R.id.etDni);
        etApellido = findViewById(R.id.etApellido);
        etNombre = findViewById(R.id.etNombre);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPass);

        Intent i= getIntent();
        String dato =i.getStringExtra("nuevo");

        if( dato.equals("0")){
            Usuario usuario;
            usuario = viewModelRegistro.getUser(getApplicationContext());

            etDni.setText(usuario.getDni()+"");
            etApellido.setText(usuario.getApellido());
            etNombre.setText(usuario.getNombre());
            etEmail.setText(usuario.getEmail());
            etPassword.setText(usuario.getPassword());
        }
        else{
            etDni.setText("");
            etApellido.setText("");
            etNombre.setText("");
            etEmail.setText("");
            etPassword.setText("");
        }

        btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Usuario usuario = new Usuario();
                usuario.setDni(Long.parseLong(etDni.getText().toString()));
                usuario.setApellido(etApellido.getText().toString());
                usuario.setNombre(etNombre.getText().toString());
                usuario.setEmail(etEmail.getText().toString());
                usuario.setPassword(etPassword.getText().toString());

                viewModelRegistro.addUser(getApplicationContext(),usuario);

                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);

            }
        });
    }
}
