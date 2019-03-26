package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AboutUsData implements  Parcelable
{

    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    public final static Parcelable.Creator<AboutUsData> CREATOR = new Creator<AboutUsData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public AboutUsData createFromParcel(Parcel in) {
            return new AboutUsData(in);
        }

        public AboutUsData[] newArray(int size) {
            return (new AboutUsData[size]);
        }

    }
            ;
    private final static long serialVersionUID = -2075696289282890477L;

    protected AboutUsData(Parcel in) {
        this.img = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
    }

    public AboutUsData() {
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
    }

}