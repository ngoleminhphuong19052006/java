package kt;

import java.time.LocalDate;

public class SanPhamDienTu extends SanPham{
	private int thoiGianBH;

	public SanPhamDienTu(String maSP, String tenSP, LocalDate ngaySX, double giaNhap, int soLuongTon, int thoiGianBH) {
		super(maSP, tenSP, ngaySX, giaNhap, soLuongTon);
		this.thoiGianBH = thoiGianBH;
	}

	public int getThoiGianBH() {
		return thoiGianBH;
	}

	public void setThoiGianBH(int thoiGianBH) {
		this.thoiGianBH = thoiGianBH;
	}
	public double giaBan() {
		return this.giaNhap+(this.giaNhap*0.1)+(this.thoiGianBH*50000);
	}
	@Override
	public String toString() {
		return super.toString() + " | Loai: SanPhamDienTu: thoi Gian Bao Hanh: " + thoiGianBH + " thang, Gia ban: "+giaBan()+"VND";
	}
	
	
}
