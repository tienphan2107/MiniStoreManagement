package quanlysieuthimini;

import java.util.Scanner;

public class MenuHoaDon {

    static Scanner sc = new Scanner(System.in);

    public MenuHoaDon() {
    }

    public static void menu() {
        int input;
        String so;
        DsHoaDon a = new DsHoaDon();
        DsNhanVien nv = new DsNhanVien();
        DsKhachHang kh = new DsKhachHang();
        DsHangHoa hh = new DsHangHoa();
        do {
            do{
            System.out.println("\n\n------------------------Quan Ly Hoa Don---------------------");
            System.out.println("------------------------------------------------------------");
            System.out.println("1. Hien Thi Danh Sach Hoa Don");
            System.out.println("2. Them Hoa Don");
            System.out.println("3. Tim Kiem Hoa Don Theo Ma");
            System.out.println("4. Sua Thong Tin Hoa Don Theo Ma");
            System.out.println("5. Xoa Hoa Don Theo Ma");
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
        MenuHoaDon.menu();
    }
}
