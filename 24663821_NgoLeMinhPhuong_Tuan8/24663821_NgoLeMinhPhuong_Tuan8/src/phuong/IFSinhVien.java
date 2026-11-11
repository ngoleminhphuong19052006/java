package phuong;


import java.util.List;

public interface IFSinhVien {
	
	    
	    
	    SinhVien timTheoMa(String maSV);
	    List<SinhVien> timTheoLoai(String tuKhoa);
	    List<SinhVien> timTheoMon(String tuKhoa);
	    
	    
	    boolean them(SinhVien sv);
	    boolean sua(String maSV, SinhVien svMoi);
	    boolean xoa(String maSV);
	    
	    
	    List<SinhVien> layTatCa();
	    int tongSoLuong();
	    double tongThanhTien();
	    
	    
	    List<SinhVien> sapXepTheoTen();
	    List<SinhVien> sapXepTheoThanhTienGiamDan();
		
	    
	    
	    
	
}
