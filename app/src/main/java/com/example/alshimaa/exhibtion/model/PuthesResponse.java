package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PuthesResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<PuthesData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<PuthesResponse> CREATOR = new Creator<PuthesResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public PuthesResponse createFromParcel(Parcel in) {
            return new PuthesResponse(in);
        }

        public PuthesResponse[] newArray(int size) {
            return (new PuthesResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = -8300415946194017091L;

    protected PuthesResponse(Parcel in) {
        in.readList(this.data, (PuthesData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public PuthesResponse() {
    }

    public List<PuthesData> getData() {
        return data;
    }

    public void setData(List<PuthesData> data) {
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
