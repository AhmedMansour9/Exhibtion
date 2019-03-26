package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SponsorData   /*implements  Parcelable*/
{

   /* @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("tit_ar")
    @Expose
    private String titAr;
    @SerializedName("des_ar")
    @Expose
    private String desAr;
    @SerializedName("img")
    @Expose
    private String img;
    public final static Parcelable.Creator<SponsorData> CREATOR = new Creator<SponsorData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public SponsorData createFromParcel(Parcel in) {
            return new SponsorData(in);
        }

        public SponsorData[] newArray(int size) {
            return (new SponsorData[size]);
        }

    }
            ;
    private final static long serialVersionUID = 5061447161015739552L;

    protected SponsorData(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.titAr = ((String) in.readValue((String.class.getClassLoader())));
        this.desAr = ((String) in.readValue((String.class.getClassLoader())));
        this.img = ((String) in.readValue((String.class.getClassLoader())));
    }

    public SponsorData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitAr() {
        return titAr;
    }

    public void setTitAr(String titAr) {
        this.titAr = titAr;
    }

    public String getDesAr() {
        return desAr;
    }

    public void setDesAr(String desAr) {
        this.desAr = desAr;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(titAr);
        dest.writeValue(desAr);
        dest.writeValue(img);
    }

    public int describeContents() {
        return 0;
    }*/

}
