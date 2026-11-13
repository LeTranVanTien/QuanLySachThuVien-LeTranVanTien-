import java.util.ArrayList;
import java.util.Calendar;

// Lớp Sach tuân thủ tính chất đóng gói (Bài tập tuần 8)
class Sach {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;

    // Constructor mặc định
    public Sach() {
    }

    // Constructor đầy đủ tham số
    public Sach(String maSach, String tenSach, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        setNamXuatBan(namXuatBan); // Gọi setter để kiểm tra ràng buộc
        setSoLuong(soLuong);       // Gọi setter để kiểm tra ràng buộc
    }

    // Các phương thức Getter
    public String getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    // Các phương thức Setter kèm ràng buộc dữ liệu
    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public void setNamXuatBan(int namXuatBan) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (namXuatBan > 0 && namXuatBan <= currentYear) {
            this.namXuatBan = namXuatBan;
        } else {
            System.out.println("Lỗi: Năm xuất bản " + namXuatBan + " không hợp lệ!");
        }
    }

    public void setSoLuong(int soLuong) {
        if (soLuong >= 0) {
            this.soLuong = soLuong;
        } else {
            System.out.println("Lỗi: Số lượng không được âm!");
        }
    }

    // Phương thức hiển thị thông tin sách
    public void hienThiThongTin() {
        System.out.println("Mã sách: " + maSach + " | Tên sách: " + tenSach + 
                           " | Tác giả: " + tacGia + " | Năm XB: " + namXuatBan + 
                           " | Số lượng: " + soLuong);
    }
}

// Lớp chính BaiTapTuan5 (Khớp với tên file BaiTapTuan5.java)
public class BaiTapTuan5 {
    public static void main(String[] args) {
        // Kiểm tra ràng buộc dữ liệu (Tuần 8)
        System.out.println("=== Kiểm tra ràng buộc dữ liệu (Tuần 8) ===");
        Sach testSach = new Sach();
        testSach.setNamXuatBan(2030); // Test năm không hợp lệ
        testSach.setSoLuong(-5);     // Test số lượng âm
        System.out.println();

        // Yêu cầu 3 (Tuần 7): tạo đối tượng từ lớp Sach
        Sach s1 = new Sach("S001", "Lập trình Java cơ bản", "Nguyễn Văn A", 2020, 10);
System.out.println("=== Thông tin một cuốn sách ===");
        s1.hienThiThongTin();
        System.out.println();

        // Yêu cầu 4 (Tuần 7): tạo và quản lý danh sách Sach bằng ArrayList
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

        // Tìm kiếm theo mã sách
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

        // Xóa sách theo mã
        String maCanXoa = "S002";
        danhSach.removeIf(s -> s.getMaSach().equalsIgnoreCase(maCanXoa));
        System.out.println("=== Danh sách sau khi xóa sách " + maCanXoa + " (" + danhSach.size() + " cuốn) ===");
        for (Sach s : danhSach) {
            s.hienThiThongTin();
        }
    }
}
import java.util.ArrayList;
import java.util.Calendar;

// Lớp Sach tuân thủ tính chất đóng gói (Bài tập tuần 8)
class Sach {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;

    // Constructor mặc định
    public Sach() {
    }

    // Constructor đầy đủ tham số
    public Sach(String maSach, String tenSach, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        setNamXuatBan(namXuatBan); // Gọi setter để kiểm tra ràng buộc
        setSoLuong(soLuong);       // Gọi setter để kiểm tra ràng buộc
    }

    // Các phương thức Getter
    public String getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    // Các phương thức Setter kèm ràng buộc dữ liệu
    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public void setNamXuatBan(int namXuatBan) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (namXuatBan > 0 && namXuatBan <= currentYear) {
            this.namXuatBan = namXuatBan;
        } else {
            System.out.println("Lỗi: Năm xuất bản " + namXuatBan + " không hợp lệ!");
        }
    }

    public void setSoLuong(int soLuong) {
        if (soLuong >= 0) {
            this.soLuong = soLuong;
        } else {
            System.out.println("Lỗi: Số lượng không được âm!");
        }
    }

    // Phương thức hiển thị thông tin sách
    public void hienThiThongTin() {
        System.out.println("Mã sách: " + maSach + " | Tên sách: " + tenSach + 
                           " | Tác giả: " + tacGia + " | Năm XB: " + namXuatBan + 
                           " | Số lượng: " + soLuong);
    }
}

// Lớp chính BaiTapTuan5 (Khớp với tên file BaiTapTuan5.java)
public class BaiTapTuan5 {
    public static void main(String[] args) {
        // Kiểm tra ràng buộc dữ liệu (Tuần 8)
        System.out.println("=== Kiểm tra ràng buộc dữ liệu (Tuần 8) ===");
        Sach testSach = new Sach();
        testSach.setNamXuatBan(2030); // Test năm không hợp lệ
        testSach.setSoLuong(-5);     // Test số lượng âm
        System.out.println();

        // Yêu cầu 3 (Tuần 7): tạo đối tượng từ lớp Sach
        Sach s1 = new Sach("S001", "Lập trình Java cơ bản", "Nguyễn Văn A", 2020, 10);
System.out.println("=== Thông tin một cuốn sách ===");
        s1.hienThiThongTin();
        System.out.println();

        // Yêu cầu 4 (Tuần 7): tạo và quản lý danh sách Sach bằng ArrayList
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

        // Tìm kiếm theo mã sách
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

        // Xóa sách theo mã
        String maCanXoa = "S002";
        danhSach.removeIf(s -> s.getMaSach().equalsIgnoreCase(maCanXoa));
        System.out.println("=== Danh sách sau khi xóa sách " + maCanXoa + " (" + danhSach.size() + " cuốn) ===");
        for (Sach s : danhSach) {
            s.hienThiThongTin();
        }
    }
}
