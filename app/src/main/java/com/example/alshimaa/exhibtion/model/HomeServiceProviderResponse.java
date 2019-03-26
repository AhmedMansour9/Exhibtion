package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeServiceProviderResponse /*implements Serializable, Parcelable*/
{
/*
    @SerializedName("data")
    @Expose
    private List<HomeServiceProviderData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<HomeServiceProviderResponse> CREATOR = new Creator<HomeServiceProviderResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public HomeServiceProviderResponse createFromParcel(Parcel in) {
            return new HomeServiceProviderResponse(in);
        }

        public HomeServiceProviderResponse[] newArray(int size) {
            return (new HomeServiceProviderResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = -7519692931662618030L;

    protected HomeServiceProviderResponse(Parcel in) {
        in.readList(this.data, (HomeServiceProviderData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public HomeServiceProviderResponse() {
    }

    public List<HomeServiceProviderData> getData() {
        return data;
    }

    public void setData(List<HomeServiceProviderData> data) {
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
    }*/

}