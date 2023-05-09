package quanlysieuthimini;

import java.util.Scanner;
import java.util.Arrays;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class DsNhanVien implements ThucThiDoiTuong {

    static NhanVien ds[] = new NhanVien[0];
    static Scanner sc = new Scanner(System.in);

    public DsNhanVien() {
        ds = new NhanVien[0];
        ds = getDs();
    }

    public static NhanVien[] getDs() {
        try {
            FileReader fr = new FileReader("nhanvien.txt");
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                String line = br.readLine();
                if (line == null || line.equals("")) {
                    break;
                }
                String a[] = line.split("#");
                NhanVien nv = new NhanVien(a[0], Integer.parseInt(a[1]), a[2], a[3], a[4], a[5], a[6], a[7]);
                ds = Arrays.copyOf(ds, ds.length + 1);
                ds[ds.length - 1] = nv;
            }
            br.close();
            fr.close();
            return ds;
        } catch (IOException ex) {
            System.out.println("Khong thao tac duoc voi file");
            return new NhanVien[0];
        }
    }

    public static void setDs(NhanVien[] ds) {
        DsNhanVien.ds = ds;
    }

    public void ghinhanvienvaofile() {
        try {
            FileWriter fw = new FileWriter("nhanvien.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < ds.length; i++) {
                bw.write(ds[i].nhanvientrongfile());
            }
            bw.close();
            fw.close();
        } catch (IOException ex) {
            System.out.println("khong thao tac duoc voi file");
        }
    }

    public static boolean KtMaNvTrongDs(String manv) {
        if (ds.length == 0) {
            return false;
        }
        for (int i = 0; i < ds.length; i++) {
            if (manv.equals(ds[i].getManv())) {
                return true;
            }
        }
        return false;
    }

    public boolean KtTuoiNv(int namsinh) {
        if (2022 - namsinh < 18 || 2022 - namsinh > 50) {
            return false;
        }
        return true;
    }

    @Override
    public void nhap() {
        String x;
        do{
        System.out.println("nhap vao so luong nhan vien: ");
        x = sc.nextLine();
        }while(!Check.KtSo(x));
        int so = Integer.parseInt(x);       
        for (int i = 0; i < so; i++) {
            NhanVien nv = new NhanVien();
            nv.nhap();
            while (!this.KtTuoiNv(nv.getNamsinh())) {
                System.out.println("\nNhan vien co tuoi k hop le !!! \nVui Long Nhap Lai");
                nv.nhap();
            }
            ds = Arrays.copyOf(ds, ds.length + 1);
            ds[ds.length - 1] = nv;
        }
    }

    @Override
    public void xuat() {
        System.out.println("-----------------------------Danh Sach Nhan Vien-------------------------");
        System.out.printf("\n|%-20s| %30s | %15s |", "Ma Nhan Vien", "Ho Ten", "Chuc Vu");
        System.out.println("\n-------------------------------------------------------------------------");
        for (int i = 0; i < ds.length; i++) {
            ds[i].xuat();
        }
    }

    @Override
    public boolean xoa() {
        if (ds.length == 0) {
            System.out.println("Khong co nhan vien nao de xoa");
            return false;
        }
        String input;
        System.out.println("\nNhap vao ma nhan vien muon xoa: ");
        input = sc.nextLine();
        while (!DsNhanVien.KtMaNvTrongDs(input) && !input.equals("0")) {
            System.out.println("Khong tim thay nhan vien nay, Vui Long Nhap Lai:\n Hoac an phim 0 de thoat ");
            input = sc.nextLine();
        }
        if (input.equals("0")) {
            return false;
        }
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getManv().equals(input)) {
                ds[i].chitiet();
                int so;
                do {
                    System.out.println("\nBan Co Muon Xoa Nhan Vien Nay");
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
                        this.ghinhanvienvaofile();
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
            System.out.println("Khong co nhan vien nao de sua");
            return false;
        }
        String input;
        System.out.println("\nNhap vao ma nhan vien muon sua: ");
        input = sc.nextLine();
        while (!DsNhanVien.KtMaNvTrongDs(input) && !input.equals("0")) {
            System.out.println("Khong tim thay nhan vien nay, Vui Long Nhap Lai:\nHoac an phim 0 de thoat ");
            input = sc.nextLine();
        }
        if (input.equals("0")) {
            return false;
        }
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getManv().equals(input)) {
                ds[i].chitiet();
                int so;
                do {
                    System.out.println("\nBan Co Muon Sua Thong Tin Nhan Vien Nay");
                    System.out.println("1.Sua");
                    System.out.println("2.Thoat");
                    so = Integer.parseInt(sc.nextLine());
                } while (so != 1 && so != 2);
                switch (so) {
                    case 2:
                        return false;
                    case 1: {
                        ds[i].setManv("-1");
                        NhanVien nv2 = new NhanVien();
                        nv2.nhap();
                        while (!this.KtTuoiNv(nv2.getNamsinh())) {
                            System.out.println("\nNhan vien co tuoi k hop le !!! \nVui Long Nhap Lai");
                            nv2.nhap();
                        }
                        ds[i] = nv2;
                        this.ghinhanvienvaofile();
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
            System.out.println("Khong co nhan vien nao de tim kiem");
            return false;
        }
        String input;
        System.out.println("\nNhap vao ma nhan vien muon tim kiem: ");
        input = sc.nextLine();
        while (!DsNhanVien.KtMaNvTrongDs(input) && !input.equals("0")) {
            System.out.println("Khong tim thay nhan vien nay, Vui Long Nhap Lai:\nHoac an phim 0 de thoat");
            input = sc.nextLine();
        }
        if (input.equals("0")) {
            return false;
        }
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getManv().equals(input)) {
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
        System.out.println("Nhap so nhan vien muon them: ");
        x = sc.nextLine();
        }while(!Check.KtSo(x));
        int a = Integer.parseInt(x);
        for (int i = 0; i < a; i++) {
            NhanVien nv = new NhanVien();
            nv.nhap();
            while (!this.KtTuoiNv(nv.getNamsinh())) {
                System.out.println("\nNhan vien co tuoi k hop le !!! \nVui Long Nhap Lai");
                nv.nhap();
            }
            ds = Arrays.copyOf(ds, ds.length + 1);
            ds[ds.length - 1] = nv;

        }
        this.ghinhanvienvaofile();
        return true;
    }

    @Override
    public boolean loc() {
        System.out.println("Nhap vao ten nhan vien ban muon loc: ");
        String input = sc.nextLine();
        for (NhanVien nv : DsNhanVien.ds) {
            if (nv.getHoten().indexOf(input) != -1) {
                nv.xuat();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DsNhanVien a = new DsNhanVien();
        a.nhap();
        a.xuat();
        a.xoa();
        a.sua();
        a.them();
        a.xuat();
        a.timkiem();
    }

}
