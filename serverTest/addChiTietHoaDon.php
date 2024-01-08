<?php 

include 'connect.php';
$idHoaDon =$_POST['idHoaDon'];
$idMon =$_POST['idMon'];
$soLuong =$_POST['soLuong'];
$gia = $_POST['gia'];


$sql = "INSERT INTO chitiethoadon VALUES($idHoaDon,'$idMon','$soLuong','$gia')";

if (mysqli_query($conn, $sql)) {
  echo "Success";
} else {
  echo "Error" . mysqli_error($conn);
}

mysqli_close($conn);

 ?>