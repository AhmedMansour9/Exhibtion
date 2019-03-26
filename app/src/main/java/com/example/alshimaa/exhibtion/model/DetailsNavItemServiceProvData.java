package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailsNavItemServiceProvData implements Serializable, Parcelable
{

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("img")
    @Expose
    private String img;
    public final static Parcelable.Creator<DetailsNavItemServiceProvData> CREATOR = new Creator<DetailsNavItemServiceProvData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DetailsNavItemServiceProvData createFromParcel(Parcel in) {
            return new DetailsNavItemServiceProvData(in);
        }

        public DetailsNavItemServiceProvData[] newArray(int size) {
            return (new DetailsNavItemServiceProvData[size]);
        }

    }
            ;
    private final static long serialVersionUID = -2075696289282890477L;

    protected DetailsNavItemServiceProvData(Parcel in) {
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.img = ((String) in.readValue((String.class.getClassLoader())));
    }

    public DetailsNavItemServiceProvData() {
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(title);
        dest.writeValue(description);
        dest.writeValue(img);
    }

    public int describeContents() {
        return 0;
    }

}
