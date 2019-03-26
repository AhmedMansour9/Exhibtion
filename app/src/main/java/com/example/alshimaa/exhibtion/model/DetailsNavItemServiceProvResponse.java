package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailsNavItemServiceProvResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<DetailsNavItemServiceProvData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<DetailsNavItemServiceProvResponse> CREATOR = new Creator<DetailsNavItemServiceProvResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DetailsNavItemServiceProvResponse createFromParcel(Parcel in) {
            return new DetailsNavItemServiceProvResponse(in);
        }

        public DetailsNavItemServiceProvResponse[] newArray(int size) {
            return (new DetailsNavItemServiceProvResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = -7540562749248637146L;

    protected DetailsNavItemServiceProvResponse(Parcel in) {
        in.readList(this.data, (DetailsNavItemServiceProvData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public DetailsNavItemServiceProvResponse() {
    }

    public List<DetailsNavItemServiceProvData> getData() {
        return data;
    }

    public void setData(List<DetailsNavItemServiceProvData> data) {
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
