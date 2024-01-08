package com.example.orderfood.Model;

import java.io.Serializable;

public class HoaDon implements Serializable {
    private int idHoaDon;
    private int idKhach;
    private String date;
    private String address;
    private String phone;
    private int total;

    public HoaDon(int idHoaDon,int idKhach,String date, String address, String phone, int total) {
        this.idHoaDon = idHoaDon;
        this.idKhach = idKhach;
        this.date = date;
        this.address = address;
        this.phone = phone;
        this.total = total;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getIdKhach() {
        return idKhach;
    }

    public void setIdKhach(int idKhach) {
        this.idKhach = idKhach;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "HoaDon{" +
                "date='" + date + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", total=" + total +
                '}';
    }
}
