package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeSiteOptionResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<HomeSiteOptionData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<HomeSiteOptionResponse> CREATOR = new Creator<HomeSiteOptionResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public HomeSiteOptionResponse createFromParcel(Parcel in) {
            return new HomeSiteOptionResponse(in);
        }

        public HomeSiteOptionResponse[] newArray(int size) {
            return (new HomeSiteOptionResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = 1482323199483451150L;

    protected HomeSiteOptionResponse(Parcel in) {
        in.readList(this.data, (HomeSiteOptionData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public HomeSiteOptionResponse() {
    }

    public List<HomeSiteOptionData> getData() {
        return data;
    }

    public void setData(List<HomeSiteOptionData> data) {
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
