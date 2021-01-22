package com.rizkysaraan.javaretrofitmvvm.network;

import com.rizkysaraan.javaretrofitmvvm.model.PosWrapper;
import com.rizkysaraan.javaretrofitmvvm.model.StafLoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RestApiService {
    @GET("PosKoordinat/{id}")
    Call<PosWrapper> getPos(@Path("id") String id);

    @FormUrlEncoded
    @POST("Login")
    Call<StafLoginResponse> postLogin(
            @Field("staf_nip_baru") String stafNipBaru,
            @Field("staf_password") String stafPassword,
            @Field("reg_id") String regId
    );
}
