<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Danh sach don hang</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</head>
<body>
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
	<!-- body -->
	<div class="container">
  <h2>Danh sách đơn hàng </h2>
 

  <table class="table table-striped">
    <thead>
      <tr>
		<th></th>
		<th>Tên người nhận</th>
		<th>Số điện thoại</th>
		<th>Địa chỉ nhận</th>
		<th>Số lượng</th>
      </tr>
    </thead>
    <tbody>
      <?php foreach ($alldata as $value): ?>
        <tr>
          <td><img style="height: 100px;width: 200px" src="<?= $value['anh'] ?>" alt=""></td>
          <td><?= $value['fullname'] ?></td>
          <td><?= $value['phone'] ?></td>
          <td><?= $value['address'] ?></td>         
          <td><?= $value['soLuong'] ?></td>
          

        </tr>
      <?php endforeach ?>
      
      
    </tbody>
  </table>
</div>
	<!-- body -->
</body>
</html>