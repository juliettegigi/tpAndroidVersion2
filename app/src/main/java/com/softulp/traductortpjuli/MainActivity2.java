package com.softulp.traductortpjuli;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.softulp.traductortpjuli.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
     private ActivityMain2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        inicializarVista();
    }

    private void inicializarVista(){
        Intent intent=getIntent();
        EspanolInglesImg objeto= (EspanolInglesImg) intent.getSerializableExtra("objeto");
        binding.tvOutput.setText(objeto.getIngles());
        binding.ivObjeto.setImageResource(objeto.getImg());
    }
}