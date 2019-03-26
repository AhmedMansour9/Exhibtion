package com.example.alshimaa.exhibtion.model;
import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NavItemServiceProviderResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<NavItemServiceProviderData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<NavItemServiceProviderResponse> CREATOR = new Creator<NavItemServiceProviderResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public NavItemServiceProviderResponse createFromParcel(Parcel in) {
            return new NavItemServiceProviderResponse(in);
        }

        public NavItemServiceProviderResponse[] newArray(int size) {
            return (new NavItemServiceProviderResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = 656352596685812394L;

    protected NavItemServiceProviderResponse(Parcel in) {
        in.readList(this.data, (NavItemServiceProviderData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public NavItemServiceProviderResponse() {
    }

    public List<NavItemServiceProviderData> getData() {
        return data;
    }

    public void setData(List<NavItemServiceProviderData> data) {
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
