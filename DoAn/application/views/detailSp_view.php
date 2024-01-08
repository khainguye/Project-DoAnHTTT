<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>San pham</title>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
</head>
<body>
	<!-- navbar -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="<?= base_url() ?>xemay/index"><img src="https://i.pinimg.com/564x/e0/c3/0f/e0c30f817731d724c7ad38445e725031.jpg" style="height: 100px ; width: 100px"></a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>

	  <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
      <!-- form loc thong tin -->
	    <form method="post" action="<?= base_url() ?>/xemay/xuLyLoc_Hang">
         <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                   
            </div>
          </li>

          <li> 
          <p style="padding-right: 20px"> </p>
          </li>
         
  
          <!-- <input type="submit" value="Sang ham xu ly loc"> -->
        </ul> 
      </form>

	    
      <a href="<?= base_url() ?>/xemay/detailUser"><i class="fas fa-user"></i></a>
	  </div>
	</nav>

	<!-- navbar -->

	<!-- body -->
	<div class="container">
  
  <table class="table table-striped">
    <thead>
      <tr>
      	<td></td>
      	<td style="font-size: 20px">Tên xe</td>
      	<td style="font-size: 20px">Giá</td>
      	<td style="font-size: 20px">Tên hãng</td>
      	<td style="font-size: 20px">Loại xe</td>
      	<td style="font-size: 20px">Số lượng</td>
 
      </tr>
    </thead>
    <tbody>
      <?php foreach ($alldata as $value): ?>
        <tr>
		  <td><img  style=" height: 200px;width: 350px" src="<?= $value['anh'] ?>" ></td>
          <td><p style="font-size: 25px"><?= $value['ten'] ?></p></td>
          <td><?= $value['gia'] ?></td>
          <td><?= $value['tenHang'] ?></td>
          <td><?= $value['loai'] ?></td>
          <td><?= $value['soLuong'] ?></td>
                    

        </tr>
        <tr>
          <td style="font-size: 25px">Thông số kĩ thuật</td>
        </tr>
        <tr>
          <td>Kích thước</td>
          <td>Trọng lượng</td>
          <td>Dung tích xi-lanh</td>
          <td>Dung tích bình xăng</td>
          <td>Lượng tiêu thụ xăng/100km</td>
        </tr>

        <tr>
        	<td><?= $value['kichThuoc']?> mm</td>
          <td><?= $value['trongLuong']?> kg</td>
          <td><?= $value['dungTichXL']?> cc</td>
          <td><?= $value['dungTichBX']?> lít</td>
          <td><?= $value['tieuThu']?> lít/km</td>
        </tr>
        <tr>
          <th>Giới thiệu</th>
        </tr>
        <td><?= $value['gioiThieu'] ?></td>
        <tr>
          <td>
            <a  style="width: 300px; height: 70px" href="<?= base_url() ?>xemay/datXe_view/<?= $value['idXe'] ?>" class="btn btn-success"><p style="font-size: 25px">Đặt xe</p></a>
          </td>
        </tr>
      <?php endforeach ?>
      
      
    </tbody>
  </table>
</div>
	<!-- body -->
  <!-- Footer -->
<footer class="text-center text-lg-start bg-white text-muted">
  <!-- Section: Social media -->
  <section class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
    <!-- Left -->
    <div class="me-5 d-none d-lg-block">
      <span>Get connected with us on social networks:</span>
    </div>
    <!-- Left -->

    <!-- Right -->
    <div>
      <a href="" class="me-4 link-secondary">
        <i class="fab fa-facebook-f"></i>
      </a>
      <a href="" class="me-4 link-secondary">
        <i class="fab fa-twitter"></i>
      </a>
      <a href="" class="me-4 link-secondary">
        <i class="fab fa-google"></i>
      </a>
      <a href="" class="me-4 link-secondary">
        <i class="fab fa-instagram"></i>
      </a>
      <a href="" class="me-4 link-secondary">
        <i class="fab fa-linkedin"></i>
      </a>
      <a href="" class="me-4 link-secondary">
        <i class="fab fa-github"></i>
      </a>
    </div>
    <!-- Right -->
  </section>
  <!-- Section: Social media -->

  

  <!-- Copyright -->
  <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.025);">
    © 2022 Copyright:
    <a class="text-reset fw-bold" href="https://mdbootstrap.com/">Xemay.com</a>
  </div>
  <!-- Copyright -->
</footer>
<!-- Footer -->
</body>
</html>