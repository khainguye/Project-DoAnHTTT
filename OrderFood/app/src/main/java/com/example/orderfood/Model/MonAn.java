package com.example.orderfood.Model;

import java.io.Serializable;

public class MonAn implements Serializable {
    private int idMon;
    private String tenMon;
    private String moTa;
    private int gia;
    private String anh;
    private int idLoai;

    public MonAn(int idMon, String tenMon, String moTa, int gia, String anh, int idLoai) {
        this.idMon = idMon;
        this.tenMon = tenMon;
        this.moTa = moTa;
        this.gia = gia;
        this.anh = anh;
        this.idLoai = idLoai;
    }
    public MonAn(){}

    public int getIdMon() {
        return idMon;
    }

    public void setIdMon(int idMon) {
        this.idMon = idMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public int getIdLoai() {
        return idLoai;
    }

    public void setIdLoai(int idLoai) {
        this.idLoai = idLoai;
    }

    @Override
    public String toString() {
        return "MonAn{" +
                "idMon=" + idMon +
                ", tenMon='" + tenMon + '\'' +
                ", moTa='" + moTa + '\'' +
                ", gia=" + gia +
                ", anh='" + anh + '\'' +
                ", idLoai=" + idLoai +
                '}';
    }
}
