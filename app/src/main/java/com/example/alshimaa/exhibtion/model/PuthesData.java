package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PuthesData implements  Parcelable
{

    @SerializedName("id_partion")
    @Expose
    private int idPartion;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("width")
    @Expose
    private String width;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("price")
    @Expose
    private String price;
    public final static Parcelable.Creator<PuthesData> CREATOR = new Creator<PuthesData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public PuthesData createFromParcel(Parcel in) {
            return new PuthesData(in);
        }

        public PuthesData[] newArray(int size) {
            return (new PuthesData[size]);
        }

    }
            ;
    private final static long serialVersionUID = -176561469020382255L;

    protected PuthesData(Parcel in) {
        this.idPartion = ((int) in.readValue((int.class.getClassLoader())));
        this.number = ((String) in.readValue((String.class.getClassLoader())));
        this.width = ((String) in.readValue((String.class.getClassLoader())));
        this.height = ((String) in.readValue((String.class.getClassLoader())));
        this.price = ((String) in.readValue((String.class.getClassLoader())));
    }

    public PuthesData() {
    }

    public int getIdPartion() {
        return idPartion;
    }

    public void setIdPartion(int idPartion) {
        this.idPartion = idPartion;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(idPartion);
        dest.writeValue(number);
        dest.writeValue(width);
        dest.writeValue(height);
        dest.writeValue(price);
    }

    public int describeContents() {
        return 0;
    }

}
