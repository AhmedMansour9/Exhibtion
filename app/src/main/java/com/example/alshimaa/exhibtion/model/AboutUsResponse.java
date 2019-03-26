package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AboutUsResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<AboutUsData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<AboutUsResponse> CREATOR = new Creator<AboutUsResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public AboutUsResponse createFromParcel(Parcel in) {
            return new AboutUsResponse(in);
        }

        public AboutUsResponse[] newArray(int size) {
            return (new AboutUsResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = -4643224998313155867L;

    protected AboutUsResponse(Parcel in) {
        in.readList(this.data, (AboutUsData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public AboutUsResponse() {
    }

    public List<AboutUsData> getData() {
        return data;
    }

    public void setData(List<AboutUsData> data) {
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
        dest.writeList(data);
        dest.writeValue(status);
        dest.writeValue(error);
    }

    public int describeContents() {
        return 0;
    }

}