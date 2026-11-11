package phuong;

import java.util.Scanner;

public class TestSinhVien {
	public static void main(String[] args) {


        
        SinhVien sv1 = new SinhVien(
            25678936,
            "Phan Huu Nhat",
            6.7,
            3.6
        );
        

        SinhVien sv2 = new SinhVien(
            25659931,
            "Nguyen Hieu Nghia",
            8.5,
            9.0
        );
        

        Scanner sc = new Scanner(System.in);
        System.out.println("===== NHAP THONG TIN SINH VIEN =====");

        System.out.print("Nhap ma sinh vien: ");
        int maSV = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhap ho ten: ");
        String hoTen = sc.nextLine();

        System.out.print("Nhap diem LT: ");
        double diemLT = sc.nextDouble();

        System.out.print("Nhap diem TH: ");
        double diemTH = sc.nextDouble();

        
        SinhVien sv3 = new SinhVien(
            maSV,
            hoTen,
            diemLT,
            diemTH
        );

        

        System.out.println("\n===== DANH SACH SINH VIEN =====");

        System.out.printf(
            "%-15s %-25s %-10s %-10s %-10s%n",
            "Ma SV",
            "Ho ten",
            "Diem LT",
            "Diem TH",
            "Diem TB"
        );

        System.out.println(
            "--------------------------------------------------------------------------"
        );

        System.out.println(sv1);
        System.out.println(sv2);
        System.out.println(sv3);

        sc.close();
    }
}
