package quanlysieuthimini;

import java.util.Scanner;

public class ChuyenKhoan {

    public Scanner sc = new Scanner(System.in);
    private String sotaikhoan;
    private String tennganhang;
    private String chutaikhoan;

    public ChuyenKhoan() {
    }

    public ChuyenKhoan(String sotaikhoan, String tennganhang, String chutaikhoan) {
        this.sotaikhoan = sotaikhoan;
        this.tennganhang = tennganhang;
        this.chutaikhoan = chutaikhoan;
    }

    public String getSotaikhoan() {
        return sotaikhoan;
    }

    public void setSotaikhoan(String sotaikhoan) {
        this.sotaikhoan = sotaikhoan;
    }

    public String getTennganhang() {
        return tennganhang;
    }

    public void setTennganhang(String tennganhang) {
        this.tennganhang = tennganhang;
    }

    public String getChutaikhoan() {
        return chutaikhoan;
    }

    public void setChutaikhoan(String chutaikhoan) {
        this.chutaikhoan = chutaikhoan;
    }

    @Override
    public String toString() {
        return "SoTaiKhoan=" + sotaikhoan + ", TenNganHang=" + tennganhang + ", ChuTaiKhoan=" + chutaikhoan + '|';
    }

    public boolean KtSoTaiKhoan(String stk) {
        if (stk.length() <= 0 || stk.length() > 20) {
            return false;
        }
        return true;
    }

    public boolean KtTenNganHang(String tennganhang) {
        if (tennganhang.length() <= 0) {
            return false;
        }
        return tennganhang.contains("Bank");
    }

    public boolean KtChuTaiKhoan(String chutaikhoan) {
        if (chutaikhoan.length() <= 0) {
            return false;
        }
        return true;
    }

    public void nhap() {
        do {
            System.out.println("Nhap So Tai Khoan: ");
            this.setSotaikhoan(sc.nextLine());
        } while (!this.KtSoTaiKhoan(this.sotaikhoan));
        do {
            System.out.println("Nhap Ten Ngan Hang (vd: VietComBank,SaiGonBank, ...):  ");
            this.setTennganhang(sc.nextLine());
        } while (!this.KtTenNganHang(this.tennganhang));
        do {
            System.out.println("Nhap Chu Tai Khoan: ");
            this.setChutaikhoan(sc.nextLine());
        } while (!this.KtChuTaiKhoan(this.chutaikhoan));
    }

    public void xuat() {
        System.out.printf("%-20s | %15s | %30s|\n", "So Tai Khoan", "Ten Ngan Hang", "Chu Tai Khoan");
        System.out.printf("%-20s | %15s | %30s|\n", this.sotaikhoan, this.tennganhang, this.chutaikhoan);
    }

    public String chuyenkhoantrongfile() {
        return this.sotaikhoan + "#" + this.tennganhang + "#" + this.chutaikhoan;
    }

    public static void main(String[] args) {
        ChuyenKhoan a = new ChuyenKhoan();
        System.out.println(a.getSotaikhoan());
    }
}
