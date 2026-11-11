package phuong;

import java.util.Scanner;

public class MAIN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        System.out.print("Nhập số lượng công nhân muốn thêm: ");
        int n = sc.nextInt();
        sc.nextLine();

        
        DANHSACHCONGNHAN ds = new DANHSACHCONGNHAN(n);

       
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhập thông tin công nhân thứ " + (i + 1) + " ---");
            System.out.print("Mã công nhân: ");
            String ma = sc.nextLine();
            System.out.print("Họ công nhân: ");
            String ho = sc.nextLine();
            System.out.print("Tên công nhân: ");
            String ten = sc.nextLine();
            System.out.print("Số sản phẩm: ");
            int soSP = sc.nextInt();
            sc.nextLine();

            CONGNHAN cn = new CONGNHAN(ma, ho, ten, soSP);
            ds.themCongNhan(cn);
        }

        System.out.println("\n================ DANH SÁCH CÔNG NHÂN ================");
        ds.xuatDanhSach();

        System.out.println("\nTổng số công nhân hiện có: " + ds.soCN());

        System.out.println("\n=========== CÔNG NHÂN LÀM TRÊN 200 SẢN PHẨM ===========");
        ds.xuatCongNhanTren200SP();

        System.out.println("\n======== DANH SÁCH SẮP XẾP GIẢM DẦN THEO SỐ SP ========");
        ds.sapxepGiam();
        ds.xuatDanhSach();

        sc.close();
    }
}

