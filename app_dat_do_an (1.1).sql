-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 01, 2024 at 07:45 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `app_dat_do_an`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `idHoaDon` int(11) NOT NULL,
  `idMon` int(11) NOT NULL,
  `soLuong` int(11) NOT NULL,
  `gia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`idHoaDon`, `idMon`, `soLuong`, `gia`) VALUES
(19, 5, 3, 200000),
(19, 6, 1, 250000),
(20, 5, 3, 200000),
(20, 6, 1, 250000),
(21, 5, 3, 200000),
(21, 6, 1, 250000),
(28, 5, 1, 200000),
(31, 5, 1, 200000),
(33, 5, 1, 200000),
(34, 6, 1, 250000),
(35, 5, 1, 200000),
(36, 6, 2, 250000);

-- --------------------------------------------------------

--
-- Table structure for table `giohang`
--

CREATE TABLE `giohang` (
  `idKhach` int(11) NOT NULL,
  `idMon` int(20) UNSIGNED NOT NULL,
  `soLuong` int(11) NOT NULL,
  `anh` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `idHoaDon` int(11) NOT NULL,
  `idKhach` int(11) NOT NULL,
  `sdt` varchar(50) NOT NULL,
  `diaChi` varchar(100) NOT NULL,
  `ngayDat` varchar(50) NOT NULL,
  `tong` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`idHoaDon`, `idKhach`, `sdt`, `diaChi`, `ngayDat`, `tong`) VALUES
(17, 1, '123', 'Ha Noi', 'Tue Jan 02 00:20:47 GMT+07:00 2024', 870000),
(18, 1, '123', 'Ha Noi', 'Tue Jan 02 00:20:47 GMT+07:00 2024', 870000),
(19, 1, '123', 'Ha Noi', 'Tue Jan 02 00:39:35 GMT+07:00 2024', 870000),
(20, 1, '123', 'Ha Noi', 'Tue Jan 02 00:48:11 GMT+07:00 2024', 870000),
(21, 1, '123', 'Ha Noi', 'Tue Jan 02 00:51:39 GMT+07:00 2024', 870000),
(22, 1, '123', 'Ha Noi', 'Tue Jan 02 01:00:14 GMT+07:00 2024', 470000),
(23, 1, '123', 'Ha Noi', 'Tue Jan 02 01:03:25 GMT+07:00 2024', 220000),
(24, 1, '123', 'Ha Noi', 'Tue Jan 02 01:06:53 GMT+07:00 2024', 220000),
(25, 1, '123', 'Ha Noi', 'Tue Jan 02 01:09:26 GMT+07:00 2024', 220000),
(26, 1, '123', 'Ha Noi', 'Tue Jan 02 01:13:20 GMT+07:00 2024', 270000),
(27, 1, '123', 'Ha Noi', 'Tue Jan 02 01:16:45 GMT+07:00 2024', 670000),
(28, 1, '123', 'Ha Noi', 'Tue Jan 02 01:18:31 GMT+07:00 2024', 220000),
(29, 1, '123', 'Ha Noi', 'Tue Jan 02 01:21:55 GMT+07:00 2024', 720000),
(30, 1, '231231321', 'sad', 'dsad', 2321),
(31, 1, '123', 'Ha Noi', 'Tue Jan 02 01:32:13 GMT+07:00 2024', 220000),
(32, 1, '123', 'Ha Noi', 'Tue Jan 02 01:32:13 GMT+07:00 2024', 220000),
(33, 1, '123', 'Ha Noi', 'Tue Jan 02 01:36:09 GMT+07:00 2024', 220000),
(34, 1, '123', 'Ha Noi', 'Tue Jan 02 01:37:53 GMT+07:00 2024', 270000),
(35, 1, '123', 'Ha Noi', 'Tue Jan 02 01:42:50 GMT+07:00 2024', 220000),
(36, 1, '123', 'Ha Noi', 'Tue Jan 02 01:44:39 GMT+07:00 2024', 520000);

--
-- Triggers `hoadon`
--
DELIMITER $$
CREATE TRIGGER `insert_giohang` AFTER INSERT ON `hoadon` FOR EACH ROW DELETE FROM giohang
WHERE giohang.idKhach = new.idKhach
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `idKhach` int(50) NOT NULL,
  `ten` varchar(50) NOT NULL,
  `sdt` varchar(50) NOT NULL,
  `matkhau` varchar(18) NOT NULL,
  `diaChi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`idKhach`, `ten`, `sdt`, `matkhau`, `diaChi`) VALUES
(1, 'Nguyen a', '123', '123', 'Ha Noi');

-- --------------------------------------------------------

