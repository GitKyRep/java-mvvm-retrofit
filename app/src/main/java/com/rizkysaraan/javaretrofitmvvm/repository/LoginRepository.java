package com.rizkysaraan.javaretrofitmvvm.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.rizkysaraan.javaretrofitmvvm.model.StafLoginResponse;
import com.rizkysaraan.javaretrofitmvvm.network.RestApiService;
import com.rizkysaraan.javaretrofitmvvm.network.RetrofitInstance;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {
    private final MutableLiveData<StafLoginResponse> stafLoginResponseMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<StafLoginResponse> postLogin(String stafNipBaru, String stafPassword, String regId) {
        RestApiService apiService = RetrofitInstance.getApiService();
        Call<StafLoginResponse> call = apiService.postLogin(stafNipBaru, stafPassword, regId);
        call.enqueue(new Callback<StafLoginResponse>() {
            @Override
            public void onResponse(@NotNull Call<StafLoginResponse> call, @NotNull Response<StafLoginResponse> response) {
                StafLoginResponse stafLoginResponse = response.body();
                if (stafLoginResponse != null) {
                    stafLoginResponseMutableLiveData.setValue(stafLoginResponse);
                }
            }

            @Override
            public void onFailure(@NotNull Call<StafLoginResponse> call, @NotNull Throwable t) {
                Log.d("ListSize", " - > Error    " + t.getMessage());
            }
        });
        return stafLoginResponseMutableLiveData;
    }
}
