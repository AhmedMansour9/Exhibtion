package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrganizersAndServiceProvidersResponse implements Serializable, Parcelable
{

    @SerializedName("data")
    @Expose
    private List<OrganizersAndServiceProvidersData> data = null;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Parcelable.Creator<OrganizersAndServiceProvidersResponse> CREATOR = new Creator<OrganizersAndServiceProvidersResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public OrganizersAndServiceProvidersResponse createFromParcel(Parcel in) {
            return new OrganizersAndServiceProvidersResponse(in);
        }

        public OrganizersAndServiceProvidersResponse[] newArray(int size) {
            return (new OrganizersAndServiceProvidersResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = -4896291128862007040L;

    protected OrganizersAndServiceProvidersResponse(Parcel in) {
        in.readList(this.data, (OrganizersAndServiceProvidersData.class.getClassLoader()));
        this.status = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public OrganizersAndServiceProvidersResponse() {
    }

    public List<OrganizersAndServiceProvidersData> getData() {
        return data;
    }

    public void setData(List<OrganizersAndServiceProvidersData> data) {
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
