package nguyenvanphu25656911;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QuanLyPhongHoc {
    private ArrayList<PhongHoc> dsPhong;

    
    public QuanLyPhongHoc() {
        dsPhong = new ArrayList<>();
    }

    
    public boolean themPhong(PhongHoc p) {
        if (p == null || timPhong(p.getMaPhong()) != null) {
            return false;
        }
        dsPhong.add(p);
        return true;
    }

    
    public PhongHoc timPhong(String maPhong) {
        for (PhongHoc p : dsPhong) {
            if (p.getMaPhong().equalsIgnoreCase(maPhong)) {
                return p;
            }
        }
        return null;
    }

    
    public List<PhongHoc> getDanhSach() {
        return new ArrayList<>(dsPhong);
    }

    
    public List<PhongHoc> layPhongDatChuan() {
        List<PhongHoc> ketQua = new ArrayList<>();
        for (PhongHoc p : dsPhong) {
            if (p.datChuan()) {
                ketQua.add(p);
            }
        }
        return ketQua;
    }

    
    public void sapXepTheoDayNha() {
        dsPhong.sort(
            Comparator.comparing(
                PhongHoc::getDayNha,
                String.CASE_INSENSITIVE_ORDER
            )
        );
    }

    
    public void sapXepTheoDienTichGiamDan() {
        dsPhong.sort(
            Comparator.comparingDouble(PhongHoc::getDienTich)
                      .reversed()
        );
    }

   
    public void sapXepTheoSoBongDen() {
        dsPhong.sort(
            Comparator.comparingInt(PhongHoc::getSoBongDen)
        );
    }

    
    public boolean capNhatSoMayTinh(String maPhong, int soMayMoi) {
        if (soMayMoi < 0) {
            return false;
        }

        PhongHoc p = timPhong(maPhong);
        if (p instanceof PhongMayTinh) {
            ((PhongMayTinh) p).setSoMayTinh(soMayMoi);
            return true;
        }
        return false;
    }

    
    public boolean xoaPhong(String maPhong) {
        PhongHoc p = timPhong(maPhong);
        if (p == null) {
            return false;
        }
        return dsPhong.remove(p);
    }

   
    public int tongSoPhong() {
        return dsPhong.size();
    }

    
    public List<PhongMayTinh> layPhongMayTinh60May() {
        List<PhongMayTinh> ketQua = new ArrayList<>();

        for (PhongHoc p : dsPhong) {
            if (p instanceof PhongMayTinh) {
                PhongMayTinh pm = (PhongMayTinh) p;
                if (pm.getSoMayTinh() == 60) {
                    ketQua.add(pm);
                }
            }
        }
        return ketQua;
    }

    
    public void inDanhSach(List<? extends PhongHoc> ds) {
        if (ds.isEmpty()) {
            System.out.println("Danh sach rong.");
            return;
        }

        for (PhongHoc p : ds) {
            System.out.println(p);
            System.out.println("Dat chuan: "
                + (p.datChuan() ? "Co" : "Khong"));
        }
    }
}
