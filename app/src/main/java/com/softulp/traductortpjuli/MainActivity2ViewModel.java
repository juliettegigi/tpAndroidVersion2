package com.softulp.traductortpjuli;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.io.Serializable;

public class MainActivity2ViewModel extends AndroidViewModel {
    private MutableLiveData<EspanolInglesImg> mutableObjeto;
    public MainActivity2ViewModel(@NonNull Application application) {
        super(application);
    }
    public LiveData<EspanolInglesImg> getMutableObjeto(){
        if(mutableObjeto==null)
            mutableObjeto=new MutableLiveData<>();
        return mutableObjeto;
    }

    public void recibirData(Intent intent){
        EspanolInglesImg obj= (EspanolInglesImg) intent.getSerializableExtra("objeto");
        mutableObjeto.setValue(obj);
    }
}
