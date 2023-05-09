 package quanlysieuthimini;

import java.util.Scanner;

public abstract class ThongTin {

    public Scanner sc = new Scanner(System.in);

    private String hoten;
    private int namsinh;
    private String cmnd;
    private String diachi;
    private String gioitinh;
    private String sodt;

    public ThongTin() {

    }

    public ThongTin(String hoten, int namsinh, String cmnd, String diachi, String gioitinh, String sodt) {
        this.hoten = hoten;
        this.cmnd = cmnd;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
        this.namsinh = namsinh;
        this.sodt = sodt;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public boolean KtHoTen(String hoten) {
        if (hoten.length() <= 0) {
            return false;
        }
        for (int i = 0; i < hoten.length(); i++) {
            if (hoten.charAt(i) >= '0' && hoten.charAt(i) <= '9') {
                return false;
            }
        }
        return true;
    }

    public boolean KtNamSinh(String nam) {
        for(int i = 0;i<nam.length();i++){
            if(nam.charAt(i) < '0' || nam.charAt(i) > '9')
                return false;
        }
        int Namsinh = Integer.parseInt(nam);
        if (Namsinh <= 0) {
            return false;
        }
        int tuoi = 2022 - Namsinh;
        if (tuoi > 200 || tuoi < 0) {
            return false;
        }
        return true;
    }

    public boolean KtCmnd(String cmnd) {
        if (2022 - this.namsinh < 15 && cmnd.length() == 0) {
            return true;
        }
        if (2022 - this.namsinh < 15 && cmnd.length() != 0) {
            return false;
        }
        if (cmnd.length() != 12) {
            return false;
        }
        if (cmnd.charAt(0) != '0') {
            return false;
        }
        for (int i = 1; i < 12; i++) {
            if (cmnd.charAt(i) < '0' || cmnd.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public boolean KtDiaChi(String diachi) {
        if (diachi.length() <= 20) {
            return false;
        }
        return true;
    }

    public boolean KtGioiTinh(String gioitinh) {
        if (gioitinh.length() <= 0) {
            return false;
        }
        if (gioitinh.equals("Nam") || gioitinh.equals("Nu")) {
            return true;
        }
        return false;
    }

    public boolean KtSodt(String sodt) {

        if (sodt.length() != 10) {
            return false;
        }
        if (sodt.charAt(0) != '0') {
            return false;
        }
        for (int i = 1; i < 10; i++) {
            if (sodt.charAt(i) < '0' || sodt.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public void nhap() {
        do {
            System.out.println("nhap vao ho va ten: ");
            this.hoten = sc.nextLine();
        } while (!this.KtHoTen(this.hoten));
        String x;
        do {
            System.out.println("nhap vao nam sinh (1822 < namsinh < 2022):");
            x = sc.nextLine();
        } while (!this.KtNamSinh(x));
        this.namsinh = Integer.parseInt(x);
        do {
            System.out.println("nhap vao cmnd (12 so, duoi 15 tuoi thi bo trong)(vd:088877771111...): ");
            this.cmnd = sc.nextLine();
        } while (!this.KtCmnd(this.cmnd));
        do {
            System.out.println("nhap vao dia chi (hon 20 ki tu):");
            this.diachi = sc.nextLine();
        } while (!this.KtDiaChi(this.diachi));
        do {
            System.out.println("nhap vao gioi tinh (Nam, Nu):");
            this.gioitinh = sc.nextLine();
        } while (!this.KtGioiTinh(this.gioitinh));
        do {
            System.out.println("nhap vao so dien thoai: ");
            this.sodt = sc.nextLine();
        } while (!this.KtSodt(this.sodt));

    }

    public String toString() {
        return "ThongTin{" + "Dia chi=" + diachi + ", Ho va ten=" + hoten + ",Gioi Tinh=" + gioitinh + ",Nam sinh=" + namsinh + ",Chung minh nhan dan=" + cmnd + ",Si=o dien thoai=" + sodt + '}';
    }

    public abstract void xuat();
}
