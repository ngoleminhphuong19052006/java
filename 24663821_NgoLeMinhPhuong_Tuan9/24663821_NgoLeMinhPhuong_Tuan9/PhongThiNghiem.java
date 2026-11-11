package nguyenvanphu25656911;

public class PhongThiNghiem extends PhongHoc {
    private String chuyenNganh;
    private int sucChua;
    private boolean coBonRua;

    public PhongThiNghiem(String maPhong, String dayNha,
                          double dienTich, int soBongDen,
                          String chuyenNganh, int sucChua,
                          boolean coBonRua) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.chuyenNganh = chuyenNganh;
        this.sucChua = sucChua;
        this.coBonRua = coBonRua;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public int getSucChua() {
        return sucChua;
    }

    public boolean isCoBonRua() {
        return coBonRua;
    }

    public void setCoBonRua(boolean coBonRua) {
        this.coBonRua = coBonRua;
    }

    @Override
    public boolean datChuan() {
        return duAnhSang() && coBonRua;
    }

    @Override
    public String getLoaiPhong() {
        return "Phong thi nghiem";
    }

    @Override
    public String toString() {
        return super.toString()
            + " | Chuyen nganh: " + chuyenNganh
            + " | Suc chua: " + sucChua
            + " | Bon rua: "
            + (coBonRua ? "Co" : "Khong");
    }
}
