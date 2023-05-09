package quanlysieuthimini;

import java.util.Scanner;

public class MenuKhachHang {

    static Scanner sc = new Scanner(System.in);

    public MenuKhachHang() {
    }

    public static void menu() {
        int input;
        String so;
        DsKhachHang a = new DsKhachHang();
        do {
            do{
            System.out.println("\n\n\n-----------------------Quan Ly Khach Hang-------------------");
            System.out.println("------------------------------------------------------------");
            System.out.println("1. Hien Thi Danh Sach Khach Hang");
            System.out.println("2. Them Khach Hang");
            System.out.println("3. Tim Kiem Khach Hang Theo Ma");
            System.out.println("4. Sua Thong Tin Khach Hang Theo Ma");
            System.out.println("5. Xoa Khach Hang Theo Ma");
            System.out.println("6. Loc Khach Hang Theo Ten");
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
                case 6 ->
                    a.loc();
            }
        } while (input != 0);
    }

    public static void main(String[] args) {
        MenuKhachHang.menu();
    }
}
