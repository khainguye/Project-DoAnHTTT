<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Đặt xe</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
  
  <table class="table table-striped">
    <thead>
      <tr>
      	
      </tr>
    </thead>
    <tbody>
    <form action="<?= base_url() ?>xemay/datXe" method="post" enctype="multipart/form-data">
      <?php foreach ($alldata as $value): ?>
       <section class="vh-100 gradient-custom">
		  <div class="container py-5 h-100">
		    <div class="row d-flex justify-content-center align-items-center h-100">
		      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
		        <div class="card bg-dark text-white" style="border-radius: 1rem;">
		          <div class="card-body p-5 text-center">

		            
		            	<div class="mb-md-5 mt-md-4 pb-5">

			              <h2 class="fw-bold mb-2 text-uppercase">Thông tin đặt hàng</h2>
			              
							
			              <div class="form-outline form-white mb-4">
			              	<label class="form-label" for="typeEmailX">Họ tên người nhận</label>
			                <input name="fullname" type="text" id="typeEmailX" class="form-control form-control-lg" value="<?= $value['fullname'] ?>" />
			                
			              </div>

			              <div class="form-outline form-white mb-4">
			              	<label class="form-label" for="typePasswordX">Số điện thoại</label>

			                <input name="phone" type="text" id="typePasswordX" class="form-control form-control-lg" value="<?= $value['phone'] ?>" />
			                
			              </div>

			              <div class="form-outline form-white mb-4">
			              	<label class="form-label" for="typePasswordX">Địa chỉ nhận hàng</label>
			                <input name="address" type="text" id="typePasswordX" class="form-control form-control-lg" value="<?= $value['address'] ?>" />
			                
			              </div>

			              <div class="form-outline form-white mb-4">
			              	<label class="form-label" for="typePasswordX">Số lượng</label>
			                <input name="soLuong" type="number" id="typePasswordX" class="form-control form-control-lg" value="<?= $value['address'] ?>" />
			                
			              </div>

			              

			              <div class="form-outline form-white mb-4">
			              	
			                <input name="idXe" type="hidden" id="typePasswordX" class="form-control form-control-lg" value="<?= $this->session->userdata('idXe') ?>" />
			                
			              </div>

			              <div class="form-outline form-white mb-4">
			              	
			                <input name="username" type="hidden" id="typePasswordX" class="form-control form-control-lg" value="<?= $this->session->userdata('member') ?>" />
			                
			              </div>



			              <button class="btn btn-outline-light btn-lg px-5" type="submit">Đặt hàng</button>

			              

			            </div>
		           

		            

		          </div>
		        </div>
		      </div>
		    </div>
		  </div>
		</section>
       
      <?php endforeach ?>
      
     </form>  
    </tbody>
  </table>
</div>
</body>
</html>