package com.example.orderfood.Model;

public class HoaDonChiTiet {
    private int idHoaDon;
    private int idMon;
    private int soLuong;
    private int gia;

    public HoaDonChiTiet(int idHoaDon, int idMon, int soLuong, int gia) {
        this.idHoaDon = idHoaDon;
        this.idMon = idMon;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getIdMon() {
        return idMon;
    }

    public void setIdMon(int idMon) {
        this.idMon = idMon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "HoaDonChiTiet{" +
                "idHoaDon=" + idHoaDon +
                ", idMon=" + idMon +
                ", soLuong=" + soLuong +
                ", gia=" + gia +
                '}';
    }
}
