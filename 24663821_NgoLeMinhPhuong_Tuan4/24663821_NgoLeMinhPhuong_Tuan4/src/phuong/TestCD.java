package phuong;
import java.util.Scanner;
public class TestCD {
	public static void menu() {
		System.out.println("\n========= MENU QUAN LY CD =========");
		System.out.println("1. nhap CD vao tu ban phim");
		System.out.println("2. xoa CD theo ma");
		System.out.println("3. cap nhat gia CD theo ma");
		System.out.println("4. in danh sach CD");
		System.out.println("5. tinh tong thanh tien");
		System.out.println("===================================");
		System.out.println("chon chuc nang : ");
	    
	}
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);

        
        System.out.print("Nhap so luong CD toi da ban dau: ");
        int n = Integer.parseInt(sc.nextLine());
        ListCD ds = new ListCD(n);

       
        int chon;
        do {
            menu();
            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                chon = -1;   
            }

            switch (chon) {
                case 1:
                    ds.nhapCD(sc);
                    break;
                case 2:
                    ds.xoaCD(sc);
                    break;
                case 3:
                    ds.capNhatGiaCD(sc);
                    break;
                case 4:
                    ds.inDS();
                    break;
                case 5:
                    System.out.printf("Tong thanh tien: %.2f%n",
                                        ds.tongThanhTien());
                    break;
                case 0:
                    System.out.println("Ket thuc chuong trinh.");
                    break;
                default:
                    System.out.println("Chuc nang khong hop le!");
            }
        } while (chon != 0);

        sc.close();
    }
		
		
	
	

}
	


