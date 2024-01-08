<!DOCTYPE html>
<html lang="en">
<head>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />

	<title>Xe máy giao diện</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="<?= base_url() ?>xemay/index"><img src="https://i.pinimg.com/564x/e0/c3/0f/e0c30f817731d724c7ad38445e725031.jpg" style="height: 100px ; width: 100px"></a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Loại xe
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="<?= base_url() ?>xemay/xeGa">Xe ga</a>
          <a class="dropdown-item" href="<?= base_url() ?>xemay/xeSo">Xe số</a>
          <a class="dropdown-item" href="<?= base_url() ?>xemay/xeCon">Xe côn</a>
          
        </div>
      </li>

	  <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
        
                   
     </div>


          
            
          <li> 
          <p style="padding-right: 20px"> </p>
          </li>
         
  
          <!-- <input type="submit" value="Sang ham xu ly loc"> -->
        </ul> 
      </form>

	    <form action="<?= base_url() ?>xemay/search" method = "post" class="form-inline my-2 my-lg-0">

	    	 <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
	       <input class="form-control mr-sm-2" type="search" name="query" placeholder="Search" aria-label="Search">
         
          
	    </form>
      <a href="<?= base_url() ?>/xemay/detailUser"><i class="fas fa-user"></i></a>
	  </div>
	</nav>


<!-- bodyy -->
<div class="container">
  <h2>Danh sách sản phẩm </h2>
 
 
  <table class="table table-striped">
    <thead>
      <tr>

        
        

        

        
      </tr>
    </thead>
    <tbody>
      <?php foreach ($alldata as $value): ?>
        <tr>
          <td><a href="<?= base_url() ?>xemay/detailSp/<?= $value['idXe'] ?>"><img  style=" height: 100px;width: 160px" src="<?= $value['anh'] ?>" ></a></td>
          <td><p style="font-size: 25px"><?= $value['ten'] ?></p></td>
          <td><?= $value['gia'] ?> triệu VND</td>
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
      <a href="<?= base_url() ?>xemay/lienHe/facebook" class="me-4 link-secondary">
        <i class="fab fa-facebook-f"></i>
      </a>
      <a href="<?= base_url() ?>xemay/lienHe/instagram" class="me-4 link-secondary">
        <i class="fab fa-instagram"></i>
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

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>