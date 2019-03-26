package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentExhibtionResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<CurrentExhibtionData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<CurrentExhibtionResponse> CREATOR = new Creator<CurrentExhibtionResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public CurrentExhibtionResponse createFromParcel(Parcel in) {
            return new CurrentExhibtionResponse(in);
        }

        public CurrentExhibtionResponse[] newArray(int size) {
            return (new CurrentExhibtionResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = -5427491383137463865L;

    protected CurrentExhibtionResponse(Parcel in) {
        in.readList(this.data, (CurrentExhibtionData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public CurrentExhibtionResponse() {
    }

    public List<CurrentExhibtionData> getData() {
        return data;
    }

    public void setData(List<CurrentExhibtionData> data) {
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