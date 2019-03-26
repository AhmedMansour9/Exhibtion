package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchNavItemServiceProvResponse /*implements Serializable, Parcelable*/
{

   /* @SerializedName("data")
    @Expose
    private List<SearchNavItemServiceProvData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<SearchNavItemServiceProvResponse> CREATOR = new Creator<SearchNavItemServiceProvResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public SearchNavItemServiceProvResponse createFromParcel(Parcel in) {
            return new SearchNavItemServiceProvResponse(in);
        }

        public SearchNavItemServiceProvResponse[] newArray(int size) {
            return (new SearchNavItemServiceProvResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = -5319532427153695520L;

    protected SearchNavItemServiceProvResponse(Parcel in) {
        in.readList(this.data, (SearchNavItemServiceProvData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public SearchNavItemServiceProvResponse() {
    }

    public List<SearchNavItemServiceProvData> getData() {
        return data;
    }

    public void setData(List<SearchNavItemServiceProvData> data) {
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
*/
}
