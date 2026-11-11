package phuong;

import java.time.LocalDate;

public class SinhVienChinhQui extends SinhVien{
	private String hocTrucTiep;

	public String getHocTrucTiep() {
		return hocTrucTiep;
	}

	public void setHocTrucTiep(String hocTrucTiep) {
		this.hocTrucTiep = hocTrucTiep;
	}

	public SinhVienChinhQui() {
		super();
		
	}

	public SinhVienChinhQui(String maSV, String hoTen, LocalDate ngaySinh, String lop, int sotinChi, MonHoc monHoc, String hocTrucTiep) {
		super(maSV, hoTen, ngaySinh, lop, sotinChi, monHoc);
		this.hocTrucTiep = hocTrucTiep;
	} 
	
	@Override
	public double thanhTien() {
		return sotinChi * monHoc.getDonGia();
	}
	
	@Override
	public String getLoai() {
		return "chính qui";
	}

	@Override
	public String toString() {
		return super.toString() + String.format(" | Học tại: %-5s", hocTrucTiep);
	}
	
	
		
	

}
