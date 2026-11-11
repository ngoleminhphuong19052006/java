package kt;

import java.time.LocalDate;
import java.util.Objects;

public abstract class SanPham {
	protected String maSP;
	protected String tenSP;
	protected LocalDate ngaySX;
	protected double giaNhap;
	protected int soLuongTon;
	public abstract double giaBan();
	public SanPham(String maSP, String tenSP, LocalDate ngaySX, double giaNhap, int soLuongTon) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.ngaySX = ngaySX;
		this.giaNhap = giaNhap;
		this.soLuongTon = soLuongTon;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public LocalDate getNgaySX() {
		return ngaySX;
	}
	public void setNgaySX(LocalDate ngaySX) {
		this.ngaySX = ngaySX;
	}
	public double getGiaNhap() {
		return giaNhap;
	}
	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}
	public int getSoLuongTon() {
		return soLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	@Override
	public String toString() {
		return "SanPham: Ma san pham: " + maSP + ", Ten SP: " + tenSP + ", ngay San Xuat: " + ngaySX + ", gia Nhap: " + giaNhap
				+ " VND, So Luong Ton Kho: " + soLuongTon;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maSP);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return Objects.equals(maSP, other.maSP);
	}
	
}
