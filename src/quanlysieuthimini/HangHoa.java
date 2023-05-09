package quanlysieuthimini;

import java.util.Scanner;

public class HangHoa {

    static Scanner sc = new Scanner(System.in);
    private String mahang;
    private String tenhang;
    private double dongia;

    public HangHoa() {

    }

    public HangHoa(String mahang, String tenhang, double dongia) {
        this.mahang = mahang;
        this.tenhang = tenhang;
        this.dongia = dongia;
    }

    public String getMaHang() {
        return mahang;
    }

    public String getTenHang() {
        return tenhang;
    }

    public double getDongia() {
        return dongia;
    }

    public void setMaHang(String mahang) {
        this.mahang = mahang;
    }

    public void setTenHang(String tenhang) {
        this.tenhang = tenhang;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public boolean KtTenHang(String tenhang) {
        if (tenhang.length() == 0) {
            return false;
        }
        return true;
    }

    public boolean KtDongia(String gia) {
        for(int i=0;i<gia.length();i++){
            if(gia.charAt(i) < '0' || gia.charAt(i) > '9')
                return false;
        }
        double giatri = Double.parseDouble(gia);
        if (giatri <= 0) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HangHoa{" + "mahang=" + mahang + ", tenhang=" + tenhang + ", dongia=" + dongia + '}';
    }

    public void nhap() {
        System.out.println("Nhap thong tin hang hoa:");
        do {
            System.out.println("nhap vao ma hang hoa (gom 5 so)(vd:20001,...): ");
            this.mahang = sc.nextLine();
        } while (!Check.KtMa(this.mahang) || DsHangHoa.KtMaHangTrongDs(this.mahang));
        do {
            System.out.println("Nhap ten hang hoa: ");
            tenhang = sc.nextLine();
        } while (!KtTenHang(this.tenhang));
        String x;
        do {
            System.out.println("Nhap don gia (so thuc > 0):");
            x = sc.nextLine();
        } while (!KtDongia(x));
        this.dongia = Double.parseDouble(x);
    }

    public void xuat() {
        System.out.printf("\n|%-20s| %30s | %15.2f |", this.mahang, this.tenhang, this.dongia);
    }

    public String hanghoatrongfile() {
        return this.mahang + "#" + this.tenhang + "#" + this.dongia + "\n";
    }

    public static void main(String[] args) {
        HangHoa a = new HangHoa();
        a.nhap();
        a.xuat();
    }
}
