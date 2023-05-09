package quanlysieuthimini;

import java.util.Scanner;
import java.util.Arrays;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class DsKhachHang implements ThucThiDoiTuong {

    static KhachHang[] ds = new KhachHang[0];
    static Scanner sc = new Scanner(System.in);

    public DsKhachHang() {
        ds = new KhachHang[0];
        ds = getDs();
    }

    public static KhachHang[] getDs() {
        try {
            FileReader fr = new FileReader("khachhang.txt");
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                String line = br.readLine();
                if (line == null || line.equals("")) {
                    break;
                }
                String a[] = line.split("#");
                KhachHang kh;
                if (a.length == 8) {
                    //khach chi thanh toan bang tien mat
                    kh = new KhachHang(a[0], Integer.parseInt(a[1]), a[2], a[3], a[4], a[5], a[6], Integer.parseInt(a[7]));
                } else if (a.length == 10) {
                    // khach dung vi dien tu
                    kh = new KhachHang(a[0], Integer.parseInt(a[1]), a[2], a[3], a[4], a[5], a[6], Integer.parseInt(a[7]), a[8], a[9]);
                } else if (a.length == 11) {
                    kh = new KhachHang(a[0], Integer.parseInt(a[1]), a[2], a[3], a[4], a[5], a[6], Integer.parseInt(a[7]), a[8], a[9], a[10]);
                } else {
                    kh = new KhachHang(a[0], Integer.parseInt(a[1]), a[2], a[3], a[4], a[5], a[6], Integer.parseInt(a[7]), a[8], a[9], a[10], a[11], a[12]);
                }
                ds = Arrays.copyOf(ds, ds.length + 1);
                ds[ds.length - 1] = kh;
            }
            br.close();
            fr.close();
            return ds;
        } catch (IOException ex) {
            System.out.println("Khong thao tac duoc voi file");
            return new KhachHang[0];
        }
    }

    public static void setDs(KhachHang[] ds) {
        DsKhachHang.ds = ds;
    }

    public void ghikhachhangvaofile() {
        try {
            FileWriter fw = new FileWriter("khachhang.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < ds.length; i++) {
                bw.write(ds[i].khachhangtrongfile());
            }
            bw.close();
            fw.close();
        } catch (IOException ex) {
            System.out.println("khong thao tac duoc voi file");
        }
    }

    public static boolean KtMaKhTrongDs(String makh) {
        if (ds.length == 0) {
            return false;
        }
        for (int i = 0; i < ds.length; i++) {
            if (makh.equals(ds[i].getMakh())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void nhap() {
        String x;
        do{
        System.out.println("nhap vao so luong khach hang: ");
        x = sc.nextLine();
        }while(!Check.KtSo(x));
        int a = Integer.parseInt(x);
        for (int i = 0; i < a; i++) {
            KhachHang kh = new KhachHang();
            kh.nhap();
            ds = Arrays.copyOf(ds, ds.length + 1);
            ds[ds.length - 1] = kh;
        }
    }

    @Override
    public void xuat() {
        System.out.println("-----------------Danh Sach Khach Hang------------------");
        System.out.printf("\n|%-20s| %30s |", "Ma Khach Hang", "Ho Ten");
        System.out.println("\n------------------------------------------------------");
        for (int i = 0; i < ds.length; i++) {
            ds[i].xuat();
        }
    }

    @Override
    public boolean xoa() {
        if (ds.length == 0) {
            System.out.println("\nKhong co khach hang nao de xoa");
            return false;
        }
        String input;
        System.out.println("\nNhap vao ma khach hang muon xoa: ");
        input = sc.nextLine();
        while (!DsKhachHang.KtMaKhTrongDs(input) && !input.equals("0")) {
            System.out.println("\nKhong tim thay khach hang nay, Vui Long Nhap Lai: \nHoac an phim 0 de thoat ");
            input = sc.nextLine();
        }
        if (input.equals("0")) {
            return false;
        }
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMakh().equals(input)) {
                ds[i].chitiet();
                int so;
                do {
                    System.out.println("\nBan Co Muon Xoa Khach Hang Nay");
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
                        this.ghikhachhangvaofile();
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
            System.out.println("\nKhong co khach hang nao de sua");
            return false;
        }
        String input;
        System.out.println("\nNhap vao ma khach hang muon sua: ");
        input = sc.nextLine();
        while (!DsKhachHang.KtMaKhTrongDs(input) && !input.equals("0")) {
            System.out.println("\nKhong tim thay khach hang nay, Vui Long Nhap Lai: \nHoac an phim 0 de thoat ");
            input = sc.nextLine();
        }
        if (input.equals("0")) {
            return false;
        }
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMakh().equals(input)) {
                ds[i].chitiet();
                int so;
                do {
                    System.out.println("\nBan Co Muon Sua Thong Tin Khach Hang Nay");
                    System.out.println("1.Sua");
                    System.out.println("2.Thoat");
                    so = Integer.parseInt(sc.nextLine());
                } while (so != 1 && so != 2);
                switch (so) {
                    case 2:
                        return false;
                    case 1: {
                        ds[i].setMakh("-1");
                        KhachHang kh2 = new KhachHang();
                        kh2.nhap();
                        ds[i] = kh2;
                        this.ghikhachhangvaofile();
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
            System.out.println("\nKhong co khach hang nao de tim kiem");
            return false;
        }
        String input;
        System.out.println("\nNhap vao ma khach hang muon tim kiem: ");
        input = sc.nextLine();
        while (!DsKhachHang.KtMaKhTrongDs(input) && !input.equals("0")) {
            System.out.println("\nKhong tim thay khach hang nay, Vui Long Nhap Lai:\nHoac an phim 0 de thoat ");
            input = sc.nextLine();
        }
        if (input.equals("0")) {
            return false;
        }
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMakh().equals(input)) {
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
        System.out.println("Nhap so khach hang muon them: ");
        x = sc.nextLine();
        }while(!Check.KtSo(x));
        int a = Integer.parseInt(x);
        for (int i = 0; i < a; i++) {
            KhachHang kh = new KhachHang();
            kh.nhap();
            ds = Arrays.copyOf(ds, ds.length + 1);
            ds[ds.length - 1] = kh;
        }
        this.ghikhachhangvaofile();
        return true;
    }

    public boolean loc() {
        System.out.println("Nhap vao ten khach hang ban muon loc: ");
        String input = sc.nextLine();
        for (KhachHang kh : DsKhachHang.ds) {
            if (kh.getHoten().indexOf(input) != -1) {
                kh.xuat();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DsKhachHang a = new DsKhachHang();
        a.nhap();
        a.xuat();
        a.xoa();
        a.sua();
        a.them();
        a.xuat();
        a.timkiem();

    }

}
