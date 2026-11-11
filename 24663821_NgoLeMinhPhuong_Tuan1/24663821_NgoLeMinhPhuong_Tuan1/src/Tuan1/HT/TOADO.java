package Tuan1.HT;

public class TOADO {
	private String ten;
	private double x,y;
	
	public String getTen() {
		return ten;
	}
	
	public void setTen(String ten) {
		this.ten = ten;
	}
	
	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	public TOADO(String ten, double x, double y) {
		this.ten = ten;
		this.x = x;
		this.y= y;
				
	}
	public String toString() {
		return super.toString();
	}
}
