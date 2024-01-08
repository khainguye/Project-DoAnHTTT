<?php
$sdt = $_GET['phone'];

  
  class KhachHang
{
  public function __construct($sdt)
  {
    $this->sdt = $sdt;
    
  }
}
  include 'connect.php';

  $sql = "SELECT * FROM khachhang where sdt = '$sdt'";
  $result = mysqli_query($conn, $sql);
  $arrNl= [];

  if (mysqli_num_rows($result) > 0) {
    while($row = mysqli_fetch_assoc($result)) {
      
      $nl = new KhachHang($row["sdt"]);
      
      array_push($arrNl, $nl);  
    }
   echo json_encode($arrNl);
  } else {
    echo "0 results";
  }
  mysqli_close($conn);
  ?>