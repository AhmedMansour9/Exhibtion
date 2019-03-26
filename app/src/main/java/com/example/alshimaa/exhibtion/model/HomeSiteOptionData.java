package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeSiteOptionData implements  Parcelable
{

    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("tilte")
    @Expose
    private String tilte;
    public final static Parcelable.Creator<HomeSiteOptionData> CREATOR = new Creator<HomeSiteOptionData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public HomeSiteOptionData createFromParcel(Parcel in) {
            return new HomeSiteOptionData(in);
        }

        public HomeSiteOptionData[] newArray(int size) {
            return (new HomeSiteOptionData[size]);
        }

    }
            ;
    private final static long serialVersionUID = 7599658469676737755L;

    protected HomeSiteOptionData(Parcel in) {
        this.logo = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.tilte = ((String) in.readValue((String.class.getClassLoader())));
    }

    public HomeSiteOptionData() {
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTilte() {
        return tilte;
    }

    public void setTilte(String tilte) {
        this.tilte = tilte;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(logo);
        dest.writeValue(email);
        dest.writeValue(tilte);
    }

    public int describeContents() {
        return 0;
    }

}
