package phuong;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QuanLySinhVien implements IFSinhVien{
	List<SinhVien> ls;
	
	public QuanLySinhVien() {
		ls = new ArrayList<>();
	}
	
	@Override
	public SinhVien timTheoMa(String maSV) {
		for(SinhVien sv : ls) {
			if(sv.getMaSV().equalsIgnoreCase(maSV)) {
				return sv;
			}
		}
		return null;
	}
	
	@Override
	public List<SinhVien> timTheoLoai(String tuKhoa) {
		List<SinhVien> ketQua = new ArrayList<>();
		for (SinhVien sv : ls) {
			if (sv.getLoai().toLowerCase().contains(tuKhoa.toLowerCase())) {
				ketQua.add(sv);
			}
		}
		return ketQua;
	}

	@Override
	public List<SinhVien> timTheoMon(String tuKhoa) {
		List<SinhVien> ketQua = new ArrayList<>();
		for (SinhVien sv : ls) {
			if (sv.getMonHoc().getTenMon().toLowerCase().contains(tuKhoa.toLowerCase())) {
				ketQua.add(sv);
			}
		}
		return ketQua;
	}
	
	@Override
	public boolean them(SinhVien sv) {
		if(ls.contains(sv)) {
			return false;
		}
		return ls.add(sv);
				
	}
	
	@Override
	public boolean sua(String maSV, SinhVien svMoi) {
		for (int i = 0; i < ls.size(); i++) {
			if (ls.get(i).getMaSV().equalsIgnoreCase(maSV)) {
				ls.set(i, svMoi);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean xoa(String maSV) {
		SinhVien sv = timTheoMa(maSV);
		if (sv != null) {
			return ls.remove(sv);
		}
		return false;
	}
	
	@Override
	public List<SinhVien> layTatCa() {
		return ls;
	}
	
	@Override
	public int tongSoLuong() {
		return ls.size();
	}
	
	@Override
	public double tongThanhTien() {
		double tong = 0;
		for (SinhVien sv : ls) {
			tong += sv.thanhTien();
		}
		return tong;
	}
	
	@Override
	public List<SinhVien> sapXepTheoTen() {
		List<SinhVien> banSao = new ArrayList<>(ls);
		banSao.sort(Comparator.comparing(SinhVien::getHoTen).reversed());
		return banSao;
	}

	@Override
	public List<SinhVien> sapXepTheoThanhTienGiamDan() {
		List<SinhVien> banSao = new ArrayList<>(ls);
		banSao.sort((sv1, sv2) -> Double.compare(sv2.thanhTien(), sv1.thanhTien()));
		return banSao;
	}

}
