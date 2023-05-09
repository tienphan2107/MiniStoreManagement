package quanlysieuthimini;

import java.util.Scanner;

public class ThanhToan {

    public Scanner sc = new Scanner(System.in);
    int sophuongthuc;
    ChuyenKhoan ptchuyenkhoan = new ChuyenKhoan();
    ViDienTu ptvidientu = new ViDienTu();

    public ThanhToan() {
        this.ptvidientu = new ViDienTu();
        this.ptchuyenkhoan = new ChuyenKhoan();
    }

    public ThanhToan(int sophuongthuc, ChuyenKhoan ptchuyenkhoan, ViDienTu ptvidientu) {
        this.sophuongthuc = sophuongthuc;
        this.ptchuyenkhoan = ptchuyenkhoan;
        this.ptvidientu = ptvidientu;
    }

    public int getSophuongthuc() {
        return sophuongthuc;
    }

    public void setSophuongthuc(int sophuongthuc) {
        this.sophuongthuc = sophuongthuc;
    }

    public ChuyenKhoan getPtchuyenkhoan() {
        return ptchuyenkhoan;
    }

    public void setPtchuyenkhoan(ChuyenKhoan ptchuyenkhoan) {
        this.ptchuyenkhoan = ptchuyenkhoan;
    }

    public ViDienTu getPtvidientu() {
        return ptvidientu;
    }

    public void setPtvidientu(ViDienTu ptvidientu) {
        this.ptvidientu = ptvidientu;
    }

    @Override
    public String toString() {
        return "ThanhToan{" + ", sophuongthuc=" + sophuongthuc + ", ptchuyenkhoan=" + ptchuyenkhoan + ", ptvidientu=" + ptvidientu + '}';
    }

    public boolean KtSoPhuongThuc(String so) {
        for(int i=0;i<so.length();i++){
            if(so.charAt(i)<'0' || so.charAt(i)>'9')
                return false;
        }
        int Sophuongthuc = Integer.parseInt(so);
        if (Sophuongthuc < 0 || Sophuongthuc > 2) {
            return false;
        }
        return true;
    }

    public void nhap() {
        String x;
        do {
            System.out.println("nhap so luong phuong thuc thanh toan cua khach (ngoai tien mat)(0 < x < 2): ");
            x = sc.nextLine();
        } while (!this.KtSoPhuongThuc(x));
        this.sophuongthuc = Integer.parseInt(x);
        if (this.sophuongthuc == 1) {
            int luachon;
            do {
                System.out.println("Chon Phuong Thuc Ban Muon Su Dung (Phim 1 hoac 2): \n 1.Chuyen Khoan\n 2.Vi Dien Tu");
                luachon = (Integer.parseInt(sc.nextLine()));
                switch (luachon) {
                    case 1 -> {
                        this.ptchuyenkhoan = new ChuyenKhoan();
                        this.ptchuyenkhoan.nhap();
                    }
                    case 2 -> {
                        this.ptvidientu = new ViDienTu();
                        this.ptvidientu.nhap();
                    }
                    default ->
                        luachon = 0;
                }
            } while (luachon == 0);
        } else if (this.sophuongthuc == 2) {
            System.out.println("Ban Chon Vua Chuyen Khoan Vua Dung Vi Dien Tu");
            this.ptchuyenkhoan = new ChuyenKhoan();
            this.ptvidientu = new ViDienTu();
            this.ptchuyenkhoan.nhap();
            this.ptvidientu.nhap();
        }
    }

    public void xuat() {
        switch (this.sophuongthuc) {
            case 0 ->
                System.out.println("\nChi Thanh Toan Bang Tien Mat");
            case 1 -> {
                if (this.ptchuyenkhoan.getSotaikhoan() != null) {
                    System.out.println("\nPhuong Thuc Chuyen Khoan");
                    this.ptchuyenkhoan.xuat();
                } else {
                    System.out.println("\nPhuong Thuc Vi Dien Tu");
                    this.ptvidientu.xuat();
                }
            }
            default -> {
                System.out.println("\nDung 2 Phuong Thuc");
                System.out.println("\nPhuong Thuc Chuyen Khoan");
                this.ptchuyenkhoan.xuat();
                System.out.println("\nPhuong Thuc Vi Dien Tu");
                this.ptvidientu.xuat();
            }
        }
    }

    public static void main(String[] args) {
        ThanhToan a = new ThanhToan();
        a.nhap();
        a.xuat();
    }

}
