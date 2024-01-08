<?php 

include 'connect.php';

$idKhach =$_POST['idKhach'];
$ten =$_POST['ten'];
$matkhau =$_POST['matkhau'];
$diaChi = $_POST['diaChi'];

$sql = "UPDATE khachhang SET ten='$ten', matkhau = '$matkhau', diaChi = '$diaChi' WHERE idKhach='$idKhach'";

if (mysqli_query($conn, $sql)) {
  echo "Success";
} else {
  echo "Error" . mysqli_error($conn);
}

mysqli_close($conn);

 ?>