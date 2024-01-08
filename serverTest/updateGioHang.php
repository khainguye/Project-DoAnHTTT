<?php 

include 'connect.php';

$idKhach =$_POST['idKhach'];
$idMon =$_POST['idMon'];
$soLuong = $_POST['soLuong'];

$sql = "UPDATE giohang SET soLuong='$soLuong' WHERE idKhach='$idKhach' AND idMon ='$idMon'";

if (mysqli_query($conn, $sql)) {
  echo "Success";
} else {
  echo "Error" . mysqli_error($conn);
}

mysqli_close($conn);

 ?>