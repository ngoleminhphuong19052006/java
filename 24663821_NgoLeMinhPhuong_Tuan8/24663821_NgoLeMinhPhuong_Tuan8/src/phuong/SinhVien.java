package phuong;
import java.time.LocalDate;

public abstract class SinhVien {
	protected String maSV;
	protected String hoTen;
	protected LocalDate ngaySinh;
	protected String lop;
	protected int sotinChi;
	protected MonHoc monHoc;
	
	
	public SinhVien() {
		
	}


	public SinhVien(String maSV, String hoTen, LocalDate ngaySinh, String lop, int sotinChi, MonHoc monHoc) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.lop = lop;
		this.sotinChi = sotinChi;
		this.monHoc = monHoc;
	}


	public String getMaSV() {
		return maSV;
	}


	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}


	public String getHoTen() {
		return hoTen;
	}


	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}


	public LocalDate getNgaySinh() {
		return ngaySinh;
	}


	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}


	public String getLop() {
		return lop;
	}


	public void setLop(String lop) {
		this.lop = lop;
	}


	public int getSotinChi() {
		return sotinChi;
	}


	public void setSotinChi(int sotinChi) {
		this.sotinChi = sotinChi;
	}


	public MonHoc getMonHoc() {
		return monHoc;
	}


	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}
	
	
	public abstract double thanhTien();
	
	public abstract String getLoai();
	
	@Override
    public String toString() {
        return String.format("MaSV: %-6s | HoTen: %-18s | NgaySinh: %-10s | Lop: %-8s | TinChi: %-2d | Mon: %-18s | ThanhTien: %,.0f VND | Loai: %-10s", maSV, hoTen, ngaySinh, lop, sotinChi, monHoc, thanhTien(), getLoai());
    }
	
}
