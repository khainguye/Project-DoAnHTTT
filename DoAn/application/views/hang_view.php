<!DOCTYPE html>
<html lang="en">
<head>
  <title>Danh sách sản phẩm</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
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
            <a class="dropdown-item" href="<?= base_url() ?>admin/danhSachSp/">Mon an</a>
            <a class="dropdown-item" href="<?= base_url() ?>admin/danhSachHang/">Loai</a>
            <a class="dropdown-item" href="<?= base_url() ?>admin/danhSachUser/">Khach hang</a>
            <a class="dropdown-item" href="<?= base_url() ?>admin/danhSachLienHe/">Quản lý thông tin liên hệ</a>
            <div class="dropdown-divider"></div>
            <!-- <a class="dropdown-item" href="#">Something else here</a> -->
          </div>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<?= base_url() ?>admin/logout"> Đăng xuất</a>
        </li>
      </ul>
      
    </div>
</nav>
  <!-- nav -->

<div class="container">
  <h2>Danh sách hãng </h2>
  <a href="<?= base_url() ?>admin/addHang_view" class="btn btn-success">Thêm</a>
 
  <table class="table table-striped">
    <thead>
      <tr>
        <th>ID</th>
        <th>TÊN</th>
        <th>THAO TÁC</th>
      </tr>
    </thead>
    <tbody>
      <?php foreach ($alldata as $value): ?>
        <tr>
          <td><?= $value['idLoai'] ?></td>
          <td><?= $value['tenLoai'] ?></td>
          

         
  
          <td>
            <a href="<?= base_url() ?>admin/delHang/<?= $value['idLoai'] ?>" class="btn btn-danger">Delete</a>
            <a href="<?= base_url() ?>admin/updateHangView/<?= $value['idLoai'] ?>" class="btn btn-success">Update</a>
            
          </td>

        </tr>
      <?php endforeach ?>
      
      
    </tbody>
  </table>
</div>

</body>
</html>
