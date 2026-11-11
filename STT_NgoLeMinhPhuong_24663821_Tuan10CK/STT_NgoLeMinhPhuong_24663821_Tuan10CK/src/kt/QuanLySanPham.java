package kt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QuanLySanPham {
	List<SanPham> dssp;
	public QuanLySanPham() {
		dssp=new ArrayList<SanPham>();
	}
	public void themSanPham(SanPham sp) {
		for (SanPham sanPham : dssp) {
			if(sanPham.getMaSP().equalsIgnoreCase(sp.getMaSP())) {
				System.out.println("Trung ma!");
				return;
			}
		}
		dssp.add(sp);
		System.out.println("Them thanh cong");
		
	}
	public void xoaSanPham(String maSP) {
		for (SanPham sanPham : dssp) {
			if(sanPham.getMaSP().equalsIgnoreCase(maSP)) {
				dssp.remove(sanPham);
				System.out.println("Xoa thanh cong!");
				return;
			}
		}
		System.out.println("Khong tim thay san pham!");
	}
	public void suaSoLuongTon(String maSP,int soLuongMoi) {
		for (SanPham sanPham : dssp) {
			if(sanPham.getMaSP().equalsIgnoreCase(maSP)) {
				sanPham.setSoLuongTon(soLuongMoi);
				System.out.println("Sua thanh cong!");
				return;
			}
		}
		System.out.println("Khong tim thay san pham!");
	}
	public void xuatSanPham() {
		for (SanPham sanPham : dssp) {
			System.out.println(sanPham);
		}
	}
	public void xuatSanPhamTheoLoai(String loai) {
		if(loai.equalsIgnoreCase("DienTu")) {
			for (SanPham sanPham : dssp) {
				
				if(sanPham instanceof SanPhamDienTu) {
					System.out.println(sanPham);
				}
				
			}
		}
		else if (loai.equalsIgnoreCase("ThucPham")) {
			for (SanPham sanPham : dssp) {
				if(sanPham instanceof SanPhamThucPham) {
					System.out.println(sanPham);
				}
				
			}
		}
		else {
			System.out.println("Khong tim thay san pham thuoc loai: "+loai);
		}
		
	}
	public void xuatSanPhamGiaBanCaoNhat() {
		dssp.sort(Comparator.comparing(SanPham::giaBan).reversed());
		for (SanPham sanPham : dssp) {
			System.out.println(sanPham);
			return;
		}
	}
}

