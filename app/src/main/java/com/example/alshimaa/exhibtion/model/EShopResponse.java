package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EShopResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<EShopData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<EShopResponse> CREATOR = new Creator<EShopResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public EShopResponse createFromParcel(Parcel in) {
            return new EShopResponse(in);
        }

        public EShopResponse[] newArray(int size) {
            return (new EShopResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = -96469741301252535L;

    protected EShopResponse(Parcel in) {
        in.readList(this.data, (EShopData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public EShopResponse() {
    }

    public List<EShopData> getData() {
        return data;
    }

    public void setData(List<EShopData> data) {
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
