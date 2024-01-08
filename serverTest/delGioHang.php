<?php 
include 'connect.php';

$idKhach =$_POST['idKhach'];
$idMon =$_POST['idMon'];

$sql = "DELETE FROM giohang WHERE idKhach = '$idKhach' AND idMon = '$idMon'";

if (mysqli_query($conn, $sql)) {
  echo "Success";
} else {
  echo "Error" . mysqli_error($conn);
}

mysqli_close($conn);
 ?>