package quanlysieuthimini;

import java.util.Scanner;
import java.util.Arrays;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class DsPhieuNhapHang implements ThucThiXuatNhap {

    static Scanner sc = new Scanner(System.in);
    static PhieuNhapHang ds[] = new PhieuNhapHang[0];

    public DsPhieuNhapHang() {
        ds = new PhieuNhapHang[0];
        ds = getDs();
    }

    public static PhieuNhapHang[] getDs() {
        try {
            FileReader fr = new FileReader("phieunhaphang.txt");
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                String line = br.readLine();
                if (line == null || line.equals("")) {
                    break;
                }
                String a[] = line.split("#");
                PhieuNhapHang pnh = new PhieuNhapHang(a[0], a[1], a[2], a[3], a[4], Integer.parseInt(a[5]), Double.parseDouble(a[6]));
                ds = Arrays.copyOf(ds, ds.length + 1);
                ds[ds.length - 1] = pnh;
            }
            br.close();
            fr.close();
            return ds;
        } catch (IOException ex) {
            System.out.println("Khong thao tac duoc voi file");
            return new PhieuNhapHang[0];
        }
    }

    public static void setDs(PhieuNhapHang[] ds) {
        DsPhieuNhapHang.ds = ds;
    }

    public void ghiphieunhaphangvaofile() {
        try {
            FileWriter fw = new FileWriter("phieunhaphang.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < ds.length; i++) {
                bw.write(ds[i].phieunhaphangtrongfile());
            }
            bw.close();
            fw.close();
        } catch (IOException ex) {
            System.out.println("khong thao tac duoc voi file");
        }
    }

    public static boolean KtMaPnhTrongDs(String mapnh) {
        if (ds.length == 0) {
            return false;
        }
        for (int i = 0; i < ds.length; i++) {
            if (mapnh.equals(ds[i].getMaphieunhap())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void nhap() {
        String x;
        do{
        System.out.println("nhap vao so luong phieu nhap hang: ");
        x = sc.nextLine();
        }while(!Check.KtSo(x));
        int a = Integer.parseInt(x);
        for (int i = 0; i < a; i++) {
            PhieuNhapHang pnh = new PhieuNhapHang();
            pnh.nhap();
            ds = Arrays.copyOf(ds, ds.length + 1);
            ds[ds.length - 1] = pnh;
        }
    }

    @Override
    public void xuat() {
        System.out.println("--------------------------------Danh Sach Phieu Nhap Hang--------------------------------");
        System.out.printf("%-15s | %15s | %15s | %15s | %15s |", "Ma Phieu Nhap", "Ma Nhan Vien", "Ma Nha CC", "Ngay", "Tong Tien");
        System.out.println("\n-----------------------------------------------------------------------------------------");
        for (int i = 0; i < ds.length; i++) {
            ds[i].xuat();
        }
    }

    @Override
    public boolean xoa() {
        if (ds.length == 0) {
            System.out.println("\nKhong co phieu nhap hang nao de xoa");
            return false;
        }
        String input;
        System.out.println("\nNhap vao ma phieu nhap muon xoa: ");
        input = sc.nextLine();
        while (!DsPhieuNhapHang.KtMaPnhTrongDs(input) && !input.equals("0")) {
            System.out.println("\nKhong tim thay phieu nhap hang nay, Vui Long Nhap Lai: \nHoac an phim 0 de thoat ");
            input = sc.nextLine();
        }
        if (input.equals("0")) {
            return false;
        }
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaphieunhap().equals(input)) {
                ds[i].chitiet();
                int so;
                do {
                    System.out.println("\nBan Co Muon Xoa Phieu Nhap Hang Nay");
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
                        this.ghiphieunhaphangvaofile();
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
            System.out.println("\nKhong co phieu nhap hang nao de sua");
            return false;
        }
        String input;
        System.out.println("\nNhap vao ma phieu nhap muon sua: ");
        input = sc.nextLine();
        while (!DsPhieuNhapHang.KtMaPnhTrongDs(input) && !input.equals("0")) {
            System.out.println("\nKhong tim thay phieu nhap hang nay, Vui Long Nhap Lai: \nHoac an phim 0 de thoat ");
            input = sc.nextLine();
        }
        if (input.equals("0")) {
            return false;
        }
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaphieunhap().equals(input)) {
                ds[i].chitiet();
                int so;
                do {
                    System.out.println("\nBan Co Muon Sua Thong Tin Phieu Nhap Nay");
                    System.out.println("1.Sua");
                    System.out.println("2.Thoat");
                    so = Integer.parseInt(sc.nextLine());
                } while (so != 1 && so != 2);
                switch (so) {
                    case 2:
                        return false;
                    case 1: {
                        ds[i].setMaphieunhap("-1");
                        PhieuNhapHang pnh2 = new PhieuNhapHang();
                        pnh2.nhap();
                        ds[i] = pnh2;
                        this.ghiphieunhaphangvaofile();
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
            System.out.println("\nKhong co phieu nhap hang nao de tim kiem");
            return false;
        }
        String input;
        System.out.println("\nNhap vao ma phieu nhap muon tim kiem: ");
        input = sc.nextLine();
        while (!DsPhieuNhapHang.KtMaPnhTrongDs(input) && !input.equals("0")) {
            System.out.println("\nKhong tim thay phieu nhap hang nay, Vui Long Nhap Lai:\nHoac an phim 0 de thoat ");
            input = sc.nextLine();
        }
        if (input.equals("0")) {
            return false;
        }
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaphieunhap().equals(input)) {
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
        System.out.println("Nhap so phieu nhap muon them: ");
        x= sc.nextLine();
        }while(!Check.KtSo(x));
        int a = Integer.parseInt(x);
        for (int i = 0; i < a; i++) {
            PhieuNhapHang pnh = new PhieuNhapHang();
            pnh.nhap();
            ds = Arrays.copyOf(ds, ds.length + 1);
            ds[ds.length - 1] = pnh;
        }
        this.ghiphieunhaphangvaofile();
        return true;
    }
}
