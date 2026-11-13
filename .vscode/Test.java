import java.util.ArrayList;

class Sach {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;

    public Sach(String maSach, String tenSach, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
    }

    public String getMaSach() {
        return maSach;
    }

    public void hienThiThongTin() {
        System.out.println("Mã sách: " + maSach + " | Tên sách: " + tenSach + 
                           " | Tác giả: " + tacGia + " | Năm XB: " + namXuatBan + 
                           " | Số lượng: " + soLuong);
    }
}

public class Test {
    public static void main(String[] args) {
        Sach s1 = new Sach("S001", "Lập trình Java cơ bản", "Nguyễn Văn A", 2020, 10);
        System.out.println("=== Thông tin một cuốn sách ===");
        s1.hienThiThongTin();
        System.out.println();

        ArrayList<Sach> danhSach = new ArrayList<>();
        danhSach.add(s1);
        danhSach.add(new Sach("S002", "Cấu trúc dữ liệu và giải thuật", "Trần Thị B", 2019, 5));
        danhSach.add(new Sach("S003", "Lập trình hướng đối tượng", "Lê Văn C", 2021, 8));
        danhSach.add(new Sach("S004", "Cơ sở dữ liệu", "Phạm Thị D", 2018, 12));

        System.out.println("=== Danh sách sách trong thư viện (" + danhSach.size() + " cuốn) ===");
        for (Sach s : danhSach) {
            s.hienThiThongTin();
        }
        System.out.println();

        String maCanTim = "S003";
        System.out.println("=== Tìm sách có mã " + maCanTim + " ===");
        boolean timThay = false;
        for (Sach s : danhSach) {
            if (s.getMaSach().equalsIgnoreCase(maCanTim)) {
                s.hienThiThongTin();
                timThay = true;
                break;
            }
        }
        if (!timThay) {
            System.out.println("Không tìm thấy sách.");
        }
        System.out.println();

        String maCanXoa = "S002";
        danhSach.removeIf(s -> s.getMaSach().equalsIgnoreCase(maCanXoa));
        System.out.println("=== Danh sách sau khi xóa sách " + maCanXoa + " (" + danhSach.size() + " cuốn) ===");
        for (Sach s : danhSach) {
            s.hienThiThongTin();
        }
    }
}