
package nguyenvanphu25656911;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static QuanLyPhongHoc ql = new QuanLyPhongHoc();

    public static void main(String[] args) {
        int chon;

        do {
            System.out.println("\n========== QUAN LY PHONG HOC ==========");
            System.out.println("1. Them phong hoc");
            System.out.println("2. Hien thi danh sach phong hoc");
            System.out.println("3. Tim phong theo ma");
            System.out.println("4. Hien thi phong dat chuan");
            System.out.println("5. Sap xep tang dan theo day nha");
            System.out.println("6. Sap xep giam dan theo dien tich");
            System.out.println("7. Sap xep tang dan theo so bong den");
            System.out.println("8. Cap nhat so may tinh");
            System.out.println("9. Xoa phong hoc");
            System.out.println("10. Dem tong so phong");
            System.out.println("11. Tim phong may tinh co 60 may");
            System.out.println("12. Them du lieu mau");
            System.out.println("0. Thoat");
            System.out.println("=======================================");

            chon = nhapInt("Nhap lua chon: ");

            switch (chon) {
                case 1:
                    themPhong();
                    break;
                case 2:
                    ql.inDanhSach(ql.getDanhSach());
                    break;
                case 3:
                    timPhong();
                    break;
                case 4:
                    ql.inDanhSach(ql.layPhongDatChuan());
                    break;
                case 5:
                    ql.sapXepTheoDayNha();
                    ql.inDanhSach(ql.getDanhSach());
                    break;
                case 6:
                    ql.sapXepTheoDienTichGiamDan();
                    ql.inDanhSach(ql.getDanhSach());
                    break;
                case 7:
                    ql.sapXepTheoSoBongDen();
                    ql.inDanhSach(ql.getDanhSach());
                    break;
                case 8:
                    capNhatSoMayTinh();
                    break;
                case 9:
                    xoaPhong();
                    break;
                case 10:
                    System.out.println("Tong so phong hoc: "
                            + ql.tongSoPhong());
                    break;
                case 11:
                    List<PhongMayTinh> ds60 =
                            ql.layPhongMayTinh60May();
                    ql.inDanhSach(ds60);
                    break;
                case 12:
                    themDuLieuMau();
                    break;
                case 0:
                    System.out.println("Ket thuc chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);

        sc.close();
    }

    public static int nhapInt(String thongBao) {
        while (true) {
            try {
                System.out.print(thongBao);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen!");
            }
        }
    }

    public static double nhapDouble(String thongBao) {
        while (true) {
            try {
                System.out.print(thongBao);
                double x = Double.parseDouble(sc.nextLine().trim());

                if (Double.isFinite(x)) {
                    return x;
                }

                System.out.println("Gia tri khong hop le!");
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so thuc!");
            }
        }
    }

    public static String nhapString(String thongBao) {
        System.out.print(thongBao);
        return sc.nextLine().trim();
    }

    public static boolean nhapBoolean(String thongBao) {
        while (true) {
            int x = nhapInt(thongBao + " (1: Co, 0: Khong): ");

            if (x == 1) return true;
            if (x == 0) return false;

            System.out.println("Chi duoc nhap 1 hoac 0!");
        }
    }

    public static void themPhong() {
        System.out.println("\n1. Phong ly thuyet");
        System.out.println("2. Phong may tinh");
        System.out.println("3. Phong thi nghiem");

        int loai = nhapInt("Chon loai phong: ");

        if (loai < 1 || loai > 3) {
            System.out.println("Loai phong khong hop le!");
            return;
        }

        String ma = nhapString("Nhap ma phong: ");

        if (ma.isEmpty()) {
            System.out.println("Ma phong khong duoc de trong!");
            return;
        }

        if (ql.timPhong(ma) != null) {
            System.out.println("Ma phong da ton tai!");
            return;
        }

        String day = nhapString("Nhap day nha: ");
        double dienTich = nhapDouble("Nhap dien tich: ");
        int den = nhapInt("Nhap so bong den: ");

        if (day.isEmpty() || dienTich <= 0 || den < 0) {
            System.out.println("Thong tin khong hop le!");
            return;
        }

        PhongHoc p;

        switch (loai) {
            case 1:
                boolean mayChieu =
                        nhapBoolean("Phong co may chieu khong?");

                p = new PhongLyThuyet(
                        ma, day, dienTich, den, mayChieu);
                break;

            case 2:
                int soMay = nhapInt("Nhap so may tinh: ");

                if (soMay < 0) {
                    System.out.println("So may tinh khong hop le!");
                    return;
                }

                p = new PhongMayTinh(
                        ma, day, dienTich, den, soMay);
                break;

            case 3:
                String chuyenNganh =
                        nhapString("Nhap chuyen nganh: ");
                int sucChua = nhapInt("Nhap suc chua: ");

                if (chuyenNganh.isEmpty() || sucChua < 0) {
                    System.out.println("Thong tin khong hop le!");
                    return;
                }

                boolean bonRua =
                        nhapBoolean("Phong co bon rua khong?");

                p = new PhongThiNghiem(
                        ma, day, dienTich, den,
                        chuyenNganh, sucChua, bonRua);
                break;

            default:
                return;
        }

        if (ql.themPhong(p)) {
            System.out.println("Them phong thanh cong!");
        } else {
            System.out.println("Them phong that bai!");
        }
    }

    public static void timPhong() {
        String ma = nhapString("Nhap ma phong can tim: ");
        PhongHoc p = ql.timPhong(ma);

        if (p == null) {
            System.out.println("Khong tim thay phong!");
        } else {
            System.out.println(p);
            System.out.println("Dat chuan: "
                    + (p.datChuan() ? "Co" : "Khong"));
        }
    }

    public static void capNhatSoMayTinh() {
        String ma = nhapString(
                "Nhap ma phong may tinh can cap nhat: ");
        int soMay = nhapInt("Nhap so may tinh moi: ");

        if (soMay < 0) {
            System.out.println("So may tinh khong hop le!");
            return;
        }

        if (ql.capNhatSoMayTinh(ma, soMay)) {
            System.out.println("Cap nhat thanh cong!");
            System.out.println(ql.timPhong(ma));
        } else {
            System.out.println(
                    "Khong tim thay phong hoac day khong phai phong may tinh!");
        }
    }

    public static void xoaPhong() {
        String ma = nhapString("Nhap ma phong can xoa: ");
        PhongHoc p = ql.timPhong(ma);

        if (p == null) {
            System.out.println("Khong tim thay phong!");
            return;
        }

        System.out.println("Thong tin phong can xoa:");
        System.out.println(p);

        boolean xacNhan = nhapBoolean(
                "Ban co chac chan muon xoa phong nay khong?");

        if (!xacNhan) {
            System.out.println("Da huy thao tac xoa!");
            return;
        }

        if (ql.xoaPhong(ma)) {
            System.out.println("Xoa phong thanh cong!");
        } else {
            System.out.println("Xoa phong that bai!");
        }
    }

    public static void themDuLieuMau() {
        boolean ok = true;

        ok &= ql.themPhong(new PhongLyThuyet(
                "LT01", "A", 60, 6, true));

        ok &= ql.themPhong(new PhongLyThuyet(
                "LT02", "B", 80, 8, false));

        ok &= ql.themPhong(new PhongMayTinh(
                "MT01", "A", 100, 10, 60));

        ok &= ql.themPhong(new PhongMayTinh(
                "MT02", "C", 75, 8, 40));

        ok &= ql.themPhong(new PhongThiNghiem(
                "TN01", "B", 90, 9,
                "Hoa hoc", 30, true));

        ok &= ql.themPhong(new PhongThiNghiem(
                "TN02", "C", 50, 4,
                "Sinh hoc", 20, false));

        if (ok) {
            System.out.println("Da them du lieu mau!");
        } else {
            System.out.println("Mot so ma phong da ton tai!");
        }
    }
}

