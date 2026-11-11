package phuong;

public class DANHSACHCONGNHAN {
    private CONGNHAN[] ds;
    private int count;

    public DANHSACHCONGNHAN(int n) {
        this.ds = new CONGNHAN[n];
        this.count = 0;
    }

    public boolean themCongNhan(CONGNHAN cn) {
        if (count < ds.length) {
            ds[count] = cn;
            count++;
            return true;
        }
        return false;
    }

    public void xuatDanhSach() {
        for (int i = 0; i < count; i++) {
            System.out.println(ds[i]);
        }
    }

    public int soCN() {
        return count;
    }

    public void xuatCongNhanTren200SP() {
        for (int i = 0; i < count; i++) {
            if (ds[i].getmSoSP() > 200) {
                System.out.println(ds[i]);
            }
        }
    }

    public void sapxepGiam() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (ds[i].getmSoSP() < ds[j].getmSoSP()) {
                    CONGNHAN temp = ds[i];
                    ds[i] = ds[j];
                    ds[j] = temp;
                }
            }
        }
    }
}
