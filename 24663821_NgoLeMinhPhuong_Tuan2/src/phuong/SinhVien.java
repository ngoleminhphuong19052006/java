package phuong;

public class SinhVien {
	private int maSinhVien;
    private String hoTen;
    private double diemLT;
    private double diemTH;

    
    public SinhVien() {
        this.maSinhVien = 0;
        this.hoTen = "";
        this.diemLT = 0.0;
        this.diemTH = 0.0;
    }

   
    public SinhVien(int maSinhVien, String hoTen,
                    double diemLT, double diemTH) {

        setMaSinhVien(maSinhVien);
        setHoTen(hoTen);
        setDiemLT(diemLT);
        setDiemTH(diemTH);
    }

    

    public int getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public double getDiemLT() {
		return diemLT;
	}

	public void setDiemLT(double diemLT) {
		this.diemLT = diemLT;
	}

	public double getDiemTH() {
		return diemTH;
	}

	public void setDiemTH(double diemTH) {
		this.diemTH = diemTH;
	}

	
    public double tinhDiemTrungBinh() {
        return (diemLT + diemTH) / 2;
    }


    public String toString() {
        return String.format(
            "%-15d %-25s %-10.2f %-10.2f %-10.2f",
            maSinhVien,
            hoTen,
            diemLT,
            diemTH,
            tinhDiemTrungBinh()
        );
    }
}
