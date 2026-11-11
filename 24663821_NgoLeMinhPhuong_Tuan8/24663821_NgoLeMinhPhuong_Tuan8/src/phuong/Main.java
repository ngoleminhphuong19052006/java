package phuong;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static IFSinhVien ql = new QuanLySinhVien();
	static DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static void main(String[] args) {
		ql.them(new SinhVienChinhQui("SV01", "Nguyen Van An", LocalDate.of(2005, 5, 12), "DHKTPM19A", 3, MonHoc.LAP_TRINH_JAVA, "Phong H4.01"));
        ql.them(new SinhVienTuXa("SV02", "Tran Thi Binh", LocalDate.of(2004, 8, 20), "DHKTPM18B", 4, MonHoc.CO_SO_DU_LIEU, "Zoom"));
        ql.them(new SinhVienChinhQui("SV03", "Le Hoang Cuong", LocalDate.of(2005, 1, 15), "DHKTPM19A", 3, MonHoc.TRI_TUE_NHAN_TAO, "Phong A2.03"));
        ql.them(new SinhVienTuXa("SV04", "Pham Minh Dung", LocalDate.of(2003, 11, 30), "DHHTTT17A", 3, MonHoc.LAP_TRINH_WEB, "Google Meet"));
		
        int chon = -1;
        do {
        	System.out.println("\n================= MENU QUẢN LÝ SINH VIÊN =================");
            System.out.println("1. Xem toàn bộ danh sách sinh viên");
            System.out.println("2. Thêm sinh viên mới");
            System.out.println("3. Tìm kiếm sinh viên theo mã");
            System.out.println("4. Tìm kiếm sinh viên theo loại (Chính quy / Từ xa)");
            System.out.println("5. Tìm kiếm sinh viên theo tên môn học");
            System.out.println("6. Sửa thông tin sinh viên theo mã");
            System.out.println("7. Xóa sinh viên theo mã");
            System.out.println("8. Thống kê tổng số lượng và tổng thành tiền");
            System.out.println("9. Sắp xếp danh sách theo tên giảm dần (Z-A)");
            System.out.println("10. Sắp xếp danh sách theo thành tiền giảm dần");
            System.out.println("0. Thoát chương trình");
            
            System.out.print("Nhập lựa chọn của bạn: ");
            try {
            	chon = Integer.parseInt(sc.nextLine());
            }
            catch(NumberFormatException e) {
            	System.out.println("phải là số");
            }
            
            switch(chon) {
            
	            case 1:
					System.out.println("\n--- DANH SÁCH SINH VIÊN ---");
					inDanhSach(ql.layTatCa());
					break;
					
				case 2:
					System.out.println("\n--- THÊM SINH VIÊN MỚI ---");
					System.out.print("Nhập loại sinh viên muốn thêm (1: Chính quy, 2: Từ xa): ");
					int loaiSV = Integer.parseInt(sc.nextLine());
					
					System.out.print("Nhập mã SV: ");
					String maSV = sc.nextLine();
					System.out.print("Nhập họ tên: ");
					String hoTen = sc.nextLine();
					System.out.print("Nhập lớp: ");
					String lop = sc.nextLine();
					System.out.print("Nhập số tín chỉ: ");
					int soTC = Integer.parseInt(sc.nextLine());
					
					System.out.println("Chọn môn học (1. LAP_TRINH_JAVA, 2. CO_SO_DU_LIEU, 3. LAP_TRINH_WEB, 4. TRI_TUE_NHAN_TAO): ");
					int chonMon = Integer.parseInt(sc.nextLine());
					MonHoc mon = null; 
					
					if (chonMon == 1) {
						mon = MonHoc.LAP_TRINH_JAVA;
					} 
					else if (chonMon == 2) {
						mon = MonHoc.CO_SO_DU_LIEU;
					} 
					else if (chonMon == 3) {
						mon = MonHoc.LAP_TRINH_WEB;
					} 
					else if (chonMon == 4) {
						mon = MonHoc.TRI_TUE_NHAN_TAO;
					} 
					else {
						System.out.println("-> Lựa chọn không hợp lệ, hệ thống tự động gán môn mặc định là LAP_TRINH_JAVA.");
						mon = MonHoc.LAP_TRINH_JAVA;
					}
					
					boolean added = false;
					if (loaiSV == 1) {
						System.out.print("Nhập phòng học: ");
						String phongHoc = sc.nextLine();
						added = ql.them(new SinhVienChinhQui(maSV, hoTen, LocalDate.of(2005, 1, 1), lop, soTC, mon, phongHoc));
					} 
					else {
						System.out.print("Nhập kênh liên lạc/Zoom: ");
						String kenh = sc.nextLine();
						added = ql.them(new SinhVienTuXa(maSV, hoTen, LocalDate.of(2005, 1, 1), lop, soTC, mon, kenh));
					}
					
					if (added) {
						System.out.println("-> Thêm sinh viên thành công!");
						System.out.println("\n--- DANH SÁCH SAU KHI THÊM ---");
						inDanhSach(ql.layTatCa());
					} 
					else {
						System.out.println("-> Thêm thất bại (Trùng mã sinh viên)!");
					}
					break;
					
				case 3:
					System.out.print("Nhập mã sinh viên cần tìm: ");
					String maTim = sc.nextLine();
					SinhVien svTim = ql.timTheoMa(maTim);
					if (svTim != null) {
						System.out.println("-> Tìm thấy:\n" + svTim);
					} 
					else {
						System.out.println("-> Không tìm thấy sinh viên có mã: " + maTim);
					}
					
					break;
					
				case 4:
				
					System.out.print("Nhập từ khóa loại (Ví dụ: ChinhQui hoặc TuXa): ");
					String tuKhoaLoai = sc.nextLine();
					inDanhSach(ql.timTheoLoai(tuKhoaLoai));
					break;
					
				case 5:
				
					System.out.print("Nhập tên môn học: ");
					String tuKhoaMon = sc.nextLine();
					inDanhSach(ql.timTheoMon(tuKhoaMon));
					break;
					
				
					
				case 6:
					System.out.println("\n--- SỬA THÔNG TIN SINH VIÊN ---");
					System.out.print("Nhập mã sinh viên cần sửa: ");
					String maSua = sc.nextLine();
					
					SinhVien svCu = ql.timTheoMa(maSua);
					if (svCu == null) {
						System.out.println("-> Không tìm thấy sinh viên cần sửa!");
					} 
					else {
						System.out.print("Nhập họ tên mới: ");
						String tenMoi = sc.nextLine();
						System.out.print("Nhập lớp mới: ");
						String lopMoi = sc.nextLine();
						
						SinhVien svCapNhat;
						
						if (svCu instanceof SinhVienChinhQui) {
							SinhVienChinhQui svCQ = (SinhVienChinhQui) svCu;
							
							svCapNhat = new SinhVienChinhQui(maSua, tenMoi, svCQ.getNgaySinh(), lopMoi, svCQ.getSotinChi(), svCQ.getMonHoc(), svCQ.getHocTrucTiep());
						} 
						else {
							SinhVienTuXa svTX = (SinhVienTuXa) svCu;
							
							svCapNhat = new SinhVienTuXa(maSua, tenMoi, svTX.getNgaySinh(), lopMoi, svTX.getSotinChi(), svTX.getMonHoc(), svTX.getNenTang());
						}
						
						if (ql.sua(maSua, svCapNhat)) {
							System.out.println("-> Cập nhật thông tin thành công!");
							System.out.println("\n--- DANH SÁCH SAU KHI SỬA ---");
							inDanhSach(ql.layTatCa());
						} 
						
						else {
							System.out.println("-> Cập nhật thất bại!");
						}
					}
					break;
				
				
					
				case 7:
					
					System.out.print("Nhập mã sinh viên cần xóa: ");
					String maXoa = sc.nextLine();
					if (ql.xoa(maXoa)) {
						System.out.println("-> Xóa thành công sinh viên mã: " + maXoa);
					} else {
						System.out.println("-> Xóa thất bại, không tìm thấy mã sinh viên này!");
					}
					break;
					
				case 8:
					System.out.println("\n--- THỐNG KÊ ---");
					System.out.println("Tổng số lượng sinh viên: " + ql.tongSoLuong());
					System.out.printf("Tổng thành tiền học phí: %,.0f VND\n", ql.tongThanhTien());
					break;
					
				case 9:
					System.out.println("\n--- SẮP XẾP THEO TÊN GIẢM DẦN (Z-A) ---");
					inDanhSach(ql.sapXepTheoTen());
					break;
					
				case 10:
					System.out.println("\n--- SẮP XẾP THEO THÀNH TIỀN GIẢM DẦN ---");
					inDanhSach(ql.sapXepTheoThanhTienGiamDan());
					break;
            
                case 0:
            	    System.out.println("cảm ơn vì đã sử dụng chương trình!");
            	    break;
            	    
                default:
                	System.out.println("Lựa chọn không hợp lệ!");
    
            }
            
        }
		while(chon != 0);
        
        sc.close();
		
		
	}

	public static void inDanhSach(List<SinhVien> danhSach) {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách trống!");
        }
        else {
            for (SinhVien sv : danhSach) {
                System.out.println(sv);
            }
        }
    }
	
	
}





