package com.example.orderfood;

public class Server {
    public static String localhost = "10.30.2.15";
    public static  String duongDanSanPham = "http://"+localhost+"/serverTest/getAllMon.php";
    public static  String addGioHang = "http://"+localhost+"/serverTest/addGioHang.php?idKhach=";
    //    public static  String loadGioHang = "http://"+localhost+"/serverTest/addGioHang.php";
    public static  String getGioHang = "http://"+localhost+"/serverTest/getGioHang.php?idKhach=";

    public static String updateGioHang = "http://"+localhost+"/serverTest/updateGioHang.php";
    public static String updateInfo = "http://"+localhost+"/serverTest/updateInfo.php";
    public static String delGioHang = "http://"+localhost+"/serverTest/delGioHang.php";
    public static String delAllGioHangUser = "http://"+localhost+"/serverTest/dellAllGioHang.php";
    public static String addKhachHang = "http://"+localhost+"/serverTest/signup.php";
    public static String addHoaDon = "http://"+localhost+"/serverTest/addHoaDon.php";
    public static String addChiTietHoaDon = "http://"+localhost+"/serverTest/addChiTietHoaDon.php";
    public static String getIdHoaDon = "http://"+localhost+"/serverTest/getIdHoaDon.php";
    public static String getHoaDon = "http://"+localhost+"/serverTest/getHoaDon.php?idKhach=";
    public static String getHoaDonChiTiet = "http://"+localhost+"/serverTest/getHoaDonChiTiet.php?idHoaDon=";
    public static String kiemTraSdt = "http://"+localhost+"/serverTest/kiemTraSdt.php?phone=";

}
