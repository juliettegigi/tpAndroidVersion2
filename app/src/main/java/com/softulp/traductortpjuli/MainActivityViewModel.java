package com.softulp.traductortpjuli;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.AndroidViewModel;
import java.util.ArrayList;

public class MainActivityViewModel extends AndroidViewModel{
    private ArrayList<EspanolInglesImg> lista;
    private MutableLiveData<String> mutableMsg;

    public MainActivityViewModel(@NonNull Application application){
        super(application);
        inicializarLista();
    }
    public LiveData<String> getMutableMsg(){
        if(mutableMsg==null)
                mutableMsg=new MutableLiveData<>();
        return mutableMsg;
    }

    public void traducir(String palabra){

        for (EspanolInglesImg item : lista) {
            if (item.getEspanol().equalsIgnoreCase(palabra)) {

                Context context=getApplication();
                Intent intent=new Intent(context,MainActivity2.class);
                intent.putExtra("objeto",item);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        }
        mutableMsg.setValue("No existe la palabra ingresada en nuestro registro.\n(auto,arbol,computadora,pelota,tigre)");
    }
    private void inicializarLista(){
        lista=new ArrayList<>();
        lista.add(new EspanolInglesImg("Arbol","Tree",R.drawable.arbol));
        lista.add(new EspanolInglesImg("Auto","Car",R.drawable.auto));
        lista.add(new EspanolInglesImg("Computadora","Computer",R.drawable.computadora));
        lista.add(new EspanolInglesImg("Pelota","Ball",R.drawable.pelota));
        lista.add(new EspanolInglesImg("Tigre","Tiger",R.drawable.tigre));
    }

}
