<?php
$idKhach = $_GET['idKhach'];

	
	class HoaDon
{
  public function __construct($idHoaDon,$idKhach, $sdt, $diaChi ,$ngayDat, $tong)
  {
  	$this->idKhach = $idKhach;
  	$this->idHoaDon = $idHoaDon;
    $this->ngayDat = $ngayDat;  
    $this->diaChi = $diaChi;
    $this->sdt = $sdt;   
    $this->tong = $tong;
  }
}
	include 'connect.php';

	$sql = "SELECT * FROM hoadon where idKhach = '$idKhach' order by idHoaDon DESC";
	$result = mysqli_query($conn, $sql);
	$arrNl= [];

	if (mysqli_num_rows($result) > 0) {
	  while($row = mysqli_fetch_assoc($result)) {
	    
	  	$nl = new HoaDon($row["idHoaDon"], $row["idKhach"], $row["sdt"], $row["diaChi"], $row["ngayDat"],$row["tong"]);
	  	
	  	array_push($arrNl, $nl);	
	  }
	 echo json_encode($arrNl);
	} else {
	  echo "0 results";
	}
	mysqli_close($conn);
	?>