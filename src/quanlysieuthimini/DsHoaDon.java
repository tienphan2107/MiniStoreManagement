package quanlysieuthimini;

import java.util.Scanner;
import java.util.Arrays;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class DsHoaDon implements ThucThiXuatNhap {

    static Scanner sc = new Scanner(System.in);
    static HoaDon ds[] = new HoaDon[0];

    public DsHoaDon() {
        ds = new HoaDon[0];
        ds = getDs();
    }

    public static HoaDon[] getDs() {
        try {
            FileReader fr = new FileReader("hoadon.txt");
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                String line = br.readLine();
                if (line == null || line.equals("")) {
                    break;
                }
                String a[] = line.split("#");
                String hang[] = a[5].split("/"); //cat chuoi mahh thanh 1 mang mahh
                String stringsohang[] = a[6].split("/");  //cat chuoi soluong hang ra thanh 1 mang kieu String
                int sohang[] = new int[Integer.parseInt(a[4])]; //tao ra 1 mang de luu gia tri mang hanghoa, a[4] la so loai hang hoa
                for (int i = 0; i < Integer.parseInt(a[4]); i++) {
                    sohang[i] = Integer.parseInt(stringsohang[i]); //ep mang soluong hang ve kieu int de khoi tao
                }
                HoaDon hd = new HoaDon(a[0], a[1], a[2], a[3], Integer.parseInt(a[4]), hang, sohang);
                ds = Arrays.copyOf(ds, ds.length + 1);
                ds[ds.length - 1] = hd;
            }
            br.close();
            fr.close();
            return ds;
        } catch (IOException ex) {
            System.out.println("Khong thao tac duoc voi file");
            return new HoaDon[0];
        }
    }

    public static void setDs(HoaDon[] ds) {
        DsHoaDon.ds = ds;
    }

    public void ghihoadonvaofile() {
        try {
            FileWriter fw = new FileWriter("hoadon.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < ds.length; i++) {
                bw.write(ds[i].hoadontrongfile());
            }
            bw.close();
            fw.close();
        } catch (IOException ex) {
            System.out.println("khong thao tac duoc voi file");
        }
    }

    public static boolean KtMaHdTrongDs(String mahd) {
        if (ds.length == 0) {
            return false;
        }
        for (int i = 0; i < ds.length; i++) {
            if (mahd.equals(ds[i].getMahd())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void nhap() {
        String x;
        do{
        System.out.println("nhap vao so luong hoa don: ");
        x = sc.nextLine();
        }while(!Check.KtSo(x));
        int a = Integer.parseInt(x);
        for (int i = 0; i < a; i++) {
            HoaDon hd = new HoaDon();
            hd.nhap();
            ds = Arrays.copyOf(ds, ds.length + 1);
            ds[ds.length - 1] = hd;
        }
    }

    @Override
    public void xuat() {
        System.out.println("--------------------------------Danh Sach Hoa Don----------------------------------------");
        System.out.printf("\n%-15s | %-15s | %-15s | %15s | %15s |", "Ma Hoa Don", "Ma Nhan Vien", "Ma Khach Hang", "Ngay", "Tong Tien");
        System.out.println("\n-----------------------------------------------------------------------------------------");
        for (int i = 0; i < ds.length; i++) {
            ds[i].xuat();
        }
    }

    @Override
    public boolean xoa() {
        if (ds.length == 0) {
            System.out.println("\nKhong co hoa don nao de xoa");
            return false;
        }
        String input;
        System.out.println("\nNhap vao ma hoa don muon xoa: ");
        input = sc.nextLine();
        while (!DsHoaDon.KtMaHdTrongDs(input) && !input.equals("0")) {
            System.out.println("\nKhong tim thay hoa don nay, Vui Long Nhap Lai: \nHoac an phim 0 de thoat ");
            input = sc.nextLine();
        }
        if (input.equals("0")) {
            return false;
        }
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMahd().equals(input)) {
                ds[i].chitiet();
                int so;
                do {
                    System.out.println("\nBan Co Muon Xoa Hoa Don Nay");
                    System.out.println("1.Xoa");
                    System.out.println("2.Thoat");
                    so = Integer.parseInt(sc.nextLine());
                } while (so != 1 && so != 2);
                switch (so) {
                    case 2:
                        return false;
                    case 1: {
                        for (int j = i; j < ds.length - 1; j++) {
                            ds[j] = ds[j + 1];
                        }
                        ds = Arrays.copyOf(ds, ds.length - 1);
                        this.ghihoadonvaofile();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean sua() {
        if (ds.length == 0) {
            System.out.println("\nKhong co hoa don nao de sua");
            return false;
        }
        String input;
        System.out.println("\nNhap vao ma hoa don muon sua: ");
        input = sc.nextLine();
        while (!DsHoaDon.KtMaHdTrongDs(input) && !input.equals("0")) {
            System.out.println("\nKhong tim thay hoa don nay, Vui Long Nhap Lai: \nHoac an phim 0 de thoat ");
            input = sc.nextLine();
        }
        if (input.equals("0")) {
            return false;
        }
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMahd().equals(input)) {
                ds[i].chitiet();
                int so;
                do {
                    System.out.println("\nBan Co Muon Sua Thong Tin Hoa Don Nay");
                    System.out.println("1.Sua");
                    System.out.println("2.Thoat");
                    so = Integer.parseInt(sc.nextLine());
                } while (so != 1 && so != 2);
                switch (so) {
                    case 2:
                        return false;
                    case 1: {
                        ds[i].setMahd("-1");
                        HoaDon hd2 = new HoaDon();
                        hd2.nhap();
                        ds[i] = hd2;
                        this.ghihoadonvaofile();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean timkiem() {
        if (ds.length == 0) {
            System.out.println("\nKhong co hoa don nao de tim kiem");
            return false;
        }
        String input;
        System.out.println("\nNhap vao ma hoa don muon tim kiem: ");
        input = sc.nextLine();
        while (!DsHoaDon.KtMaHdTrongDs(input) && !input.equals("0")) {
            System.out.println("\nKhong tim thay hoa don nay, Vui Long Nhap Lai:\nHoac an phim 0 de thoat ");
            input = sc.nextLine();
        }
        if (input.equals("0")) {
            return false;
        }
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMahd().equals(input)) {
                ds[i].chitiet();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean them() { 
        String x;
        do{
        System.out.println("Nhap so hoa don muon them: ");
        x = sc.nextLine();
        }while(!Check.KtSo(x));
        int a = Integer.parseInt(x);
        for (int i = 0; i < a; i++) {
            HoaDon hd = new HoaDon();
            hd.nhap();
            ds = Arrays.copyOf(ds, ds.length + 1);
            ds[ds.length - 1] = hd;
        }
        this.ghihoadonvaofile();
        return true;
    }
}
