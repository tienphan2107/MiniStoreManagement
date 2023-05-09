package quanlysieuthimini;

import java.util.Scanner;

public class MenuPhieuNhapHang {

    static Scanner sc = new Scanner(System.in);

    public MenuPhieuNhapHang() {
    }

    public static void menu() {
        int input;
        String so;
        DsPhieuNhapHang a = new DsPhieuNhapHang();
        DsNhanVien nv = new DsNhanVien();
        DsNhaCungCap ncc = new DsNhaCungCap();
        DsHangHoa hh = new DsHangHoa();
        do {
            do{
            System.out.println("\n\n\n--------------------Quan Ly Phieu Nhap Hang-----------------");
            System.out.println("------------------------------------------------------------");
            System.out.println("1. Hien Thi Danh Sach Phieu Nhap Hang");
            System.out.println("2. Them Phieu Nhap Hang");
            System.out.println("3. Tim Kiem Phieu Nhap Hang Theo Ma");
            System.out.println("4. Sua Thong Tin Phieu Nhap Hang Theo Ma");
            System.out.println("5. Xoa Phieu Nhap Hang Theo Ma");
            System.out.println("0. Thoat");
            System.out.println("Nhap Vao Lua Chon Cua Ban: ");
            so = sc.nextLine();
            }while(!Check.KtSo(so));
            input = Integer.parseInt(so);

            switch (input) {
                case 1 ->
                    a.xuat();
                case 2 ->
                    a.them();
                case 3 ->
                    a.timkiem();
                case 4 ->
                    a.sua();
                case 5 ->
                    a.xoa();
            }
        } while (input != 0);
    }

    public static void main(String[] args) {
        MenuPhieuNhapHang.menu();
    }
}
