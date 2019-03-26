package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CallUsResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private String data;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<CallUsResponse> CREATOR = new Creator<CallUsResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public CallUsResponse createFromParcel(Parcel in) {
            return new CallUsResponse(in);
        }

        public CallUsResponse[] newArray(int size) {
            return (new CallUsResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = -3201440975564483269L;

    protected CallUsResponse(Parcel in) {
        this.data = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public CallUsResponse() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(data);
        dest.writeValue(status);
        dest.writeValue(error);
    }

    public int describeContents() {
        return 0;
    }

}
