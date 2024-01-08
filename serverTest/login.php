<?php
$sdt = $_GET['sdt'];
$matkhauL = $_GET['matkhauL'];
	
	class KhachHang
{
  public function __construct($idKhach, $ten, $sdt, $password, $diaChi)
  {
  	$this->idKhach = $idKhach;
    $this->ten = $ten;  
    $this->std = $sdt;
    $this->password = $password;   
    $this->diaChi = $diaChi;
  }
}
	include 'connect.php';

	$sql = "SELECT * FROM khachhang where sdt = '$sdt' and matkhau = '$matkhauL'";
	$result = mysqli_query($conn, $sql);
	$arrNl= [];

	if (mysqli_num_rows($result) > 0) {
	  while($row = mysqli_fetch_assoc($result)) {
	    
	  	$nl = new KhachHang($row["idKhach"], $row["ten"], $row["sdt"], $row["matkhau"], $row["diaChi"]);
	  	
	  	array_push($arrNl, $nl);	
	  }
	 echo json_encode($arrNl);
	} else {
	  echo "0 results";
	}
	mysqli_close($conn);
	?>