package quanlysieuthimini;

public class NhanVien extends ThongTin {

    private String manv;
    private String chucvu;
    private double luongcb = 1500000;

    public NhanVien() {
    }

    public NhanVien(String manv, String chucvu) {
        this.manv = manv;
        this.chucvu = chucvu;
    }

    public NhanVien(String hoten, int namsinh, String cmnd, String diachi, String gioitinh, String sodt, String manv, String chucvu) {
        super(hoten, namsinh, cmnd, diachi, gioitinh, sodt);
        this.manv = manv;
        this.chucvu = chucvu;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public boolean KtChucVu(String chucvu) {
        if (!chucvu.equals("Quan Ly") && !chucvu.equals("Thu Ngan") && !chucvu.equals("Thu Kho")) {
            return false;
        }
        return true;
    }

    public double TinhLuong() {
        switch (this.chucvu) {
            case "Quan Ly" -> {
                return this.luongcb * 4;
            }
            case "Thu Ngan" -> {
                return this.luongcb * 2.5;
            }
            case "Thu Kho" -> {
                return this.luongcb * 2.2;
            }
        }
        return 0;
    }

    @Override
    public void nhap() {
        System.out.println("Nhap thong tin nhan vien: ");
        super.nhap();
        do {
            System.out.println("nhap vao ma nhan vien (gom 5 so) (vd:00001,...): ");
            this.manv = sc.nextLine();
        } while (!Check.KtMa(this.manv) || DsNhanVien.KtMaNvTrongDs(this.manv));
        do {
            System.out.println("nhap vao chuc vu (Quan Ly, Thu Ngan, Thu Kho): ");
            this.chucvu = sc.nextLine();
        } while (!this.KtChucVu(this.chucvu));
    }

    @Override
    public void xuat() {
        System.out.printf("\n|%-20s| %30s | %15s |", this.manv, super.getHoten(), this.chucvu);
    }

    public void chitiet() {
        System.out.printf("\n|%-20s| %30s | %10s | %15s | %50s | %10s | %15s | %15s | %10s |", "Ma Nhan Vien", "Ho Ten", "Nam Sinh", "CMND", "Dia Chi", "Gioi Tinh", "So Dien Thoai", "Chuc Vu", "Luong");
        System.out.printf("\n|%-20s| %30s | %10d | %15s | %50s | %10s | %15s | %15s | %10.2f |", this.manv, super.getHoten(), super.getNamsinh(), super.getCmnd(), super.getDiachi(), super.getGioitinh(), super.getSodt(), this.chucvu, this.TinhLuong());
        // Manv | HoTen | NamSinh | CMND | DiaChi | GioiTinh | SoDT | ChucVu | Luong |
    }

    public String nhanvientrongfile() {
        return this.getHoten() + "#" + this.getNamsinh() + "#" + this.getCmnd() + "#" + this.getDiachi() + "#" + this.getGioitinh() + "#" + this.getSodt() + "#" + this.getManv() + "#" + this.getChucvu() + "\n";
    }

    public static void main(String[] args) {

    }
}
