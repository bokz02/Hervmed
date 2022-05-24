package com.example.hervmed2;

import android.os.Parcel;
import android.os.Parcelable;

public class HerbItems implements Parcelable {
    int imgResource, content;
    String title, description;

    public HerbItems(int imgResource, String text, String text2, int content){
        this.imgResource = imgResource;
        this.title = text;
        this.description = text2;
        this.content = content;

    }

    protected HerbItems(Parcel in) {
        imgResource = in.readInt();
        title = in.readString();
        description = in.readString();
        content = in.readInt();

    }

    public static final Creator<HerbItems> CREATOR = new Creator<HerbItems>() {
        @Override
        public HerbItems createFromParcel(Parcel in) {
            return new HerbItems(in);
        }

        @Override
        public HerbItems[] newArray(int size) {
            return new HerbItems[size];
        }
    };

    public int getImgResource() {
        return imgResource;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getContent(){
        return content;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imgResource);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeInt(content);
    }
}
