package com.rizkysaraan.javaretrofitmvvm.network;

import com.rizkysaraan.javaretrofitmvvm.model.PosWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestApiService {
    @GET("PosKoordinat/{id}")
    Call<PosWrapper> getPos(@Path("id") String id);
}
