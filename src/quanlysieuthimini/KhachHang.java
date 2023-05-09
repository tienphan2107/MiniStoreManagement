package quanlysieuthimini;

public class KhachHang extends ThongTin {

    private String makh;
    private ThanhToan thanhtoan = new ThanhToan();

    public KhachHang() {
    }

    public KhachHang(String makh) {
        this.makh = makh;
    }

    public KhachHang(String hoten, int namsinh, String cmnd, String diachi, String gioitinh, String sodt, String makh, int sophuongthuc) {
        super(hoten, namsinh, cmnd, diachi, gioitinh, sodt);
        this.makh = makh;
        this.thanhtoan.setSophuongthuc(sophuongthuc);
    }

    public KhachHang(String hoten, int namsinh, String cmnd, String diachi, String gioitinh, String sodt, String makh, int sophuongthuc, String sotk, String tennh, String chutk, String tenvi, String sovi) {
        super(hoten, namsinh, cmnd, diachi, gioitinh, sodt);
        this.makh = makh;
        this.thanhtoan.setSophuongthuc(sophuongthuc);
        this.thanhtoan.ptchuyenkhoan.setSotaikhoan(sotk);
        this.thanhtoan.ptchuyenkhoan.setTennganhang(tennh);
        this.thanhtoan.ptchuyenkhoan.setChutaikhoan(chutk);
        this.thanhtoan.ptvidientu.setTenvi(tenvi);
        this.thanhtoan.ptvidientu.setSovi(sovi);
    }

    public KhachHang(String hoten, int namsinh, String cmnd, String diachi, String gioitinh, String sodt, String makh, int sophuongthuc, String sotk, String tennh, String chutk) {
        super(hoten, namsinh, cmnd, diachi, gioitinh, sodt);
        this.makh = makh;
        this.thanhtoan.setSophuongthuc(sophuongthuc);
        this.thanhtoan.ptchuyenkhoan.setSotaikhoan(sotk);
        this.thanhtoan.ptchuyenkhoan.setTennganhang(tennh);
        this.thanhtoan.ptchuyenkhoan.setChutaikhoan(chutk);
    }

    public KhachHang(String hoten, int namsinh, String cmnd, String diachi, String gioitinh, String sodt, String makh, int sophuongthuc, String tenvi, String sovi) {
        super(hoten, namsinh, cmnd, diachi, gioitinh, sodt);
        this.makh = makh;
        this.thanhtoan.setSophuongthuc(sophuongthuc);
        this.thanhtoan.ptvidientu.setTenvi(tenvi);
        this.thanhtoan.ptvidientu.setSovi(sovi);
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public ThanhToan getThanhtoan() {
        return thanhtoan;
    }

    public void setThanhtoan(ThanhToan thanhtoan) {
        this.thanhtoan = thanhtoan;
    }

    @Override
    public void nhap() {
        System.out.println("Nhap thong tin khach hang:");
        super.nhap();
        do {
            System.out.println("nhap vao ma khach hang (gom 5 so)(vd: 10001,...): ");
            this.makh = sc.nextLine();
        } while (!Check.KtMa(this.makh) || DsKhachHang.KtMaKhTrongDs(this.makh));
        this.thanhtoan.nhap();
    }

    @Override
    public void xuat() {
        System.out.printf("\n|%-20s| %30s |", this.makh, super.getHoten());
    }

    public void chitiet() {
        System.out.printf("\n|%-20s| %30s | %10s | %15s | %50s | %10s | %15s |", "Ma Khach Hang", "Ho Ten", "Nam Sinh", "CMND", "Dia Chi", "Gioi Tinh", "So Dien Thoai");

        System.out.printf("\n|%-20s| %30s | %10d | %15s | %50s | %10s | %15s |", this.makh, super.getHoten(), super.getNamsinh(), super.getCmnd(), super.getDiachi(), super.getGioitinh(), super.getSodt());
        // MaKH | HoTen | NamSinh | CMND | DiaChi | GioiTinh | SoDT | 
        this.thanhtoan.xuat();
    }

    public String khachhangtrongfile() {
        if (this.thanhtoan.sophuongthuc == 2) {
            return this.getHoten() + "#" + this.getNamsinh() + "#" + this.getCmnd() + "#" + this.getDiachi() + "#" + this.getGioitinh() + "#" + this.getSodt() + "#" + this.getMakh() + "#" + this.thanhtoan.sophuongthuc + "#" + this.thanhtoan.ptchuyenkhoan.chuyenkhoantrongfile() + "#" + this.thanhtoan.ptvidientu.vidientutrongfile() + "\n";
        }
        if (this.thanhtoan.ptchuyenkhoan.getSotaikhoan() != null) {
            return this.getHoten() + "#" + this.getNamsinh() + "#" + this.getCmnd() + "#" + this.getDiachi() + "#" + this.getGioitinh() + "#" + this.getSodt() + "#" + this.getMakh() + "#" + this.thanhtoan.sophuongthuc + "#" + this.thanhtoan.ptchuyenkhoan.chuyenkhoantrongfile() + "\n";
        }
        if (this.thanhtoan.ptvidientu.getSovi() != null) {
            return this.getHoten() + "#" + this.getNamsinh() + "#" + this.getCmnd() + "#" + this.getDiachi() + "#" + this.getGioitinh() + "#" + this.getSodt() + "#" + this.getMakh() + "#" + this.thanhtoan.sophuongthuc + "#" + this.thanhtoan.ptvidientu.vidientutrongfile() + "\n";
        } else {
            return this.getHoten() + "#" + this.getNamsinh() + "#" + this.getCmnd() + "#" + this.getDiachi() + "#" + this.getGioitinh() + "#" + this.getSodt() + "#" + this.getMakh() + "#" + this.thanhtoan.sophuongthuc + "\n";
        }
    }

    public static void main(String[] args) {
        KhachHang a = new KhachHang();
        a.nhap();
        String kh[] = a.khachhangtrongfile().split("#");
        System.out.println("day la: " + kh[2]);
        System.out.println(kh.length);
        System.out.println(a.khachhangtrongfile());
    }
}
