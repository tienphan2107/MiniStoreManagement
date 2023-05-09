package quanlysieuthimini;

import java.util.Scanner;
import java.util.Arrays;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class DsNhaCungCap implements ThucThiDoiTuong {

    static Scanner sc = new Scanner(System.in);
    static NhaCungCap ds[] = new NhaCungCap[0];

    public DsNhaCungCap() {
        ds = new NhaCungCap[0];
        ds = getDs();
    }

    public static NhaCungCap[] getDs() {
        try {
            FileReader fr = new FileReader("nhacungcap.txt");
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                String line = br.readLine();
                if (line == null || line.equals("")) {
                    break;
                }
                String a[] = line.split("#");
                NhaCungCap ncc = new NhaCungCap(a[0], a[1], a[2], a[3]);
                ds = Arrays.copyOf(ds, ds.length + 1);
                ds[ds.length - 1] = ncc;
            }
            br.close();
            fr.close();
            return ds;
        } catch (IOException ex) {
            System.out.println("Khong thao tac duoc voi file");
            return new NhaCungCap[0];
        }
    }

    public static void setDs(NhaCungCap[] ds) {
        DsNhaCungCap.ds = ds;
    }

    public static boolean KtMaNccTrongDs(String mancc) {
        if (ds.length == 0) {
            return false;
        }
        for (int i = 0; i < ds.length; i++) {
            if (mancc.equals(ds[i].getManhacungcap())) {
                return true;
            }
        }
        return false;
    }

    public void ghinhacungcapvaofile() {
        try {
            FileWriter fw = new FileWriter("nhacungcap.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < ds.length; i++) {
                bw.write(ds[i].nhacungcaptrongfile());
            }
            bw.close();
            fw.close();
        } catch (IOException ex) {
            System.out.println("khong thao tac duoc voi file");
        }
    }

    @Override
    public void nhap() {
        String x;
        do{
        System.out.println("nhap vao so luong nha cung cap: ");
        x = sc.nextLine();
        }while(!Check.KtSo(x));
        int a = Integer.parseInt(x);
        for (int i = 0; i < a; i++) {
            NhaCungCap ncc = new NhaCungCap();
            ncc.nhap();
            ds = Arrays.copyOf(ds, ds.length + 1);
            ds[ds.length - 1] = ncc;
        }
    }

    @Override
    public void xuat() {
        System.out.println("-------------------------------------------Danh Sach Nha Cung Cap----------------------------------------------");
        System.out.printf("\n%-15s | %20s | %50s | %15s |", "Ma Nha Cung Cap", "Ten Nha Cung Cap", "Dia Chi", "So Dien Thoai");
        System.out.println("\n---------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < ds.length; i++) {
            ds[i].xuat();
        }
    }

    @Override
    public boolean xoa() {
        if (ds.length == 0) {
            System.out.println("\nKhong co nha cung cap nao de xoa");
            return false;
        }
        String input;
        System.out.println("\nNhap vao ma nha cung cap muon xoa: ");
        input = sc.nextLine();
        while (!DsNhaCungCap.KtMaNccTrongDs(input) && !input.equals("0")) {
            System.out.println("\nKhong tim thay nha cung cap nay, Vui Long Nhap Lai: \nHoac an phim 0 de thoat ");
            input = sc.nextLine();
        }
        if (input.equals("0")) {
            return false;
        }
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getManhacungcap().equals(input)) {
                System.out.println(ds[i].toString());
                int so;
                do {
                    System.out.println("\nBan Co Muon Xoa Nha Cung Cap Nay");
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
                        this.ghinhacungcapvaofile();
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
            System.out.println("\nKhong co nha cung cap nao de sua");
            return false;
        }
        String input;
        System.out.println("\nNhap vao ma nha cung cap muon sua: ");
        input = sc.nextLine();
        while (!DsNhaCungCap.KtMaNccTrongDs(input) && !input.equals("0")) {
            System.out.println("\nKhong tim thay nha cung cap nay, Vui Long Nhap Lai: \nHoac an phim 0 de thoat ");
            input = sc.nextLine();
        }
        if (input.equals("0")) {
            return false;
        }
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getManhacungcap().equals(input)) {
                System.out.println(ds[i].toString());
                int so;
                do {
                    System.out.println("\nBan Co Muon Sua Thong Tin Nha Cung Cap Nay");
                    System.out.println("1.Sua");
                    System.out.println("2.Thoat");
                    so = Integer.parseInt(sc.nextLine());
                } while (so != 1 && so != 2);
                switch (so) {
                    case 2:
                        return false;
                    case 1: {
                        ds[i].setManhacungcap("-1");
                        NhaCungCap ncc2 = new NhaCungCap();
                        ncc2.nhap();
                        ds[i] = ncc2;
                        this.ghinhacungcapvaofile();
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
            System.out.println("\nKhong co nha cung cap nao de tim kiem");
            return false;
        }
        String input;
        System.out.println("\nNhap vao ma nha cung cap muon tim kiem: ");
        input = sc.nextLine();
        while (!DsNhaCungCap.KtMaNccTrongDs(input) && !input.equals("0")) {
            System.out.println("\nKhong tim thay nha cung cap nay, Vui Long Nhap Lai:\nHoac an phim 0 de thoat ");
            input = sc.nextLine();
        }
        if (input.equals("0")) {
            return false;
        }
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getManhacungcap().equals(input)) {
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
        System.out.println("\nNhap so nha cung cap muon them: ");
        x = sc.nextLine();
        }while(!Check.KtSo(x));
        int a = Integer.parseInt(x);
        for (int i = 0; i < a; i++) {
            NhaCungCap ncc = new NhaCungCap();
            ncc.nhap();
            ds = Arrays.copyOf(ds, ds.length + 1);
            ds[ds.length - 1] = ncc;
        }
        this.ghinhacungcapvaofile();
        return true;
    }

    public boolean loc() {
        System.out.println("Nhap vao ten nha cung cap ban muon loc: ");
        String input = sc.nextLine();
        for (NhaCungCap ncc : DsNhaCungCap.ds) {
            if (ncc.getTennhacungcap().indexOf(input) != -1) {
                ncc.xuat();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DsNhaCungCap a = new DsNhaCungCap();
        a.nhap();
        a.xuat();
        a.timkiem();
        a.xoa();
        a.xuat();
        a.them();
        a.sua();
        a.xuat();
    }
}
