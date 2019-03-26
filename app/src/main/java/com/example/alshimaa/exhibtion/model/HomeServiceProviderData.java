package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeServiceProviderData/* implements Serializable, Parcelable*/
{

    /*@SerializedName("img")
    @Expose
    private String img;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    public final static Parcelable.Creator<HomeServiceProviderData> CREATOR = new Creator<HomeServiceProviderData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public HomeServiceProviderData createFromParcel(Parcel in) {
            return new HomeServiceProviderData(in);
        }

        public HomeServiceProviderData[] newArray(int size) {
            return (new HomeServiceProviderData[size]);
        }

    }
            ;
    private final static long serialVersionUID = -2075696289282890477L;

    protected HomeServiceProviderData(Parcel in) {
        this.img = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
    }

    public HomeServiceProviderData() {
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(img);
        dest.writeValue(title);
        dest.writeValue(description);
    }

    public int describeContents() {
        return 0;
    }*/

}