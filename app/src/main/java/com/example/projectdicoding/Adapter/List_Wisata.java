package com.example.projectdicoding.Adapter;

public class List_Wisata {
    private String name, lokasi, detail, rating;
    private int photo;

    public List_Wisata(){}

    public List_Wisata(String name, String lokasi, String detail, String rating, int photo) {
        this.name = name;
        this.lokasi = lokasi;
        this.detail = detail;
        this.rating = rating;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
