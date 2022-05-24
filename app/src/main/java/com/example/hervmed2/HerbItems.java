package com.example.hervmed2;

import android.os.Parcel;
import android.os.Parcelable;

public class HerbItems implements Parcelable {
    int imgResource, history;
    String title, description;

    public HerbItems(int imgResource, String text, String text2, int text3){
        this.imgResource = imgResource;
        this.title = text;
        this.description = text2;
        this.history = text3;
    }

    protected HerbItems(Parcel in) {
        imgResource = in.readInt();
        title = in.readString();
        description = in.readString();
        history = in.readInt();

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

    public int getHistory(){
        return history;
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
        parcel.writeInt(history);
    }
}
