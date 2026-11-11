package phuong;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangThucPham {

    

    private final String maHang;       
    private String tenHang;
    private double donGia;
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;


    
    public HangThucPham(String maHang, String tenHang, double donGia,
                        LocalDate ngaySanXuat, LocalDate ngayHetHan) {

        
        if (maHang == null || maHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã hàng không được rỗng!");
        }

        this.maHang = maHang;

       
        setTenHang(tenHang);
        setDonGia(donGia);
        setNgaySanXuat(ngaySanXuat);
        setNgayHetHan(ngayHetHan);
    }


    

    public HangThucPham(String maHang) {

        if (maHang == null || maHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã hàng không được rỗng!");
        }

        this.maHang = maHang;

        
        this.tenHang = "xxx";
        this.donGia = 0;
        this.ngaySanXuat = LocalDate.now();
        this.ngayHetHan = this.ngaySanXuat;
    }


    

    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public double getDonGia() {
        return donGia;
    }

    public LocalDate getNgaySanXuat() {
        return ngaySanXuat;
    }

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }


    

    public void setTenHang(String tenHang) {

        if (tenHang == null || tenHang.trim().isEmpty()) {
        	throw new IllegalArgumentException("tên hàng không dược rỗng!");
        } else {
            this.tenHang = tenHang;
        }
    }


    public void setDonGia(double donGia) {

        if (donGia < 0) {
        	throw new IllegalArgumentException("đơn giá phải > 0!");
        } else {
            this.donGia = donGia;
        }
    }


    public void setNgaySanXuat(LocalDate ngaySanXuat) {

        
        if (ngaySanXuat == null || !ngaySanXuat.isBefore(LocalDate.now())) {

        	throw new IllegalArgumentException("ngày sản xuất phải ở quá khứ!");

        } else {
            this.ngaySanXuat = ngaySanXuat;
        }
    }


    public void setNgayHetHan(LocalDate ngayHetHan) {

        
        if (ngayHetHan == null || !ngayHetHan.isAfter(this.ngaySanXuat)) {

        	throw new IllegalArgumentException("ngày sản xuất phải ở tương lai!");

        } else {
            this.ngayHetHan = ngayHetHan;
        }
    }


    

    public boolean daHetHan() {

        return ngayHetHan.isBefore(LocalDate.now());
    }


    
    @Override
    public String toString() {

        DateTimeFormatter dinhDangNgay =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        DecimalFormat dinhDangGia =
                new DecimalFormat("#,##0.00");

        String ghiChu = daHetHan() ? "Hàng hết hạn" : "";

        return String.format(
                "%-10s %-15s %15sVND %15s %15s %-15s",
                maHang,
                tenHang,
                dinhDangGia.format(donGia),
                ngaySanXuat.format(dinhDangNgay),
                ngayHetHan.format(dinhDangNgay),
                ghiChu
        );
    }
}