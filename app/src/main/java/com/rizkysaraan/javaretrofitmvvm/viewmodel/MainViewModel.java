package com.rizkysaraan.javaretrofitmvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.rizkysaraan.javaretrofitmvvm.model.Pos;
import com.rizkysaraan.javaretrofitmvvm.repository.MainRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private final MainRepository mainRepository;
    public MainViewModel(@NonNull Application application) {
        super(application);
        mainRepository = new MainRepository(application);
    }
    public LiveData<List<Pos>> getAllPos(String storeId) {
        return mainRepository.getMutableLiveData(storeId);
    }
}