--
-- Table structure for table `loaimon`
--

CREATE TABLE `loaimon` (
  `idLoai` int(11) NOT NULL,
  `tenLoai` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `loaimon`
--

INSERT INTO `loaimon` (`idLoai`, `tenLoai`) VALUES
(1, 'oc'),
(2, 'cua');

-- --------------------------------------------------------

--
-- Table structure for table `monan`
--

CREATE TABLE `monan` (
  `idMon` int(11) NOT NULL,
  `tenMon` varchar(50) NOT NULL,
  `gia` int(11) NOT NULL,
  `moTa` text NOT NULL,
  `anh` varchar(100) NOT NULL,
  `idLoai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `monan`
--

INSERT INTO `monan` (`idMon`, `tenMon`, `gia`, `moTa`, `anh`, `idLoai`) VALUES
(5, 'Cua bien', 200000, 'Món của Hoàng đế hấp ngon gọn là một món ăn truyền thống trong ẩm thực hoàng gia Trung Hoa. Đây là mMón của Hoàng đế hấp ngon gọn là một món ăn truyền thống trong ẩm thực hoàng gia Trung Hoa. Đây là mMón của Hoàng đế hấp ngon gọn là một món ăn truyền thống trong ẩm thực hoàng gia Trung Hoa. Đây là mMón của Hoàng đế hấp ngon gọn là một món ăn truyền thống trong ẩm thực hoàng gia Trung Hoa. Đây là mMón của Hoàng đế hấp ngon gọn là một món ăn truyền thống trong ẩm thực hoàng gia Trung Hoa. Đây là mMón của Hoàng đế hấp ngon gọn là một món ăn truyền thống trong ẩm thực hoàng gia Trung Hoa. Đây là mMón của Hoàng đế hấp ngon gọn là một món ăn truyền thống trong ẩm thực hoàng gia Trung Hoa. Đây là mMón của Hoàng đế hấp ngon gọn là một món ăn truyền thống trong ẩm thực hoàng gia Trung Hoa. Đây là mMón của Hoàng đế hấp ngon gọn là một món ăn truyền thống trong ẩm thực hoàng gia Trung Hoa. Đây là m', 'http://192.168.0.103/DoAn/uploads/pexels-kittisak-kunalittipon-179834.jpg', 2),
(6, 'Sasumi', 250000, 'Món của Hoàng đế hấp ngon gọn là một món ăn truyền thống trong ẩm thực hoàng gia Trung Hoa. Đây là m', 'http://192.168.0.103/DoAn/uploads/pexels-rajesh-tp-2098143.jpg', 1);

-- --------------------------------------------------------

--
-- Table structure for table `phanquyen`
--

CREATE TABLE `phanquyen` (
  `idPhanQuyen` int(11) NOT NULL,
  `tenPhanQuyen` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phanquyen`
--

INSERT INTO `phanquyen` (`idPhanQuyen`, `tenPhanQuyen`) VALUES
(1, 'NhanVien'),
(2, 'KhachHang');

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `idPhanQuyen` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`username`, `password`, `idPhanQuyen`) VALUES
('admin1', '1', 1),
('khach1', '1', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD PRIMARY KEY (`idHoaDon`,`idMon`);

--
-- Indexes for table `giohang`
--
ALTER TABLE `giohang`
  ADD UNIQUE KEY `idMon` (`idMon`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`idHoaDon`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`idKhach`);

--
-- Indexes for table `loaimon`
--
ALTER TABLE `loaimon`
  ADD PRIMARY KEY (`idLoai`);

--
-- Indexes for table `monan`
--
ALTER TABLE `monan`
  ADD PRIMARY KEY (`idMon`),
  ADD KEY `fkLoaiMon` (`idLoai`);

--
-- Indexes for table `phanquyen`
--
ALTER TABLE `phanquyen`
  ADD PRIMARY KEY (`idPhanQuyen`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD KEY `fkPhanQUyen` (`idPhanQuyen`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `idHoaDon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `idKhach` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `loaimon`
--
ALTER TABLE `loaimon`
  MODIFY `idLoai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `monan`
--
ALTER TABLE `monan`
  MODIFY `idMon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `phanquyen`
--
ALTER TABLE `phanquyen`
  MODIFY `idPhanQuyen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `monan`
--
ALTER TABLE `monan`
  ADD CONSTRAINT `fkLoaiMon` FOREIGN KEY (`idLoai`) REFERENCES `loaimon` (`idLoai`);

--
-- Constraints for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `fkPhanQUyen` FOREIGN KEY (`idPhanQuyen`) REFERENCES `phanquyen` (`idPhanQuyen`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
