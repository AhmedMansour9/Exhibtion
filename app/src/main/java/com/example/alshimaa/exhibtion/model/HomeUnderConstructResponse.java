package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeUnderConstructResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<HomeUnderConstructData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<HomeUnderConstructResponse> CREATOR = new Creator<HomeUnderConstructResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public HomeUnderConstructResponse createFromParcel(Parcel in) {
            return new HomeUnderConstructResponse(in);
        }

        public HomeUnderConstructResponse[] newArray(int size) {
            return (new HomeUnderConstructResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = -2906867162718079737L;

    protected HomeUnderConstructResponse(Parcel in) {
        in.readList(this.data, (HomeUnderConstructData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public HomeUnderConstructResponse() {
    }

    public List<HomeUnderConstructData> getData() {
        return data;
    }

    public void setData(List<HomeUnderConstructData> data) {
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
