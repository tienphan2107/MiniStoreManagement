package quanlysieuthimini;

import java.util.Scanner;

public class ViDienTu {

    Scanner sc = new Scanner(System.in);
    String tenvi;
    String sovi;

    public ViDienTu() {
    }

    public ViDienTu(String tenvi, String sovi) {
        this.tenvi = tenvi;
        this.sovi = sovi;
    }

    public String getTenvi() {
        return tenvi;
    }

    public void setTenvi(String tenvi) {
        this.tenvi = tenvi;
    }

    public String getSovi() {
        return sovi;
    }

    public void setSovi(String sovi) {
        this.sovi = sovi;
    }

    @Override
    public String toString() {
        return "TenVi=" + tenvi + ", SoVi=" + sovi + '|';
    }

    public boolean KtTenVi(String tenvi) {
        if (tenvi.length() <= 0) {
            return false;
        }
        return true;
    }

    public boolean KtSoVi(String sovi) {
        if (sovi.length() != 10) {
            return false;
        }
        if (sovi.charAt(0) != '0') {
            return false;
        }
        for (int i = 1; i < 10; i++) {
            if (sovi.charAt(i) < '0' || sovi.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public void nhap() {
        do {
            System.out.println("Nhap Ten Vi Dien Tu: ");
            this.setTenvi(sc.nextLine());
        } while (!this.KtTenVi(this.tenvi));
        do {
            System.out.println("Nhap So Dien Thoai Lien Ket Vi Dien Tu: ");
            this.setSovi(sc.nextLine());
        } while (!this.KtSoVi(this.sovi));
    }

    public void xuat() {
        System.out.printf("%-20s | %15s |\n", "Ten Vi Dien Tu", "So Vi Dien Tu");
        System.out.printf("%-20s | %15s |\n", this.tenvi, this.sovi);
    }

    public String vidientutrongfile() {
        return this.tenvi + "#" + this.sovi;
    }
}
