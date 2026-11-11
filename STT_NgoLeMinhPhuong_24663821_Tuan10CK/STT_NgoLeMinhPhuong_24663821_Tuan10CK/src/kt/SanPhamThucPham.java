package kt;

import java.time.LocalDate;

public class SanPhamThucPham extends SanPham{
	private LocalDate ngayHH;

	public SanPhamThucPham(String maSP, String tenSP, LocalDate ngaySX, double giaNhap, int soLuongTon,
			LocalDate ngayHH) {
		super(maSP, tenSP, ngaySX, giaNhap, soLuongTon);
		this.ngayHH = ngayHH;
	}

	public LocalDate getNgayHH() {
		return ngayHH;
	}

	public void setNgayHH(LocalDate ngayHH) {
		this.ngayHH = ngayHH;
	}
	
	public double giaBan() {
		if(ngayHH.isAfter(LocalDate.now())) {
			return 0;
		}
		else {
			return this.giaNhap+(this.giaNhap*0.05);
		}
	}

	@Override
	public String toString() {
		return super.toString() +" | Loai: SanPhamThucPham: ngay Het Han: " + ngayHH + " Gia ban: "+giaBan()+"VND";
	}
	
}
