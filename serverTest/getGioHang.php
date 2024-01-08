<?php
$idKhach =$_GET['idKhach'];
	
	class GioHang
{
 
  public function __construct($idKhach, $idMon, $soLuong,$anh)
  {
    $this->idKhach = $idKhach;
    $this->idMon = $idMon;
    $this->soLuong = $soLuong;
    $this->anh = $anh;   
  }
 
}
	include 'connect.php';

	$sql = "SELECT * FROM giohang where idKhach = '$idKhach'";
	$result = mysqli_query($conn, $sql);

	$arrNl= [];

	if (mysqli_num_rows($result) > 0) {
	  while($row = mysqli_fetch_assoc($result)) {
	    
	  	$nl = new GioHang($row["idKhach"], $row["idMon"], $row["soLuong"], $row["anh"]);
	  	
	  	array_push($arrNl, $nl);
	  	
	  }


	 echo json_encode($arrNl);
	} else {
	  echo "0 results";
	}
	mysqli_close($conn);
	
	?>