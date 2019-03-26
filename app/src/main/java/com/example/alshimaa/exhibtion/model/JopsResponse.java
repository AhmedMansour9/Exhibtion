package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JopsResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<JopsData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<JopsResponse> CREATOR = new Creator<JopsResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public JopsResponse createFromParcel(Parcel in) {
            return new JopsResponse(in);
        }

        public JopsResponse[] newArray(int size) {
            return (new JopsResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = -492568259454349291L;

    protected JopsResponse(Parcel in) {
        in.readList(this.data, (JopsData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public JopsResponse() {
    }

    public List<JopsData> getData() {
        return data;
    }

    public void setData(List<JopsData> data) {
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
