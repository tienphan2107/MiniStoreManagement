package quanlysieuthimini;

public class Check {
    public static boolean KtSo(String so){
        if(so.length() == 0) return false;
        for(int i=0;i<so.length();i++){
            if(so.charAt(i) < '0' || so.charAt(i)>'9')
                return false;
        }
        return true;
    }
    public static boolean KtMa(String ma) {
        if (ma.length() != 5) {
            return false;
        }
        for (int i = 0; i < 5; i++) {
            if (ma.charAt(i) < '0' || ma.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean KtDiaChi(String diachi) {
        if (diachi.length() <= 20) {
            return false;
        }
        return true;
    }

    public static boolean KtSodt(String sodt) {

        if (sodt.length() != 10) {
            return false;
        }
        if (sodt.charAt(0) != '0') {
            return false;
        }
        for (int i = 1; i < 10; i++) {
            if (sodt.charAt(i) < '0' || sodt.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean KtNgay(String ngay) {  //kiem tra xem ngay dang xet co hop le khong
        String ngaythangnam[] = ngay.split("/");
        int songay = Integer.parseInt(ngaythangnam[0]);
        int sothang = Integer.parseInt(ngaythangnam[1]);
        int sonam = Integer.parseInt(ngaythangnam[2]);
        if (2022 - sonam > 50 || 2022 - sonam < 0) {
            return false;
        }
        if (sothang < 1 || sothang > 12) {
            return false;
        }
        if (songay < 1 || songay > songaytrongthang(sothang, sonam)) {
            return false;
        }
        return true;

    }

    public static boolean namnhuan(int nam) {  // kiem tra xem nam dang xet co phai nam nhuan khong 
        if ((nam % 4 == 0 && nam % 100 != 0) || nam % 400 == 0) {
            return true;
        }
        return false;
    }

    public static int songaytrongthang(int thang, int nam) { // tim so ngay trong thang tuong ung
        switch (thang) {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                return 31;
            }
            case 4, 6, 9, 11 -> {
                return 30;
            }
            case 2 -> {
                if (namnhuan(nam)) {
                    return 29;
                }
                return 28;
            }
        }
        return 0;
    }

    public static HangHoa LayHangHoaTuMaHh(String mahh) {

        for (int i = 0; i < DsHangHoa.ds.length; i++) {
            if (DsHangHoa.ds[i].getMaHang().equals(mahh)) {
                return DsHangHoa.ds[i];
            }
        }
        return null;
    }

    public static boolean KtHoTen(String hoten) {
        if (hoten.length() <= 0) {
            return false;
        }
        for (int i = 0; i < hoten.length(); i++) {
            if (hoten.charAt(i) >= '0' && hoten.charAt(i) <= '9') {
                return false;
            }
        }
        return true;
    }

}
