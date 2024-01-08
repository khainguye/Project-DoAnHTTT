<?php
	
	class Id
{
  public function __construct($idHoaDon)
  {
  	$this->idHoaDon = $idHoaDon;
    
  }
}
	include 'connect.php';

	$sql = "SELECT idHoaDon FROM hoadon ORDER BY idHoaDon DESC LIMIT 1";
	$result = mysqli_query($conn, $sql);
	$arrNl= [];

	if (mysqli_num_rows($result) > 0) {
	  while($row = mysqli_fetch_assoc($result)) {
	    
	  	$nl = new Id($row["idHoaDon"]);
	  	
	  	array_push($arrNl, $nl);	
	  }
	 echo json_encode($arrNl);
	} else {
	  echo "0 results";
	}
	mysqli_close($conn);
	?>