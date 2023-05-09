package quanlysieuthimini;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class DsHangHoa implements ThucThiDoiTuong {

    static HangHoa[] ds = new HangHoa[0];
    static Scanner sc = new Scanner(System.in);

    public DsHangHoa() {
        ds = getDs();
    }

    public static HangHoa[] getDs() {
        try {
            FileReader fr = new FileReader("hanghoa.txt");
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                String line = br.readLine();
                if (line == null || line.equals("")) {
                    break;
                }
                String a[] = line.split("#");
                HangHoa hh = new HangHoa(a[0], a[1], Double.parseDouble(a[2]));
                ds = Arrays.copyOf(ds, ds.length + 1);
                ds[ds.length - 1] = hh;
            }
            br.close();
            fr.close();
            return ds;
        } catch (IOException ex) {
            System.out.println("Khong thao tac duoc voi file");
            return new HangHoa[0];
        }
    }

    public static void setDs(HangHoa[] ds) {
        DsHangHoa.ds = ds;
    }

    public void ghihanghoavaofile() {
        try {
            FileWriter fw = new FileWriter("hanghoa.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < ds.length; i++) {
                bw.write(ds[i].hanghoatrongfile());
            }
            bw.close();
            fw.close();
        } catch (IOException ex) {
            System.out.println("khong thao tac duoc voi file");
        }
    }

    public static boolean KtMaHangTrongDs(String maHang) {
        if (ds.length == 0) {
            return false;
        }
        for (int i = 0; i < ds.length; i++) {
            if (maHang.equals(ds[i].getMaHang())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void nhap() {
        String x;
        do{
        System.out.println("nhap vao so luong hang hoa: ");
        x = sc.nextLine();
        }while(!Check.KtSo(x));
        int a = Integer.parseInt(x);
        for (int i = 0; i < a; i++) {
            HangHoa hh = new HangHoa();
            hh.nhap();
            ds = Arrays.copyOf(ds, ds.length + 1);
            ds[ds.length - 1] = hh;
        }
    }

    @Override
    public void xuat() {
        System.out.println("---------------------------Danh Sach Hang Hoa----------------------------");
        System.out.printf("\n|%-20s| %30s | %15s |", "Ma Hang Hoa", "Ten Hang", "Don Gia");
        System.out.println("\n-------------------------------------------------------------------------");
        for (int i = 0; i < ds.length; i++) {
            ds[i].xuat();
        }
    }

    @Override
    public boolean xoa() {
        if (ds.length == 0) {
            System.out.println("\nKhong co hang hoa nao de xoa");
            return false;
        }
        String input;
        System.out.println("\nNhap vao ma hang hoa muon xoa: ");
        input = sc.nextLine();
        while (!KtMaHangTrongDs(input) && !input.equals("0")) {
            System.out.println("\nKhong tim thay hang hoa nay, Vui Long Nhap Lai:\nHoac an phim 0 de thoat ");
            input = sc.nextLine();
        }
        if (input.equals("0")) {
            return false;
        }
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaHang().equals(input)) {
                System.out.println(ds[i].toString());
                int so;
                do {
                    System.out.println("\nBan Co Muon Xoa Hang Hoa Nay");
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
                        this.ghihanghoavaofile();
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
            System.out.println("\nKhong co hang hoa nao de sua");
            return false;
        }
        String input;
        System.out.println("\nNhap vao ma hang hoa muon sua: ");
        input = sc.nextLine();
        while (!KtMaHangTrongDs(input) && !input.equals("0")) {
            System.out.println("\nKhong tim thay hang hoa nay, Vui Long Nhap Lai:\nHoac an phim 0 de thoat ");
            input = sc.nextLine();
        }
        if (input.equals("0")) {
            return false;
        }
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaHang().equals(input)) {
                System.out.println(ds[i].toString());
                int so;
                do {
                    System.out.println("\nBan Co Muon Sua Thong Tin Hang Hoa Nay");
                    System.out.println("1.Sua");
                    System.out.println("2.Thoat");
                    so = Integer.parseInt(sc.nextLine());
                } while (so != 1 && so != 2);
                switch (so) {
                    case 2:
                        return false;
                    case 1: {
                        ds[i].setMaHang("-1");
                        HangHoa hh2 = new HangHoa();
                        hh2.nhap();
                        ds[i] = hh2;
                        this.ghihanghoavaofile();
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
            System.out.println("\nKhong co hang hoa nao de tim kiem");
            return false;
        }
        String input;
        System.out.println("\nNhap vao ma hang hoa muon tim kiem: ");
        input = sc.nextLine();
        while (!KtMaHangTrongDs(input) && !input.equals("0")) {
            System.out.println("Khong tim thay hang hoa nay, Vui Long Nhap Lai:\n hoac an phim 0 de thoat ");
            input = sc.nextLine();
        }
        if (input.equals("0")) {
            return false;
        }
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaHang().equals(input)) {
                System.out.println(ds[i].toString());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean them() {
        String x;
        do{
        System.out.println("Nhap so hang hoa muon them: ");
        x = sc.nextLine();
        }while(!Check.KtSo(x));
        int a = Integer.parseInt(x);
        for (int i = 0; i < a; i++) {
            HangHoa hh = new HangHoa();
            hh.nhap();
            ds = Arrays.copyOf(ds, ds.length + 1);
            ds[ds.length - 1] = hh;
        }
        this.ghihanghoavaofile();
        return true;
    }

    public boolean loc() {
        System.out.println("Nhap vao ten hang hoa ban muon loc: ");
        String input = sc.nextLine();
        for (HangHoa hh : DsHangHoa.ds) {
            if (hh.getTenHang().indexOf(input) != -1) {
                hh.xuat();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DsHangHoa a = new DsHangHoa();
        a.nhap();
        a.xuat();
        a.timkiem();
        a.xoa();
        a.xuat();
        a.sua();
        a.xuat();
    }

}
