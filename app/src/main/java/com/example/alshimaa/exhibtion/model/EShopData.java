package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EShopData implements  Parcelable
{

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("sale_price")
    @Expose
    private String salePrice;
    @SerializedName("img")
    @Expose
    private String img;
    public final static Parcelable.Creator<EShopData> CREATOR = new Creator<EShopData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public EShopData createFromParcel(Parcel in) {
            return new EShopData(in);
        }

        public EShopData[] newArray(int size) {
            return (new EShopData[size]);
        }

    }
            ;
    private final static long serialVersionUID = -1352837025037731139L;

    protected EShopData(Parcel in) {
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.price = ((String) in.readValue((String.class.getClassLoader())));
        this.salePrice = ((String) in.readValue((String.class.getClassLoader())));
        this.img = ((String) in.readValue((String.class.getClassLoader())));
    }

    public EShopData() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(title);
        dest.writeValue(price);
        dest.writeValue(salePrice);
        dest.writeValue(img);
    }

    public int describeContents() {
        return 0;
    }

}
