package com.rizkysaraan.javaretrofitmvvm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class PosWrapper {
    @SerializedName("dataPos")
    private List<Pos> mData;
    @SerializedName("error")
    private Boolean mError;
    @SerializedName("message")
    private String mMessage;

    public List<Pos> getPos() {
        return mData;
    }

    public void setPos(List<Pos> mData) {
        this.mData = mData;
    }

    public Boolean getmError() {
        return mError;
    }

    public void setmError(Boolean mError) {
        this.mError = mError;
    }

    public String getmMessage() {
        return mMessage;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage;
    }
}
