package quanlysieuthimini;

import java.util.Scanner;

public class MenuNhaCungCap {

    static Scanner sc = new Scanner(System.in);

    public MenuNhaCungCap() {
    }

    public static void menu() {
        int input;
        String so;
        DsNhaCungCap a = new DsNhaCungCap();
        do {
            do{
            System.out.println("\n\n\n-----------------------Quan Ly Nha Cung Cap--------------------");
            System.out.println("---------------------------------------------------------------");
            System.out.println("1. Hien Thi Danh Sach Nha Cung Cap");
            System.out.println("2. Them Nha Cung Cap");
            System.out.println("3. Tim Kiem Nha Cung Cap Theo Ma");
            System.out.println("4. Sua Thong Tin Nha Cung Cap Theo Ma");
            System.out.println("5. Xoa Nha Cung Cap Theo Ma");
            System.out.println("6. Loc Nha Cung Cap Theo Ten");
            System.out.println("0. Thoat");
            System.out.println("Nhap Vao Lua Chon Cua Ban: ");
            so = sc.nextLine();
            }while (!Check.KtSo(so));
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
        MenuNhaCungCap.menu();
    }
}
