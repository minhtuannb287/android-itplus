package com.example.retrofitdemo.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class PostModel implements Parcelable {
    private int id;
    private String tieuDe;
    private String moTa;
    private String noiDung;
    private String imageUrl;
    private String[] baiVietLienQuan;

    public PostModel() {
    }

    public PostModel(int id, String tieuDe, String moTa, String noiDung, String imageUrl, String[] baiVietLienQuan) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.moTa = moTa;
        this.noiDung = noiDung;
        this.imageUrl = imageUrl;
        this.baiVietLienQuan = baiVietLienQuan;
    }

    public static final Creator<PostModel> CREATOR = new Creator<PostModel>() {
        @Override
        public PostModel createFromParcel(Parcel in) {
            return new PostModel(in);
        }

        @Override
        public PostModel[] newArray(int size) {
            return new PostModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    protected PostModel(Parcel in) {
        id = in.readInt();
        tieuDe = in.readString();
        moTa = in.readString();
        noiDung = in.readString();
        imageUrl = in.readString();
        baiVietLienQuan = in.createStringArray();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(tieuDe);
        parcel.writeString(moTa);
        parcel.writeString(noiDung);
        parcel.writeString(imageUrl);
        parcel.writeStringArray(baiVietLienQuan);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String[] getBaiVietLienQuan() {
        return baiVietLienQuan;
    }

    public void setBaiVietLienQuan(String[] baiVietLienQuan) {
        this.baiVietLienQuan = baiVietLienQuan;
    }
}
