package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SponsorResponse /*implements Serializable, Parcelable*/
{

   /* @SerializedName("data")
    @Expose
    private List<SponsorData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<SponsorResponse> CREATOR = new Creator<SponsorResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public SponsorResponse createFromParcel(Parcel in) {
            return new SponsorResponse(in);
        }

        public SponsorResponse[] newArray(int size) {
            return (new SponsorResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = -7979388558270872874L;

    protected SponsorResponse(Parcel in) {
        in.readList(this.data, (SponsorData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public SponsorResponse() {
    }

    public List<SponsorData> getData() {
        return data;
    }

    public void setData(List<SponsorData> data) {
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
