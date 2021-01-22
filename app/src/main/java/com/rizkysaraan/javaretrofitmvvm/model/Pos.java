package com.rizkysaraan.javaretrofitmvvm.model;

import com.google.gson.annotations.SerializedName;

public class Pos {
    @SerializedName("store_koordinat_id")
    private String store_koordinat_id;
    @SerializedName("store_koordinat_name")
    private String store_koordinat_name;
    @SerializedName("store_koordinat_latitude")
    private String store_koordinat_latitude;
    @SerializedName("store_koordinat_longitude")
    private String store_koordinat_longitude;
    @SerializedName("store_id")
    private String store_id;
    @SerializedName("date_create")
    private String date_create;
    @SerializedName("date_update")
    private String date_update;
    @SerializedName("created_by")
    private String created_by;
    @SerializedName("updated_by")
    private String updated_by;

    public String getStore_koordinat_id() {
        return store_koordinat_id;
    }

    public String getStore_koordinat_name() {
        return store_koordinat_name;
    }

    public String getStore_koordinat_latitude() {
        return store_koordinat_latitude;
    }

    public String getStore_koordinat_longitude() {
        return store_koordinat_longitude;
    }

    public String getStore_id() {
        return store_id;
    }

}
