package com.softulp.traductortpjuli;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import android.util.Log;

import com.softulp.traductortpjuli.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainActivityViewModel vm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm = new MainActivityViewModel(getApplication());
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm.getMutableMsg().observe(this,new Observer<String>(){
            @Override
            public void onChanged(String s) {
                binding.tvError.setText(s);
            }
        });
        inicializarVista();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        binding.tvError.setText("");
    }

    private void inicializarVista(){
        binding.btnTraducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vm.traducir(binding.etInput.getText().toString());
            }
        });

    }
}