package quanlysieuthimini;

import java.util.Scanner;

public class NhaCungCap {

    static Scanner sc = new Scanner(System.in);
    private String manhacungcap;
    private String tennhacungcap;
    private String diachinhacungcap;
    private String sdtnhacungcap;

    public NhaCungCap() {
    }

    public NhaCungCap(String manhacungcap, String tennhacungcap, String diachinhacungcap, String sdtnhacungcap) {
        this.manhacungcap = manhacungcap;
        this.tennhacungcap = tennhacungcap;
        this.diachinhacungcap = diachinhacungcap;
        this.sdtnhacungcap = sdtnhacungcap;
    }

    public String getManhacungcap() {
        return manhacungcap;
    }

    public void setManhacungcap(String manhacungcap) {
        this.manhacungcap = manhacungcap;
    }

    public String getTennhacungcap() {
        return tennhacungcap;
    }

    public void setTennhacungcap(String tennhacungcap) {
        this.tennhacungcap = tennhacungcap;
    }

    public String getDiachinhacungcap() {
        return diachinhacungcap;
    }

    public void setDiachinhacungcap(String diachinhacungcap) {
        this.diachinhacungcap = diachinhacungcap;
    }

    public String getSdtnhacungcap() {
        return sdtnhacungcap;
    }

    public void setSdtnhacungcap(String sdtnhacungcap) {
        this.sdtnhacungcap = sdtnhacungcap;
    }

    @Override
    public String toString() {
        return "NhaCungCap{" + "manhacungcap=" + manhacungcap + ", tennhacungcap=" + tennhacungcap + ", diachinhacungcap=" + diachinhacungcap + ", sdtnhacungcap=" + sdtnhacungcap + '}';
    }

    public void nhap() {
        System.out.println("Nhap Thong Tin Nha Cung Cap: ");
        do {
            System.out.println("Nhap ma nha cung cap (gom 5 so)(vd:30001,...):");
            manhacungcap = sc.nextLine();
        } while (!Check.KtMa(this.manhacungcap) || DsNhaCungCap.KtMaNccTrongDs(this.manhacungcap));
        do {
            System.out.println("Nhap ten nha cung cap:");
            tennhacungcap = sc.nextLine();
        } while (!Check.KtHoTen(this.tennhacungcap));
        do {
            System.out.println("Nhap dia chi nha cung cap (hon 20 ki tu):");
            diachinhacungcap = sc.nextLine();
        } while (!Check.KtDiaChi(this.diachinhacungcap));
        do {
            System.out.println("Nhap so dien thoai nha cung cap:");
            sdtnhacungcap = sc.nextLine();
        } while (!Check.KtSodt(this.sdtnhacungcap));
    }

    public void xuat() {
        System.out.printf("\n%-15s | %20s | %50s | %15s |", this.manhacungcap, this.tennhacungcap, this.diachinhacungcap, this.sdtnhacungcap);
        //MaNcc | TenNcc | Dia Chi | Sdt |
    }

    public String nhacungcaptrongfile() {
        return this.manhacungcap + "#" + this.tennhacungcap + "#" + this.diachinhacungcap + "#" + this.sdtnhacungcap + "\n";
    }

    public static void main(String[] args) {
        NhaCungCap a = new NhaCungCap();
        a.nhap();
        a.xuat();
    }
}
