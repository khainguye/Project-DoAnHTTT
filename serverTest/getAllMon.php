<?php
	
	class MonAn
{
 
  public function __construct($idMon, $tenMon, $gia,$moTa,$anh,$idLoai)
  {
    $this->idMon = $idMon;
    $this->tenMon = $tenMon;
    $this->gia = $gia;
    $this->moTa = $moTa;
    $this->anh = $anh; 
    $this->idLoai = $idLoai;   
  }
 
}
	include 'connect.php';

	$sql = "SELECT * FROM monan";
	$result = mysqli_query($conn, $sql);

	$arrNl= [];

	if (mysqli_num_rows($result) > 0) {
	  while($row = mysqli_fetch_assoc($result)) {
	    
	  	$nl = new MonAn($row["idMon"], $row["tenMon"], $row["gia"], $row["moTa"], $row["anh"], $row["idLoai"]);
	  	
	  	array_push($arrNl, $nl);
	  	
	  }


	 echo json_encode($arrNl);
	} else {
	  echo "0 results";
	}
	mysqli_close($conn);
	
	?>