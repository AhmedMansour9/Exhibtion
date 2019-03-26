package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JopsData implements  Parcelable
{

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("img")
    @Expose
    private String img;
    public final static Parcelable.Creator<JopsData> CREATOR = new Creator<JopsData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public JopsData createFromParcel(Parcel in) {
            return new JopsData(in);
        }

        public JopsData[] newArray(int size) {
            return (new JopsData[size]);
        }

    }
            ;
    private final static long serialVersionUID = 4556415961609899104L;

    protected JopsData(Parcel in) {
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.img = ((String) in.readValue((String.class.getClassLoader())));
    }

    public JopsData() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(title);
        dest.writeValue(email);
        dest.writeValue(date);
        dest.writeValue(description);
        dest.writeValue(img);
    }

    public int describeContents() {
        return 0;
    }

}
