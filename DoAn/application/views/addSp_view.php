<!DOCTYPE html>
<html lang="en">
<head>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<meta charset="UTF-8">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	
</head>
<body>
	<!-- nav -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="<?= base_url() ?>admin/index">ADMIN </a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>

	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <ul class="navbar-nav mr-auto">
	      
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Danh sach
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	          <a class="dropdown-item" href="<?= base_url() ?>admin/danhSachSp/">Sản phẩm</a>
	          <a class="dropdown-item" href="<?= base_url() ?>admin/danhSachHang/">Hãng</a>
	          <a class="dropdown-item" href="<?= base_url() ?>admin/danhSachUser/">Người dùng</a>
	          <div class="dropdown-divider"></div>
	          <!-- <a class="dropdown-item" href="#">Something else here</a> -->
	        </div>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="<?= base_url() ?>sinhvien/logout"> Đăng xuất</a>
	      </li>
	    </ul>
	    
	  </div>
</nav>
	
	<!-- nav -->

	<form action="addSp" method="post" enctype="multipart/form-data">
		  <section class="vh-100 gradient-custom">
		  <div class="container py-5 h-100">
		    <div class="row d-flex justify-content-center align-items-center h-100">
		      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
		        <div class="card bg-dark text-white" style="border-radius: 1rem;">
		          <div class="card-body p-5 text-center">

		            <div class="mb-md-5 mt-md-4 pb-5">

		              <h2 class="fw-bold mb-2 text-uppercase">Thêm sản phẩm</h2>
		              

		              <div class="form-outline form-white mb-4">
		              	<label class="form-label" for="typeEmailX">Tên</label>
		                <input type="text" id="typeEmailX" name="tenMon" class="form-control form-control-lg" />
		                
		              </div>

		              <div class="form-outline form-white mb-4">
		              	<label class="form-label" for="typePasswordX">Giá</label>
		                <input type="text" id="typePasswordX" name="gia" class="form-control form-control-lg" />
		                
		              </div>
					
					  <div class="form-outline form-white mb-4">
		              	<label class="form-label" for="typeEmailX">Loai</label>

		              	<select name="idLoai">
							<?php foreach ($alldata as $value): ?>
							 <option value="<?= $value['idLoai'] ?>"><?= $value['tenLoai'] ?></option>
							<?php endforeach ?>
						</select>
		                

		              </div>

		               <div class="form-outline form-white mb-4">
		              	<label class="form-label" for="typeEmailX">Mo ta</label>
		                <input type="text" step="0.01" id="totalAmt" name="moTa" class="form-control form-control-lg" />
		                
		              </div>

		              

		              <div class="form-outline form-white mb-4">
		              	<label class="form-label" for="typeEmailX">Ảnh</label>
		                <input type="file" name="fileToUpload" id="fileToUpload">
		                
		              </div>

		              

		              <input type="submit" value="ADD" name="submit">

		              <div class="d-flex justify-content-center text-center mt-4 pt-1">
		                <a href="#!" class="text-white"><i class="fab fa-facebook-f fa-lg"></i></a>
		                <a href="#!" class="text-white"><i class="fab fa-twitter fa-lg mx-4 px-2"></i></a>
		                <a href="#!" class="text-white"><i class="fab fa-google fa-lg"></i></a>
		              </div>

		            </div>

		            

		          </div>
		        </div>
		      </div>
		    </div>
		  </div>
</section>
</form>





</body>
</html>