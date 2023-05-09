package quanlysieuthimini;

import java.util.Scanner;

public class PhieuNhapHang {

    static Scanner sc = new Scanner(System.in);
    private String maphieunhap;
    private String manv;
    private String nhacungcap;
    private String ngaynhap;
    private String mahanghoa;
    private int soluong;
    private double dongia;

    public PhieuNhapHang() {
    }

    public PhieuNhapHang(String maphieunhap, String manv, String nhacungcap, String ngaynhap, String mahanghoa, int soluong, double dongia) {
        this.maphieunhap = maphieunhap;
        this.manv = manv;
        this.nhacungcap = nhacungcap;
        this.ngaynhap = ngaynhap;
        this.mahanghoa = mahanghoa;
        this.soluong = soluong;
        this.dongia = dongia;
    }

    public String getMaphieunhap() {
        return maphieunhap;
    }

    public void setMaphieunhap(String maphieunhap) {
        this.maphieunhap = maphieunhap;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getNhacungcap() {
        return nhacungcap;
    }

    public void setNhacungcap(String nhacungcap) {
        this.nhacungcap = nhacungcap;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public String getMahanghoa() {
        return mahanghoa;
    }

    public void setMahanghoa(String mahanghoa) {
        this.mahanghoa = mahanghoa;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public double ThanhTien() {
        return dongia * soluong;
    }

    public boolean KtSoLuong(String so) {
        for(int i=0;i<so.length();i++){
            if(so.charAt(i) < '0' || so.charAt(i) >'9')
                return false;
        }
        int Soluong = Integer.parseInt(so);
        if (Soluong < 1 || Soluong > 500) {
            return false;
        }
        return true;
    }

    public boolean KtDonGia(String gia) {
        for(int i=0;i<gia.length();i++){
            if(gia.charAt(i) < '0' || gia.charAt(i) >'9')
                return false;
        }
        double Dongia = Double.parseDouble(gia);
        if (Dongia < 0) {
            return false;
        }
        return true;
    }

    public void nhap() {
        do {
            System.out.println("Nhap ma cua phieu nhap (gom 5 so)(vd:40001,...):");
            maphieunhap = sc.nextLine();
        } while (!Check.KtMa(this.maphieunhap));
        DsNhanVien dsnv = new DsNhanVien();
        dsnv.xuat();
        do {
            System.out.println("Nhap ma cua nhan vien (5 so): ");
            this.manv = sc.nextLine();
        } while (!DsNhanVien.KtMaNvTrongDs(this.manv) || !Check.KtMa(this.manv));
        DsNhaCungCap dsncc = new DsNhaCungCap();
        dsncc.xuat();
        do {
            System.out.println("Nhap ma nha cung cap (5 so):");
            nhacungcap = sc.nextLine();
        } while (!Check.KtMa(this.nhacungcap) || !DsNhaCungCap.KtMaNccTrongDs(this.nhacungcap));
        do {
            System.out.println("Nhap ngay nhap (vd: 21/07/2003):");
            ngaynhap = sc.nextLine();
        } while (!Check.KtNgay(this.ngaynhap));
        DsHangHoa dshh = new DsHangHoa();
        dshh.xuat();
        do {
            System.out.println("Nhap ma hang hoa (5 so):");
            mahanghoa = sc.nextLine();
        } while (!Check.KtMa(this.mahanghoa) || !DsHangHoa.KtMaHangTrongDs(this.mahanghoa));
        String x;
        do {
            System.out.println("Nhap so luong hang hoa (so nguyen):");
            x = sc.nextLine();
        } while (!this.KtSoLuong(x));
        this.soluong = Integer.parseInt(x);
        do {
            System.out.println("Nhap don gia cua hang hoa (so thuc): ");
            x = sc.nextLine();
        } while (!this.KtDonGia(x));
        this.dongia = Double.parseDouble(x);
    }

    public void xuat() {
        System.out.printf("\n%-15s | %15s | %15s | %15s | %15.2f |", this.maphieunhap, this.manv, this.nhacungcap, this.ngaynhap, this.ThanhTien());
        //Ma Phieu Nhap | Ma Nv | Ma Nha CC | Ngay | Tong Tien
    }

    public void chitiet() {
        System.out.println("\n-------------Chi tiet phieu nhap hang----------------");
        System.out.printf("\n%15s : %10s", "Ma Phieu Nhap", this.maphieunhap);
        System.out.printf("\n%15s : %10s", "Ma Nhan Vien", this.manv);
        System.out.printf("\n%15s : %10s", "Nha Cung Cap", this.nhacungcap);
        System.out.printf("\n%15s : %10s", "Ngay Nhap", this.ngaynhap);
        System.out.printf("\n%15s : %10s", "Ma Hang Nhap", this.mahanghoa);
        System.out.printf("\n%15s : %10.2f", "Gia Tien", this.dongia);
        System.out.printf("\n%15s : %10d", "So Luong", this.soluong);
        System.out.printf("\n%15s : %10.2f", "Tong Tien", this.ThanhTien());
        System.out.println("\n---------------------------------------------------");
    }

    public String phieunhaphangtrongfile() {
        return this.maphieunhap + "#" + this.manv + "#" + this.nhacungcap + "#" + this.ngaynhap + "#" + this.mahanghoa + "#" + this.soluong + "#" + this.dongia + "\n";
    }
}
