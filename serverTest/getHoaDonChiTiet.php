<?php
$idHoaDon = $_GET['idHoaDon'];

	
	class HoaDonChiTiet
{
  public function __construct($idHoaDon,$idMon, $soLuong, $gia)
  {
  
  	$this->idHoaDon = $idHoaDon;
    $this->idMon = $idMon;  
    $this->soLuong = $soLuong;   
    $this->gia = $gia;
  }
}
	include 'connect.php';

	$sql = "SELECT * FROM chitiethoadon where idHoaDon = '$idHoaDon'";
	$result = mysqli_query($conn, $sql);
	$arrNl= [];

	if (mysqli_num_rows($result) > 0) {
	  while($row = mysqli_fetch_assoc($result)) {
	  	$nl = new HoaDonChiTiet($row["idHoaDon"], $row["idMon"], $row["soLuong"], $row["gia"]);
	  	array_push($arrNl, $nl);	
	  }
	 echo json_encode($arrNl);
	} else {
	  echo "0 results";
	}
	mysqli_close($conn);
	?>