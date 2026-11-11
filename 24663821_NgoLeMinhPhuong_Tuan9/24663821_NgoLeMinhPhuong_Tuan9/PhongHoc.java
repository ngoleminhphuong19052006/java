package nguyenvanphu25656911;

public abstract class PhongHoc {
    protected String maPhong;
    protected String dayNha;
    protected double dienTich;
    protected int soBongDen;

    public PhongHoc(String maPhong, String dayNha,
                    double dienTich, int soBongDen) {
        this.maPhong = maPhong;
        this.dayNha = dayNha;
        this.dienTich = dienTich;
        this.soBongDen = soBongDen;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public String getDayNha() {
        return dayNha;
    }

    public double getDienTich() {
        return dienTich;
    }

    public int getSoBongDen() {
        return soBongDen;
    }

    public void setSoBongDen(int soBongDen) {
        this.soBongDen = soBongDen;
    }

    
    public boolean duAnhSang() {
        return soBongDen >= Math.ceil(dienTich / 10.0);
    }

    
    public abstract boolean datChuan();

    public abstract String getLoaiPhong();

    @Override
    public String toString() {
        return String.format(
            "Loai: %s | Ma: %s | Day nha: %s"
            + " | Dien tich: %.2f m2 | Bong den: %d",
            getLoaiPhong(), maPhong, dayNha,
            dienTich, soBongDen
        );
    }
}
