<?php 

include 'connect.php';

$idKhach =$_POST['idKhach'];
$sdt = $_POST['sdt'];
$diaChi = $_POST['diaChi'];
$ngayDat = $_POST['ngayDat'];
$tong = $_POST['tong'];

	

$sql = "INSERT INTO hoadon VALUES(null,'$idKhach','$sdt','$diaChi','$ngayDat','$tong')";

if (mysqli_query($conn, $sql)) {
  echo "Success";
} else {
  echo "Error" . mysqli_error($conn);
}

mysqli_close($conn);

 ?>