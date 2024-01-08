<?php
$sdt = $_POST['sdt'];
$matkhau = $_POST['matkhau'];
$ten = $_POST['ten'];
$diaChi = $_POST['diaChi'];

	include 'connect.php';

	$sql = "INSERT INTO khachhang VALUES(null,'$ten','$sdt','$matkhau','$diaChi')";
	if (mysqli_query($conn, $sql)) {
  echo "Success";
} else {
  echo "Error" . mysqli_error($conn);
}

mysqli_close($conn);
	?>