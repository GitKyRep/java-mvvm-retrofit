package com.rizkysaraan.javaretrofitmvvm.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.rizkysaraan.javaretrofitmvvm.model.Pos;
import com.rizkysaraan.javaretrofitmvvm.model.PosWrapper;
import com.rizkysaraan.javaretrofitmvvm.network.RestApiService;
import com.rizkysaraan.javaretrofitmvvm.network.RetrofitInstance;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {
    private ArrayList<Pos> users = new ArrayList<>();
    private final MutableLiveData<List<Pos>> mutableLiveData = new MutableLiveData<>();
    private final Application application;

    public MainRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Pos>> getMutableLiveData(String storeId) {
        RestApiService apiService = RetrofitInstance.getApiService();
        Call<PosWrapper> call = apiService.getPos(storeId);
        call.enqueue(new Callback<PosWrapper>() {
            @Override
            public void onResponse(@NotNull Call<PosWrapper> call, @NotNull Response<PosWrapper> response) {

                PosWrapper userWrapper = response.body();
                if (userWrapper != null && userWrapper.getPos() != null) {
                    users = (ArrayList<Pos>) userWrapper.getPos();
                    mutableLiveData.setValue(users);
                }
            }

            @Override
            public void onFailure(@NotNull Call<PosWrapper> call, @NotNull Throwable t) {
                Log.d("ListSize", " - > Error    " + t.getMessage());
            }
        });
        return mutableLiveData;
    }
}
