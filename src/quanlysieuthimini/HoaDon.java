package quanlysieuthimini;

import java.util.Scanner;

public class HoaDon {

    Scanner sc = new Scanner(System.in);
    private String mahd;
    private String manv;
    private String makh;
    private String ngaytao;
    private int loaihang;
    private String mahh[];
    private int soluong[];

    public HoaDon() {
    }

    public HoaDon(String mahd, String manv, String makh, String ngaytao, int loaihang, String[] mahh, int[] soluong) {
        this.mahd = mahd;
        this.manv = manv;
        this.makh = makh;
        this.ngaytao = ngaytao;
        this.loaihang = loaihang;
        this.mahh = mahh;
        this.soluong = soluong;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public int getLoaihang() {
        return loaihang;
    }

    public void setLoaihang(int loaihang) {
        this.loaihang = loaihang;
    }

    public String[] getMahh() {
        return mahh;
    }

    public void setMahh(String[] mahh) {
        this.mahh = mahh;
    }

    public int[] getSoluong() {
        return soluong;
    }

    public void setSoluong(int[] soluong) {
        this.soluong = soluong;
    }

    public double giacuahanghoa(String mahh) {
        for (int i = 0; i < DsHangHoa.ds.length; i++) {
            if (DsHangHoa.ds[i].getMaHang().equals(mahh)) {
                return DsHangHoa.ds[i].getDongia();
            }
        }
        return 0;
    }

    public double Tongtien() {
        double sum = 0;
        for (int i = 0; i < loaihang; i++) {
            sum += this.giacuahanghoa(mahh[i]) * soluong[i];
        }
        return sum;
    }
    
    public boolean KtLoaiHang(String loai){
        for(int i=0;i<loai.length();i++){
            if(loai.charAt(i)<'0' || loai.charAt(i) >'9')
                return false;
        }
        int Loaihang = Integer.parseInt(loai);
        if(Loaihang < 1) return false;
        return true;
    }

    public boolean KtSoLuong(String so) {
        for(int i=0;i<so.length();i++){
            if(so.charAt(i)<'0' || so.charAt(i) >'9')
                return false;
        }
        int Soluong = Integer.parseInt(so);
        if (Soluong <= 0 || Soluong > 100) {
            return false;
        }
        return true;
    }

    public void nhap() {
        System.out.println("\nNhap thong tin cho hoa don: ");
        do {
            System.out.println("\nnhap vao ma hoa don (gom 5 so)(vd:50001,...): ");
            this.mahd = sc.nextLine();
        } while (!Check.KtMa(this.mahd) || DsHoaDon.KtMaHdTrongDs(this.mahd));
        DsNhanVien dsnv = new DsNhanVien();
        dsnv.xuat();
        do {
            System.out.println("\nnhap vao ma nhan vien (gom 5 so): ");
            this.manv = sc.nextLine();
        } while (!Check.KtMa(this.manv) || !DsNhanVien.KtMaNvTrongDs(this.manv));
        
        DsKhachHang dskh = new DsKhachHang();
        dskh.xuat();
        do {
            System.out.println("\nnhap vao ma khach hang (gom 5 so): ");
            this.makh = sc.nextLine();
        } while (!Check.KtMa(this.makh) || !DsKhachHang.KtMaKhTrongDs(this.makh));
        do {
            System.out.println("\nnhap vao ngay tao (vd: 21/07/2003...): ");
            this.ngaytao = sc.nextLine();
        } while (!Check.KtNgay(this.ngaytao));
        String x;
        do{
        System.out.println("\nnhap vao so loai hang hoa trong hoa don: ");
        x = sc.nextLine();
        }while(!this.KtLoaiHang(x));
        this.loaihang = Integer.parseInt(x);
        this.mahh = new String[loaihang];
        this.soluong = new int[loaihang];
        DsHangHoa dshh = new DsHangHoa();
        dshh.xuat();
        for (int i = 0; i < loaihang; i++) {
            do {
                System.out.println("\nNhap ma hang hoa: ");
                this.mahh[i] = sc.nextLine();
            } while (!Check.KtMa(this.mahh[i]) || !DsHangHoa.KtMaHangTrongDs(this.mahh[i]));
            String y;
            do {
                System.out.println("\nNhap so luong (0 < soluong < 100): ");
                y = sc.nextLine();               
            } while (!this.KtSoLuong(y));
            this.soluong[i] = Integer.parseInt(y);
        }
    }

    public void xuat() {
        System.out.printf("\n%-15s | %-15s | %-15s | %15s | %15.2f |", this.mahd, this.manv, this.makh, this.ngaytao, this.Tongtien());
        //MaHd | MaNv | MaKh | Ngay | TongTien
    }

    public void chitiet() {
        System.out.println("\n--------------------Hoa Don---------------------");
        System.out.printf("\n%15s : %10s", "Ma Hoa Don", this.mahd);
        System.out.printf("\n%15s : %10s", "Ma Nhan Vien", this.manv);
        System.out.printf("\n%15s : %10s", "Ma Khach Hang", this.makh);
        System.out.printf("\n%15s : %10s", "Ngay Mua Hang", this.ngaytao);
        System.out.println("\n------------------------------------------------");
        System.out.println("Chi Tiet Hang Hoa:");
        for (int i = 0; i < this.loaihang; i++) {
            HangHoa hh = new HangHoa();
            hh = Check.LayHangHoaTuMaHh(this.mahh[i]);
            hh.xuat();
            System.out.printf("\n%-40s : %15d", "So Luong", this.soluong[i]);
        }
        System.out.printf("\n\n\n%40s : %15.2f ", "Tong Tien", this.Tongtien());
    }

    public String hoadontrongfile() {
        String hang = "";
        String sohang = "";
        for (int i = 0; i < loaihang; i++) {
            if (i < loaihang - 1) {
                hang += mahh[i] + "/";
                sohang += soluong[i] + "/";
            } else {
                hang += mahh[i];
                sohang += soluong[i];
            }
        }
        return this.mahd + "#" + this.manv + "#" + this.makh + "#" + this.ngaytao + "#" + this.loaihang + "#" + hang + "#" + sohang + "\n";
    }

}
