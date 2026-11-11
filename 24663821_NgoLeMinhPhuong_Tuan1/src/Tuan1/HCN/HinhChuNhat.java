
package Tuan1.HCN;

public class HinhChuNhat {
    private double chieuDai;
    private double chieuRong;
      
    public double getChieuDai() {
        return chieuDai;
    }
    
    public void setChieuDai(double cD) throws Exception {
        if(cD > 0) {
            this.chieuDai = cD;
        } else {
            throw new Exception("Chieu dai phai > 0");
        }  
    }
      
    public double getChieuRong() {
        return chieuRong;
    }
    
    public void setChieuRong(double chieuRong) throws Exception {
        if(chieuRong > 0) {
            this.chieuRong = chieuRong;
        } else {
            throw new Exception("Chieu rong phai > 0");
        }
    }
      
    
    public HinhChuNhat(double cD, double chieuRong) throws Exception {
        setChieuDai(cD);
        setChieuRong(chieuRong);
    }
      
    public HinhChuNhat() {
        
    }
      
    public double tinhDT() {
        return this.chieuDai * this.chieuRong;
    }
    
    public double tinhCV() {
        return (this.chieuDai + this.chieuRong) * 2;
    }
      
    public static void main(String[] args) throws Exception {
        HinhChuNhat h1 = new HinhChuNhat(3, 2);
        
        
        System.out.println("Chieu dai hinh chu nhat: " + h1.getChieuDai());
        System.out.println("Chieu rong hinh chu nhat: " + h1.getChieuRong());
        System.out.println("Dien tich hinh chu nhat: " + h1.tinhDT());
        System.out.println("Chu vi hinh chu nhat: " + h1.tinhCV());
    }
}