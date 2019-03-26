package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeSliderData implements  Parcelable
{

    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("description")
    @Expose
    private String description;
    public final static Parcelable.Creator<HomeSliderData> CREATOR = new Creator<HomeSliderData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public HomeSliderData createFromParcel(Parcel in) {
            return new HomeSliderData(in);
        }

        public HomeSliderData[] newArray(int size) {
            return (new HomeSliderData[size]);
        }

    }
            ;
    private final static long serialVersionUID = -6602197792067247261L;

    protected HomeSliderData(Parcel in) {
        this.img = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
    }

    public HomeSliderData() {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
        dest.writeValue(date);
        dest.writeValue(description);
    }

    public int describeContents() {
        return 0;
    }

}