package com.example.vistapresentador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

import com.example.vistapresentador.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements VistaPresentador{
    public ActivityMainBinding binding;
    private Presentador presentando;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presentando = new Presentador(this);
        binding.editPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                presentando.evaluarContrasena(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void mostrarDebil() {
        Toast.makeText(this, "Débil", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mostrarMedia() {
        Toast.makeText(this, "Medio", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mostrarFuerte() {
        Toast.makeText(this, "Fuerte", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mostrarError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }
}