//public class Main {
//public static void main(String[] args) {
//	IFSinhVien ql = new QuanLySinhVien();
//
//	// 1. Khởi tạo và thêm các sinh viên ban đầu
//	System.out.println("=== 1. KHỞI TẠO VÀ THÊM CÁC SINH VIÊN BAN ĐẦU ===");
//	ql.them(new SinhVienChinhQui("SV01", "Nguyen Van An", LocalDate.of(2005, 5, 12), "DHKTPM19A", 3, MonHoc.LAP_TRINH_JAVA, "Phong H4.01"));
//	ql.them(new SinhVienTuXa("SV02", "Tran Thi Binh", LocalDate.of(2004, 8, 20), "DHKTPM18B", 4, MonHoc.CO_SO_DU_LIEU, "Zoom"));
//	ql.them(new SinhVienChinhQui("SV03", "Le Hoang Cuong", LocalDate.of(2005, 1, 15), "DHKTPM19A", 3, MonHoc.TRI_TUE_NHAN_TAO, "Phong A2.03"));
//	ql.them(new SinhVienTuXa("SV04", "Pham Minh Dung", LocalDate.of(2003, 11, 30), "DHHTTT17A", 3, MonHoc.LAP_TRINH_WEB, "Google Meet"));
//	
//	System.out.println("\n--- TOÀN BỘ DANH SÁCH SINH VIÊN ---");
//	inDanhSach(ql.layTatCa());
//
//	// 2. Thêm sinh viên mới
//	System.out.println("\n=== 2. THÊM SINH VIÊN MỚI (SV05) ===");
//	boolean added = ql.them(new SinhVienChinhQui("SV05", "Hoang Thi Em", LocalDate.of(2005, 3, 10), "DHKTPM19B", 3, MonHoc.LAP_TRINH_JAVA, "Phong B1.02"));
//	System.out.println("-> Thêm thành công? " + added);
//	inDanhSach(ql.layTatCa());
//
//	// 3. Tìm kiếm sinh viên theo mã
//	System.out.println("\n=== 3. TÌM KIẾM SINH VIÊN THEO MÃ (SV02) ===");
//	SinhVien svTim = ql.timTheoMa("SV02");
//	if (svTim != null) {
//		System.out.println("-> Tìm thấy:\n" + svTim);
//	} else {
//		System.out.println("-> Không tìm thấy!");
//	}
//
//	// 4. Tìm kiếm sinh viên theo loại
//	System.out.println("\n=== 4. TÌM KIẾM SINH VIÊN THEO LOẠI (ChinhQui) ===");
//	inDanhSach(ql.timTheoLoai("ChinhQui"));
//
//	// 5. Tìm kiếm sinh viên theo tên môn học
//	System.out.println("\n=== 5. TÌM KIẾM SINH VIÊN THEO MÔN HỌC (LAP_TRINH_JAVA) ===");
//	inDanhSach(ql.timTheoMon("LAP_TRINH_JAVA"));
//
//	// 6. Sửa thông tin sinh viên theo mã
//	System.out.println("\n=== 6. SỬA THÔNG TIN SINH VIÊN (SV01) ===");
//  SinhVien svMoi = new SinhVienChinhQuy("SV01", "Nguyen Van phu(da sua)", LocalDate.of(2005, 5, 12), "DHKTPM19A", 3, MonHoc.LAP_TRINH_JAVA, "Phong H4.01")
//  boolean kqsua = ql.sua("SV01", svMoi);
//  if([kqsua){
//     indanhsach(ql.laytatca());
//  }


