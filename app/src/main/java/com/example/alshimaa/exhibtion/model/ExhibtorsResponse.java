package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExhibtorsResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<ExhibtorsData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<ExhibtorsResponse> CREATOR = new Creator<ExhibtorsResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ExhibtorsResponse createFromParcel(Parcel in) {
            return new ExhibtorsResponse(in);
        }

        public ExhibtorsResponse[] newArray(int size) {
            return (new ExhibtorsResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = 2558286685595987625L;

    protected ExhibtorsResponse(Parcel in) {
        in.readList(this.data, (ExhibtorsData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ExhibtorsResponse() {
    }

    public List<ExhibtorsData> getData() {
        return data;
    }

    public void setData(List<ExhibtorsData> data) {
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