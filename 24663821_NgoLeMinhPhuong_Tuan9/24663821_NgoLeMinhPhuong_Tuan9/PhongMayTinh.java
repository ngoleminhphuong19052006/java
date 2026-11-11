package nguyenvanphu25656911;

public class PhongMayTinh extends PhongHoc {
    private int soMayTinh;

    public PhongMayTinh(String maPhong, String dayNha,
                        double dienTich, int soBongDen,
                        int soMayTinh) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.soMayTinh = soMayTinh;
    }

    public int getSoMayTinh() {
        return soMayTinh;
    }

    public void setSoMayTinh(int soMayTinh) {
        this.soMayTinh = soMayTinh;
    }

    @Override
    public boolean datChuan() {
        return duAnhSang()
            && dienTich >= 1.5 * soMayTinh;
    }

    @Override
    public String getLoaiPhong() {
        return "Phong may tinh";
    }

    @Override
    public String toString() {
        return super.toString()
            + " | So may tinh: " + soMayTinh;
    }
}