//	SinhVien svCu = ql.timTheoMa("SV01");
//	if (svCu != null && svCu instanceof SinhVienChinhQui) {
//		SinhVienChinhQui svCQ = (SinhVienChinhQui) svCu;
//		SinhVien svCapNhat = new SinhVienChinhQui("SV01", "Nguyen Van An (Updated)", svCQ.getNgaySinh(), "DHKTPM19A-VIP", svCQ.getSotinChi(), svCQ.getMonHoc(), "Phong H4.02");
//		boolean updated = ql.sua("SV01", svCapNhat);
//		System.out.println("-> Cập nhật thành công? " + updated);
//		inDanhSach(ql.layTatCa());
//	}
//
//	// 7. Xóa sinh viên theo mã
//	System.out.println("\n=== 7. XÓA SINH VIÊN THEO MÃ (SV04) ===");
//	boolean deleted = ql.xoa("SV04");
//	System.out.println("-> Xóa thành công? " + deleted);
//	inDanhSach(ql.layTatCa());
//
//	// 8. Thống kê tổng số lượng và tổng thành tiền
//	System.out.println("\n=== 8. THỐNG KÊ ===");
//	System.out.println("Tổng số lượng sinh viên: " + ql.tongSoLuong());
//	System.out.printf("Tổng thành tiền học phí: %,.0f VND\n", ql.tongThanhTien());
//
//	// 9. Sắp xếp danh sách theo tên giảm dần (Z-A)
//	System.out.println("\n=== 9. SẮP XẾP THEO TÊN GIẢM DẦN (Z-A) ===");
//	inDanhSach(ql.sapXepTheoTen());
//
//	// 10. Sắp xếp danh sách theo thành tiền giảm dần
//	System.out.println("\n=== 10. SẮP XẾP THEO THÀNH TIỀN GIẢM DẦN ===");
//	inDanhSach(ql.sapXepTheoThanhTienGiamDan());
//}
//
//public static void inDanhSach(List<SinhVien> danhSach) {
//	if (danhSach.isEmpty()) {
//		System.out.println("Danh sách trống!");
//	} else {
//		for (SinhVien sv : danhSach) {
//			System.out.println(sv);
//		}
//	}
//}
//}