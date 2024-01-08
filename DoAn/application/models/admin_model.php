<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class admin_model extends CI_Model {

	public $variable;

	public function __construct()
	{
		parent::__construct();
		$this->load->database();	
	}
	public function login($username,$password)
	{
		$this->db->where('username', $username);
		$this->db->where('password', $password);
		return $this->db->get('taikhoan')->num_rows();
	}
	// lay tat ca don hang
	public function getAllDonHang()
	{
		$this->db->order_by('idHoaDon', 'DESC');
		 return $this->db->get('hoadon')->result_array();
	}
	//lay tat ca lien he
	public function getAllLH()
	{
		 return $this->db->get('lienhe')->result_array();
	}
	//lya lien he theo id
	public function getLienHe($id)
	{
		$this->db->where('id', $id);
		return $this->db->get('lienhe')->result_array();
	}
	//update LienHe
	public function updateLH($id,$link)
	{
		$this->db->where('id', $id);
		 $object = array('link'=>$link);
		 $this->db->update('lienhe', $object);
	}
	//lay tat ca san pham
	public function getAllSp()
	{
		 return $this->db->get('monan')->result_array();
	}
	//lay san pham theo id
	public function getSp($idMon)
	{
		$this->db->where('idMon', $idMon);
		return $this->db->get('monan')->result_array();
	}

	//lay tat thong tin tat ca hang
	public function getAllHang()
	{
		 return $this->db->get('loaimon')->result_array();
	}

	public function addSp($tenMon,$gia,$idLoai,$anh,$moTa)
	{
		$object= array('tenMon'=>$tenMon,'gia'=>$gia,'moTa'=>$moTa,'anh'=>$anh,'idLoai'=>$idLoai);
		$this->db->insert('monan', $object);
	}

	//xoa sp

	public function delSp($idMon)
	{
		$this->db->where('idMon', $idMon);
		$this->db->delete('monan');	
	}
// ham update san pham
	public function updateSp($idMon,$ten,$gia,$anh)
	{
		$this->db->where('idMon', $idMon);

		$object= array('tenMon'=>$ten,'gia'=>$gia,'anh'=>$anh);

		$this->db->update('monan', $object);	
	}

	//them hãng

	public function addHang($ten)
	{
		$object= array('tenLoai'=>$ten);
		$this->db->insert('loaimon', $object);
	}
	

	//del hang

	public function delHang($idHang)
	{
		$this->db->where('idLoai', $idHang);
		$this->db->delete('loaimon');
	}

	//get hang theo id
	public function getHang($idHang)
	{
		$this->db->where('idLoai', $idHang);
		return $this->db->get('loaimon')->result_array();
	}

	//getAll khach hang

	public function getAllUser()
	{
		 return $this->db->get('khachhang')->result_array();
	}

	//xoa user

	public function delUser($id)
	{
		$this->db->where('idKhach', $id);
		$this->db->delete('khachhang');	
	}

	//get User

	public function getUser($id)
	{
		$this->db->where('id', $id);
		return $this->db->get('user')->result_array();	
	}
	//get hoa don chi tiet
	public function getHoaDonChiTiet($id)
	{
		$this->db->where('idHoaDon', $id);
		return $this->db->get('chitiethoadon')->result_array();	
	}
	//update user
	public function updateUser($id,$username,$password,$fullname,$address,$phone)
	{
		$this->db->where('id', $id);
		$object = array('username'=>$username, 'password'=>$password, 'fullname'=>$fullname, 'address'=>$address, 'phone'=>$phone);
		$this->db->update('user', $object);
	}

	//xoa hang
	public function delDonHang($id)
	{
		$this->db->where('id', $id);
		$this->db->delete('donhang');
	}

	//update HAng

	public function updateHang($idLoai,$tenLoai)
	{
		$this->db->where('idLoai', $idLoai);
		$object = array('tenLoai'=>$tenLoai);
		$this->db->update('loaimon',$object);
	}


//thong ke chung

	public function thongKe()
	{
		$this->db->select('monan.idMon, monan.tenMon,SUM(soLuong) as soLuong, SUM(chitiethoadon.soluong * monan.gia) as tongTien');
		$this->db->from('monan');
		$this->db->join('chitiethoadon', 'monan.idMon = chitiethoadon.idMon');
		$this->db->group_by('monan.idMon');
		$this->db->order_by('tongTien', 'desc');
		$query = $this->db->get();;
		return $query->result_array();
	}

}

/* End of file admin_model.php */
/* Location: ./application/models/admin_model.php */