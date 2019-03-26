package com.example.alshimaa.exhibtion.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.example.alshimaa.exhibtion.presenter.ExhibtorsPresenter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExhibtorsData implements  Parcelable
{

    @SerializedName("id_exhibitor")
    @Expose
    private int idExhibitor;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("website_link")
    @Expose
    private String websiteLink;
    @SerializedName("youtube_link")
    @Expose
    private String youtubeLink;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("img2")
    @Expose
    private String img2;
    @SerializedName("phone")
    @Expose
    private String phone;
    public final static Parcelable.Creator<ExhibtorsData> CREATOR = new Creator<ExhibtorsData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ExhibtorsData createFromParcel(Parcel in) {
            return new ExhibtorsData(in);
        }

        public ExhibtorsData[] newArray(int size) {
            return (new ExhibtorsData[size]);
        }

    }
            ;
    private final static long serialVersionUID = -674064692630264908L;

    protected ExhibtorsData(Parcel in) {
        this.idExhibitor = ((int) in.readValue((int.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.websiteLink = ((String) in.readValue((String.class.getClassLoader())));
        this.youtubeLink = ((String) in.readValue((String.class.getClassLoader())));
        this.address = ((String) in.readValue((String.class.getClassLoader())));
        this.img2 = ((String) in.readValue((String.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ExhibtorsData() {
    }

    public int getIdExhibitor() {
        return idExhibitor;
    }

    public void setIdExhibitor(int idExhibitor) {
        this.idExhibitor = idExhibitor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(idExhibitor);
        dest.writeValue(name);
        dest.writeValue(email);
        dest.writeValue(websiteLink);
        dest.writeValue(youtubeLink);
        dest.writeValue(address);
        dest.writeValue(img2);
        dest.writeValue(phone);
    }

    public int describeContents() {
        return 0;
    }

}