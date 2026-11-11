package phuong;

import java.time.LocalDate;

public class SinhVienTuXa extends SinhVien{
	private String nenTang;

	public String getNenTang() {
		return nenTang;
	}

	public void setNenTang(String nenTang) {
		this.nenTang = nenTang;
	}

	public SinhVienTuXa() {
		super();
		
	}

	public SinhVienTuXa(String maSV, String hoTen, LocalDate ngaySinh, String lop, int sotinChi, MonHoc monHoc, String nenTang) {
		super(maSV, hoTen, ngaySinh, lop, sotinChi, monHoc);
		this.nenTang = nenTang;
	}
	
	@Override
	public double thanhTien() {
		return (sotinChi * monHoc.getDonGia()) * 0.9;
	}
	
	@Override
	public String getLoai() {
		return "từ xa";
	}

	@Override
	public String toString() {
		return super.toString() + String.format(" | Nền tảng để học: %-5s", nenTang);
	}
	
	
	

}
