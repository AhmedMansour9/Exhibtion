package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PuthesRegisterResponse implements Serializable, Parcelable
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
    public final static Parcelable.Creator<PuthesRegisterResponse> CREATOR = new Creator<PuthesRegisterResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public PuthesRegisterResponse createFromParcel(Parcel in) {
            return new PuthesRegisterResponse(in);
        }

        public PuthesRegisterResponse[] newArray(int size) {
            return (new PuthesRegisterResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = -2024246482185689867L;

    protected PuthesRegisterResponse(Parcel in) {
        this.data = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public PuthesRegisterResponse() {
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