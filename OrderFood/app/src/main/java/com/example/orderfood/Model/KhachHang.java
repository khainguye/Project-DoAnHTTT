package com.example.orderfood.Model;

import java.io.Serializable;

public class KhachHang implements Serializable {
    private int idKhach;
    private String ten;
    private String sdt;
    private String password;
    private String diaChi;

    public KhachHang(int idKhach, String ten, String sdt, String password, String diaChi) {
        this.idKhach = idKhach;
        this.ten = ten;
        this.sdt = sdt;
        this.password = password;
        this.diaChi = diaChi;
    }

    public int getIdKhach() {
        return idKhach;
    }

    public void setIdKhach(int idKhach) {
        this.idKhach = idKhach;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "idKhach=" + idKhach +
                ", ten='" + ten + '\'' +
                ", sdt='" + sdt + '\'' +
                ", password='" + password + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }
}
