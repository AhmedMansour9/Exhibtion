package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServicesProvidedResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<ServicesProvidedData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<ServicesProvidedResponse> CREATOR = new Creator<ServicesProvidedResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ServicesProvidedResponse createFromParcel(Parcel in) {
            return new ServicesProvidedResponse(in);
        }

        public ServicesProvidedResponse[] newArray(int size) {
            return (new ServicesProvidedResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = -6657955788350619460L;

    protected ServicesProvidedResponse(Parcel in) {
        in.readList(this.data, (ServicesProvidedData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ServicesProvidedResponse() {
    }

    public List<ServicesProvidedData> getData() {
        return data;
    }

    public void setData(List<ServicesProvidedData> data) {
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
