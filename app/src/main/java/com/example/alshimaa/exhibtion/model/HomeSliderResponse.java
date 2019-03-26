package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeSliderResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<HomeSliderData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<HomeSliderResponse> CREATOR = new Creator<HomeSliderResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public HomeSliderResponse createFromParcel(Parcel in) {
            return new HomeSliderResponse(in);
        }

        public HomeSliderResponse[] newArray(int size) {
            return (new HomeSliderResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = -6793218302473206581L;

    protected HomeSliderResponse(Parcel in) {
        in.readList(this.data, (HomeSliderData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public HomeSliderResponse() {
    }

    public List<HomeSliderData> getData() {
        return data;
    }

    public void setData(List<HomeSliderData> data) {
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