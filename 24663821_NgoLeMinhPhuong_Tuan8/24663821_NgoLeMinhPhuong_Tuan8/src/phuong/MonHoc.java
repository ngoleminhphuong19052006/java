package phuong;

public enum MonHoc {
	LAP_TRINH_JAVA("Lap trinh java", 450000f),
	CO_SO_DU_LIEU("Co So Du Lieu", 450000f),
	TOAN_ROI_RAC("Toan roi rac", 400000f),
	MANG_MAY_TINH("Mang may tinh", 500000f),
	TRI_TUE_NHAN_TAO("Tri tue nhan tao", 600000f),
	KY_THUAT_PHAN_MEM("Ky thuat phan mem", 500000f),
	LAP_TRINH_WEB("Lap trinh web", 500000f),
	HE_DIEU_HANH("He dieu hanh", 420000f);
	
	
	private final String tenMon;
	private final float donGia;
	
	
	
	private MonHoc(String tenMon, float donGia) {
		this.tenMon = tenMon;
		this.donGia = donGia;
	}
	
	public String getTenMon() {
		return tenMon;
	}
	
	public float getDonGia() {
		return donGia;
	}
	
	public static MonHoc fromTenMon(String tenMon) {
		for (MonHoc mh : values())
			if (mh.tenMon.equalsIgnoreCase(tenMon))
				return mh;
		return null;
	}
	
	@Override
	public String toString() {		
		return String.format(" | %s (%,.0f VND/Tin chi)", tenMon, donGia);
	}
	

}
