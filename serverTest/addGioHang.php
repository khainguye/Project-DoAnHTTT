<?php 

include 'connect.php';

$idKhach =$_POST['idKhach'];
$idMon =$_POST['idMon'];
$soLuong = $_POST['soLuong'];
$anh = $_POST['anh'];

	

$sql = "INSERT INTO giohang VALUES('$idKhach','$idMon','$soLuong','$anh')";

if (mysqli_query($conn, $sql)) {
  echo "Success";
} else {
  echo "Error" . mysqli_error($conn);
}

mysqli_close($conn);

 ?>