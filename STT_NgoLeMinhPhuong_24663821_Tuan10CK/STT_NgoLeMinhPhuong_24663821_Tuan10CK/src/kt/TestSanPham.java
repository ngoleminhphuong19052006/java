package kt;

import java.time.LocalDate;

public class TestSanPham {
	public static void main(String[] args) {
		SanPham sp1=new SanPhamDienTu("SP1", "Tu Lanh", LocalDate.now().minusMonths(1), 5000000,500 , 4);
		SanPham sp2=new SanPhamDienTu("SP2", "Tivi", LocalDate.now().minusMonths(5), 8000000,100 , 12);
		SanPham sp3=new SanPhamDienTu("SP3", "Am sieu toc", LocalDate.now().minusMonths(3), 50000,1000 , 3);
		SanPham sp4=new SanPhamThucPham("SP4", "Ca hoi dong hop", LocalDate.now().minusMonths(3), 60000, 200, LocalDate.now().minusMonths(1));
		SanPham sp5=new SanPhamThucPham("SP5", "Ca ngu dong hop", LocalDate.now().minusMonths(4), 100000, 10, LocalDate.now().plusDays(2));
		QuanLySanPham ql=new QuanLySanPham();
		System.out.println("---------Them san pham-----------");
		ql.themSanPham(sp1);
		ql.themSanPham(sp2);
		ql.themSanPham(sp3);
		ql.themSanPham(sp4);
		ql.themSanPham(sp5);
		System.out.println("------Xuat danh sach san pham------");
		ql.xuatSanPham();
		
		String sp="SP4";
		System.out.println("Xoa san pham "+sp);
		ql.xoaSanPham(sp);
		System.out.println("------Xuat danh sach san pham sau khi xoa------");
		ql.xuatSanPham();
		
		int sl=150;
		String maSP="SP2";
		ql.suaSoLuongTon(maSP, sl);
		System.out.println("------Xuat danh sach san pham sau khi sua------");
		ql.xuatSanPham();
		
		String loai="Dientu";
		System.out.println("Xuat san pham la: "+loai);
		ql.xuatSanPhamTheoLoai(loai);
		
		System.out.println("------Xuat danh sach san pham co gia cao nhat------");
		ql.xuatSanPhamGiaBanCaoNhat();
	}
	
}
