package phuong;

import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class MAIN {

    public static void main(String[] args) {

        

        HangThucPham h1 = new HangThucPham(
                "001",
                "Gạo",
                100000,
                LocalDate.of(2018, 10, 7),
                LocalDate.of(2019, 10, 7)
        );


        HangThucPham h2 = new HangThucPham(
                "002",
                "Mì",
                5000,
                LocalDate.of(2018, 3, 1),
                LocalDate.of(2018, 9, 1)
        );


        
        HangThucPham h3 = new HangThucPham(
                "003",
                "Nước",
                10000,
                LocalDate.of(2017, 3, 1),
                LocalDate.of(2018, 3, 1)
        );


        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 

        System.out.println("=== Nhập thông tin h4 ===");

        System.out.print("Nhập mã hàng: ");
        String maHang = sc.nextLine();

        System.out.print("Nhập tên hàng: ");
        String tenHang = sc.nextLine();

        System.out.print("Nhập đơn giá: ");
        double donGia = sc.nextDouble();

        System.out.print("Nhập ngày sản xuất (dd-MM-yyyy): ");
        LocalDate ngaySanXuat = LocalDate.parse(sc.next(), formatter);

        System.out.print("Nhập ngày hết hạn (dd-MM-yyyy): ");
        LocalDate ngayHetHan = LocalDate.parse(sc.next(), formatter);

        
        HangThucPham h4 = new HangThucPham(
                maHang,
                tenHang,
                donGia,
                ngaySanXuat,
                ngayHetHan
        );
        
        
        System.out.printf(
                "%-10s %-15s %15s %-15s %-15s %-15s%n",
                "Mã_Hàng",
                "Tên_Hàng",
                "Đơn_Giá",
                "Ngày_Sản_Xuất",
                "Ngày_Hết_Hạn",
                "Ghi_Chú"
        );


        
        
        System.out.println(
                "--------------------------------------------------------------------------"
        );


        

        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h3);
        System.out.println(h4);
        
        sc.close();
    }
}