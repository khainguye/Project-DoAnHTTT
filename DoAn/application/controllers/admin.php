<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class admin extends CI_Controller {

	public function __construct()
	{
		parent::__construct();
		$this->load->model('admin_model');
	}

	public function index()
	{
		if($this->session->userdata('memberAd'))
		{
			$data = $this->admin_model->getAllDonHang();
			$data['alldata'] = $data;
			$this->load->view('admin_view',$data);
		}
		else
		{
			redirect('admin/login','refresh');
		}
		
	}
	

	//xu ly dang nhap
	public function login()
	{
		$this->load->view('loginAd_view');
		$username = $this->input->post('username');
		$password = $this->input->post('password');

		if($username == "" || $password == ""){
			echo 'nhap day du thong tin';
		}
		else
		{
			$result = $this->admin_model->login($username, $password);
			if($result == 1)
			{
				//tao session
				$this->session->set_userdata('memberAd',$username);
				redirect('admin/index','refresh');
			}
			else
			{
				echo 'sai tai khoan hoac mat khau';
			}
		}
				
	}

	//logout
	public function logout()
	{
		if($this->session->userdata('memberAd')){
			// huy session
			$this->session->unset_userdata('memberAd');
			redirect('admin/login','refresh');
		}
				
	}
	//hien danh sach san pham
	public function danhSachSp()
	{
		if($this->session->userdata('memberAd'))
		{
			$data = $this->admin_model->getAllSp();
			$data['alldata'] = $data;
			$this->load->view('sanpham_view', $data);
		}
		
	}
	//quan ly lien he

	public function danhSachLienHe()
	{
		if($this->session->userdata('memberAd'))
		{
			$data = $this->admin_model->getAllLH();
			$data['alldata'] = $data;
			$this->load->view('lienhe_view', $data);
		}
		
	}

// update link 

	public function updateLH_view($id)
	{
		if($this->session->userdata('memberAd'))
		{
			$data = $this->admin_model->getLienHe($id);
			$data['alldata'] = $data;
			$this->load->view('updateLH_view',$data);
			
		}
		
	}

	public function updateLH()
	{
		if($this->session->userdata('memberAd'))
		{

			$link = $this->input->post('link');
			$id = $this->input->post('id');
			$this->admin_model->updateLH($id,$link);
			redirect('admin/danhSachLienHe','refresh');
			
		}
		
	}


	//them san pham 
	public function addSp_view()
	{
		if($this->session->userdata('memberAd')){
			$data = $this->admin_model->getAllHang();
			$data['alldata'] = $data;
			$this->load->view('addSp_view',$data);
		}
		
	}
	public function addSp()
	{
		$host = "10.30.2.15";
		if($this->session->userdata('memberAd'))
		{
		$tenMon = $this->input->post('tenMon');
		$gia = $this->input->post('gia');
		$idLoai = $this->input->post('idLoai');
		$moTa = $this->input->post('moTa');
		

		// xuLy anh
					$target_dir = "uploads/";
					$target_file = $target_dir . basename($_FILES["fileToUpload"]["name"]);
					$uploadOk = 1;
					$imageFileType = strtolower(pathinfo($target_file,PATHINFO_EXTENSION));

					// Check if image file is a actual image or fake image
					if(isset($_POST["submit"])) {
					  $check = getimagesize($_FILES["fileToUpload"]["tmp_name"]);
					  if($check !== false) {
					    echo "File is an image - " . $check["mime"] . ".";
					    $uploadOk = 1;
					  } else {
					    echo "File is not an image.";
					    $uploadOk = 0;
					  }
					}


					// Check if $uploadOk is set to 0 by an error
					if ($uploadOk == 0) {
					  echo "Sorry, your file was not uploaded.";
					// if everything is ok, try to upload file
					} else {
					  if (move_uploaded_file($_FILES["fileToUpload"]["tmp_name"], $target_file)) {
					    echo "The file ". htmlspecialchars( basename( $_FILES["fileToUpload"]["name"])). " has been uploaded.";
					  } else {
					    echo "Sorry, there was an error uploading your file.";
					  }
					}
			        	

			        //lay duong dan	
			        $anh = "http://$host/DoAn/uploads/". basename( $_FILES["fileToUpload"]["name"]);	
		// xuLy anh end
			        // echo "  ".$tenMon."";
			        // echo "  ".$idLoai;
			        // echo "  ".$gia;
			        // echo "  ".$anh;
			        // echo "  ".$moTa;

					if($tenMon && $gia && $idLoai  && $moTa && $anh != null)
					{
						$this->admin_model->addSp($tenMon,$gia,$idLoai,$anh,$moTa);
						redirect('admin/danhSachSp','refresh');
					}
					else
					{
						echo "Dien day du";
						redirect('admin/addSp_view','refresh');
					}
		}
	}

	//xoa san pham
	public function delSp($idMon)
	{
		if($this->session->userdata('memberAd'))
		{
			$this->admin_model->delSp($idMon);
			redirect('admin/danhSachSp','refresh');
		}
		
	}

	//updateView San pham
	public function updateSp_view($idMon)
	{
		if($this->session->userdata('memberAd'))
		{
			$data = $this->admin_model->getSp($idMon);
			$data['alldata'] = $data;
			$this->load->view('updataSp_view', $data);
		}
		
	}
	public function updateSp()
	{
		$host = "10.30.2.15";
		if($this->session->userdata('memberAd'))
		{
		$idMon = $this->input->post('idMon');
		$ten = $this->input->post('tenMon');
		$gia = $this->input->post('gia');


// xuLy anh
					$target_dir = "uploads/";
					$target_file = $target_dir . basename($_FILES["fileToUpload"]["name"]);
					$uploadOk = 1;
					$imageFileType = strtolower(pathinfo($target_file,PATHINFO_EXTENSION));

					// Check if image file is a actual image or fake image
					if(isset($_POST["submit"])) {
					  $check = getimagesize($_FILES["fileToUpload"]["tmp_name"]);
					  if($check !== false) {
					    echo "File is an image - " . $check["mime"] . ".";
					    $uploadOk = 1;
					  } else {
					    echo "File is not an image.";
					    $uploadOk = 0;
					  }
					}


					// Check if $uploadOk is set to 0 by an error
					if ($uploadOk == 0) {
					  echo "Sorry, your file was not uploaded.";
					// if everything is ok, try to upload file
					} else {
					  if (move_uploaded_file($_FILES["fileToUpload"]["tmp_name"], $target_file)) {
					    echo "The file ". htmlspecialchars( basename( $_FILES["fileToUpload"]["name"])). " has been uploaded.";
					  } else {
					    echo "Sorry, there was an error uploading your file.";
					  }
					}
			        	

			        //lay duong dan	
			        $anh = "http://$host/DoAn/uploads/". basename( $_FILES["fileToUpload"]["name"]);	
		// xuLy anh end
		
		// udpate

		$this->admin_model->updateSp($idMon,$ten,$gia,$anh);
		redirect('admin/danhSachSp','refresh');     
		}   


	}


	//hienr thi danh sach hang

	public function danhSachHang()
	{
		if($this->session->userdata('memberAd'))
		{
			$data = $this->admin_model->getAllHang();
			$data['alldata'] = $data;
			$this->load->view('hang_view', $data);	
		}

		
	}

	// view them hãng
	public function addHang_view()
	{
		if($this->session->userdata('memberAd'))
		{
			$this->load->view('addHang_view');
		}
		
	}

	public function addHang()
	{
		if($this->session->userdata('memberAd'))
		{
			$ten = $this->input->post('ten');
			$this->admin_model->addHang($ten);
			redirect('admin/danhSachHang','refresh');
		}
		
	}

	//xoa hãng

	public function delHang($idHang)
	{
		if($this->session->userdata('memberAd'))
		{
			$this->admin_model->delHang($idHang);
			redirect('admin/danhSachHang','refresh');
		}
		
	}
	//danh sach user
	public function danhSachUser()
	{
		if($this->session->userdata('memberAd'))
		{
			$data = $this->admin_model->getAllUser();
			$data['alldata'] = $data;
			$this->load->view('user_view', $data);
		}
		
	}
	//xoa user
	public function delUser($id)
	{
		if($this->session->userdata('memberAd'))
		{
			$this->admin_model->delUser($id);
			redirect('admin/danhSachUser','refresh');	
		}

	}

	

	

	//nut xu ly don hang
	public function deleteDonHang($id)
	{	
		if($this->session->userdata('memberAd'))
		{
			$this->admin_model->delDonHang($id);
			redirect('admin/index','refresh');
		}
		
	}
	// update hang view

	public function updateHangView($idHang)
	{	
		if($this->session->userdata('memberAd'))
		{
			$data = $this->admin_model->getHang($idHang);
			$data['alldata'] = $data;
			$this->load->view('updateHang_view', $data);
		}		
	}
	public function updateHang()
	{	
		if($this->session->userdata('memberAd'))
		{
			$tenLoai = $this->input->post('tenLoai');
			$idLoai = $this->input->post('idLoai');
			$this->admin_model->updateHang($idLoai,$tenLoai);
		redirect('admin/danhSachHang','refresh');
		}
		
		
	}
	public function thongKe()
	{	
		if($this->session->userdata('memberAd'))
		{
			$data = $this->admin_model->thongKe();
			$data['alldata'] = $data;
			$this->load->view('thongKe_view', $data);	
		}
		
		
	}
	public function hoaDonChiTiet($idHoaDon)
	{	
		$data = $this->admin_model->getHoaDonChiTiet($idHoaDon);
			$data['alldata'] = $data;
			$this->load->view('chiTiet_view', $data);	
	}

}

/* End of file admin.php */
/* Location: ./application/controllers/admin.php */