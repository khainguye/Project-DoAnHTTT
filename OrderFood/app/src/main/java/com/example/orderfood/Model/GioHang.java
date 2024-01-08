package com.example.orderfood.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class GioHang{
    private int id;
    private int idKhach;
    private int idMon;
    private String anh;
    private int soLuong;

    public GioHang(int id, int idKhach, int idMon, String anh, int soLuong) {
        this.id = id;
        this.idKhach = idKhach;
        this.idMon = idMon;
        this.anh = anh;
        this.soLuong = soLuong;
    }
    public GioHang() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdKhach() {
        return idKhach;
    }

    public void setIdKhach(int idKhach) {
        this.idKhach = idKhach;
    }

    public int getIdMon() {
        return idMon;
    }

    public void setIdMon(int idMon) {
        this.idMon = idMon;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "GioHang{" +
                "id=" + id +
                ", idKhach=" + idKhach +
                ", idMon=" + idMon +
                ", anh='" + anh + '\'' +
                ", soLuong=" + soLuong +
                '}';
    }

}
