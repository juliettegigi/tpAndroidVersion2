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

import com.softulp.traductortpjuli.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
     private ActivityMain2Binding binding;
     private MainActivity2ViewModel mv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMain2Binding.inflate(getLayoutInflater());
        mv = new MainActivity2ViewModel(getApplication());
        setContentView(binding.getRoot());
        mv.getMutableObjeto().observe(this, new Observer<EspanolInglesImg>() {
            @Override
            public void onChanged(EspanolInglesImg espanolInglesImg) {

                binding.tvOutput.setText(espanolInglesImg.getIngles());
                binding.ivObjeto.setImageResource(espanolInglesImg.getImg());
            }
        });
        mv.recibirData(getIntent());
    }


}