<?php 
include 'connect.php';

$idKhach =$_POST['idKhach'];


$sql = "DELETE FROM giohang WHERE idKhach = '$idKhach'";

if (mysqli_query($conn, $sql)) {
  echo "Success";
} else {
  echo "Error" . mysqli_error($conn);
}

mysqli_close($conn);
 ?>