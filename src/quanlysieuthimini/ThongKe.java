package quanlysieuthimini;

import java.util.Scanner;

public class ThongKe {

    static Scanner sc = new Scanner(System.in);

    public static void ThongKeNhanVien() {
        DsNhanVien dsnv = new DsNhanVien();
        System.out.println("\nTong So Nhan Vien: " + DsNhanVien.ds.length);
        int nam = 0;
        int quanly = 0;
        int thungan = 0;
        for (NhanVien d : DsNhanVien.ds) {
            if (d.getGioitinh().equals("Nam")) {
                nam++;
            }
            if (d.getChucvu().equals("Quan Ly")) {
                quanly++;
            }
            if (d.getChucvu().equals("Thu Ngan")) {
                thungan++;
            }
        }
        int thukho = DsNhanVien.ds.length - quanly - thungan;
        System.out.println("So Nhan Vien Nam: " + nam + "\tSo Nhan Vien Nu: " + (DsNhanVien.ds.length - nam));
        System.out.println("Quan Ly: " + quanly + "\tThu Ngan: " + thungan + "\tThu Kho: " + thukho);
    }

    public static void ThongKeKhachHang() {
        DsKhachHang dskh = new DsKhachHang();
        System.out.println("\nTong So Khach Hang: " + DsKhachHang.ds.length);
        int nam = 0;
        int dutuoi = 0;
        int tienmat = 0;
        int thenganhang = 0;
        int ca2 = 0;
        for (KhachHang d : DsKhachHang.ds) {
            if (d.getGioitinh().equals("Nam")) {
                nam++;
            }
            if (d.getNamsinh() < 2022 - 18) {
                dutuoi++;
            }
            if (d.getThanhtoan().getSophuongthuc() == 0) {
                tienmat++;
            }
            if (d.getThanhtoan().getSophuongthuc() == 2) {
                ca2++;
            }
            if (d.getThanhtoan().getSophuongthuc() == 1 && d.getThanhtoan().getPtchuyenkhoan().getSotaikhoan() != null) {
                thenganhang++;
            }
        }
        int vidientu = DsKhachHang.ds.length - tienmat - ca2 - thenganhang;
        int thieutuoi = DsKhachHang.ds.length - dutuoi;
        System.out.println("So Khach Du 18t: " + dutuoi + "\t So Khach Duoi 18t: " + thieutuoi);
        System.out.println("So Khach Chi Dung Tien Mat: " + tienmat);
        System.out.println("So Khach Chi Dung The Ngan Hang: " + thenganhang);
        System.out.println("So Khach Chi Dung Vi Dien Tu: " + vidientu);
        System.out.println("So Khach Dung The Ngan Hang va Vi Dien Tu: " + ca2);
    }

    public static void ThongKeHangHoa() {
        DsHangHoa dshh = new DsHangHoa();
        System.out.println("\nTong So Mat Hang: " + DsHangHoa.ds.length);
        double renhat = 10000000;
        String tenrenhat = "";
        double datnhat = 0;
        String tendatnhat = "";
        double tong = 0;
        for (HangHoa d : DsHangHoa.ds) {
            tong += d.getDongia();
            if (d.getDongia() > datnhat) {
                datnhat = d.getDongia();
                tendatnhat = d.getTenHang();
            }
            if (d.getDongia() < renhat) {
                renhat = d.getDongia();
                tenrenhat = d.getTenHang();
            }
        }
        System.out.println("Mat Hang Re Nhat: " + tenrenhat + "\tGia: " + renhat);
        System.out.println("Mat Hang Dat Nhat: " + tendatnhat + "\tGia: " + datnhat);
        System.out.printf("Gia Tri Trung Binh:%10.2f \n", tong / (DsHangHoa.ds.length));
    }

    public static void ThongKeXuatNhap() {
        DsHoaDon dshd = new DsHoaDon();
        DsPhieuNhapHang dspnh = new DsPhieuNhapHang();
        System.out.println("\nTong So Hoa Don Xuat: " + DsHoaDon.ds.length);
        System.out.println("Tong So Hoa Don Nhap: " + DsPhieuNhapHang.ds.length);
        double nhap = 0;
        double xuat = 0;
        double hdrenhat = 100000000;
        double hddatnhat = 0;
        double pnhrenhat = 100000000;
        double pnhdatnhat = 0;
        for (HoaDon d : DsHoaDon.ds) {
            xuat += d.Tongtien();
            if (d.Tongtien() > hddatnhat) {
                hddatnhat = d.Tongtien();
            }
            if (d.Tongtien() < hdrenhat) {
                hdrenhat = d.Tongtien();
            }
        }
        for (PhieuNhapHang d : DsPhieuNhapHang.ds) {
            nhap += d.ThanhTien();
            if (d.ThanhTien() > pnhdatnhat) {
                pnhdatnhat = d.ThanhTien();
            }
            if (d.ThanhTien() < pnhrenhat) {
                pnhrenhat = d.ThanhTien();
            }
        }
        System.out.println("Tong Tien Da Xuat: " + xuat);
        System.out.println("Tong Tien Da Nhap: " + nhap);
        System.out.println("Tong Loi Nhuan: " + (xuat - nhap));
        System.out.println("Hoa Don Re Nhat: " + hdrenhat + "\tHoa Don Dat Nhat: " + hddatnhat);
        System.out.println("Nhap Hang Re Nhat: " + pnhrenhat + "\tNhap Hang Dat Nhat: " + pnhdatnhat);
    }

    public static void menu() {
        int input;
        String so;
        do {
            do{
            System.out.println("\n---------Thong Ke-----------");
            System.out.println("1. Thong Ke Nhan Vien");
            System.out.println("2. Thong Ke Khach Hang");
            System.out.println("3. Thong Ke Hang Hoa");
            System.out.println("4. Thong Ke Xuat Nhap");
            System.out.println("0. Thoat");
            System.out.println("Nhap Vao Lua Chon Cua Ban: ");
            so = sc.nextLine();
            }while(!Check.KtSo(so));
            input = Integer.parseInt(so);
            switch (input) {
                case 1 ->
                    ThongKe.ThongKeNhanVien();
                case 2 ->
                    ThongKe.ThongKeKhachHang();
                case 3 ->
                    ThongKe.ThongKeHangHoa();
                case 4 ->
                    ThongKe.ThongKeXuatNhap();
            }
        } while (input != 0);
    }

    public static void main(String[] args) {
        ThongKe.menu();
    }
}
