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

    public void setStore_koordinat_id(String store_koordinat_id) {
        this.store_koordinat_id = store_koordinat_id;
    }

    public String getStore_koordinat_name() {
        return store_koordinat_name;
    }

    public void setStore_koordinat_name(String store_koordinat_name) {
        this.store_koordinat_name = store_koordinat_name;
    }

    public String getStore_koordinat_latitude() {
        return store_koordinat_latitude;
    }

    public void setStore_koordinat_latitude(String store_koordinat_latitude) {
        this.store_koordinat_latitude = store_koordinat_latitude;
    }

    public String getStore_koordinat_longitude() {
        return store_koordinat_longitude;
    }

    public void setStore_koordinat_longitude(String store_koordinat_longitude) {
        this.store_koordinat_longitude = store_koordinat_longitude;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getDate_create() {
        return date_create;
    }

    public void setDate_create(String date_create) {
        this.date_create = date_create;
    }

    public String getDate_update() {
        return date_update;
    }

    public void setDate_update(String date_update) {
        this.date_update = date_update;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }
}
