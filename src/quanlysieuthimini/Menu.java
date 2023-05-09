package quanlysieuthimini;

import java.util.Scanner;

public class Menu {

    static Scanner sc = new Scanner(System.in);

    public static void mainmenu() {
        int input;
        String so;
        do {
            do{
            System.out.println("\n----------Sieu Thi Mini------------");
            System.out.println("1.Quan Ly Nhan Vien");
            System.out.println("2.Quan Ly Khach Hang");
            System.out.println("3.Quan Ly Hang Hoa");
            System.out.println("4.Quan Ly Nha Cung Cap");
            System.out.println("5.Quan Ly Hoa Don");
            System.out.println("6.Quan Ly Phieu Nhap Hang");
            System.out.println("7.Thong Ke");
            System.out.println("0.Thoat");
            System.out.println("Nhap vao lua chon cua ban:");
            so = sc.nextLine();
            }while(!Check.KtSo(so));
            input = Integer.parseInt(so);
            switch (input) {
                case 1 ->
                    MenuNhanVien.menu();
                case 2 ->
                    MenuKhachHang.menu();
                case 3 ->
                    MenuHangHoa.menu();
                case 4 ->
                    MenuNhaCungCap.menu();
                case 5 ->
                    MenuHoaDon.menu();
                case 6 ->
                    MenuPhieuNhapHang.menu();
                case 7 ->
                    ThongKe.menu();
            }
        } while (input != 0);
    }
}
