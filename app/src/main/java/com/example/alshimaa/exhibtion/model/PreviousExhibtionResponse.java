package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PreviousExhibtionResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<PreviousExhibtionData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<PreviousExhibtionResponse> CREATOR = new Creator<PreviousExhibtionResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public PreviousExhibtionResponse createFromParcel(Parcel in) {
            return new PreviousExhibtionResponse(in);
        }

        public PreviousExhibtionResponse[] newArray(int size) {
            return (new PreviousExhibtionResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = -4901384469210002957L;

    protected PreviousExhibtionResponse(Parcel in) {
        in.readList(this.data, (PreviousExhibtionData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public PreviousExhibtionResponse() {
    }

    public List<PreviousExhibtionData> getData() {
        return data;
    }

    public void setData(List<PreviousExhibtionData> data) {
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