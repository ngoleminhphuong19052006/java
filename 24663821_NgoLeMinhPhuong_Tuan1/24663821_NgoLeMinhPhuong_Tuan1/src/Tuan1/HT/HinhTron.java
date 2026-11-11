package Tuan1.HT;

public class HinhTron {

    private double BanKinh;
    private TOADO tam;
    private final double PI = 3.1416;

    public double getBanKinh() {
        return BanKinh;
    }

    public void setBanKinh(double BanKinh) {
        this.BanKinh = BanKinh;
    }

    public TOADO getTam() {
        return tam;
    }

    public void setTam(TOADO tam) {
        this.tam = tam;
    }

    public HinhTron(TOADO tam, double BanKinh) {
        this.BanKinh = BanKinh;
        this.tam = tam;
    }

    public static void main(String[] args) {
        HinhTron h1 = new HinhTron(
            new TOADO("O", 4, 10), 7
        );

        System.out.println("Thong tin hinh tron: ");
        System.out.println("Hinh tron tam: " + h1.getTam().getTen());
    }
}