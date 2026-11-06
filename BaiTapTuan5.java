import java.util.ArrayList;
import java.util.Scanner;
// Lớp Sach đại diện cho một cuốn sách trong thư viện
class Sach {
    private String maSach;
    private String tenSach;
    private int soLuong;
    private double giaTien;
    // Constructor khởi tạo thông tin sách
    public Sach(String maSach, String tenSach, int soLuong, double giaTien) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
    }
    public String getMaSach() {
        return maSach;
    }
    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }
    public String getTenSach() {
        return tenSach;
    }
    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }
    public int getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public double getGiaTien() {
        return giaTien;
    }
    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }
    @Override
    public String toString() {
        return String.format("%-15s | %-25s | %-10d | %-12.2f", maSach, tenSach, soLuong, giaTien);
    }
}
public class BaiTapTuan5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Sach> danhSachSach = new ArrayList<>();
        int luaChon = 0;
        // Bài 3: Menu lặp đến khi chọn Thoát (sử dụng vòng lặp do-while)
        do {
            System.out.println("\n=================== QUẢN LÝ THƯ VIỆN - TUẦN 5 ===================");
            System.out.println("1. Bài 1: Nhập n sách bằng vòng lặp");
            System.out.println("2. Hiển t2hị danh sách sách");
            System.out.println("3. Bài 4: Tìm sách theo mã");
            System.out.println("4. Bài 2: Tính tổng số lượng và tổng giá trị sách");
            System.out.println("5. Thoát");
            System.out.println("================================================================");
            System.out.print("Nhập lựa chọn của bạn (1-5): ");
            try {
                luaChon = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập số từ 1 đến 5.");
                continue;
            }
            switch (luaChon) {
                case 1:
                    // Bài 1: Nhập n sách bằng vòng lặp for
                    System.out.print("Nhập số lượng sách cần thêm (n): ");
                    int n = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < n; i++) {
                        System.out.println("\n--- Nhập thông tin cuốn sách thứ " + (i + 1) + " ---");
                        System.out.print("Nhập mã sách: ");
                        String ma = scanner.nextLine();
                        System.out.print("Nhập tên sách: ");
                        String ten = scanner.nextLine();
                        System.out.print("Nhập số lượng: ");
                        int sl = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nhập giá tiền: ");
                        double gia = Double.parseDouble(scanner.nextLine());

                        danhSachSach.add(new Sach(ma, ten, sl, gia));
                    }
                    System.out.println("-> Đã nhập thành công " + n + " cuốn sách!");
                    break;
                case 2:
                    // Hiển thị toàn bộ danh sách sách trong thư viện
                    if (danhSachSach.isEmpty()) {
                        System.out.println("Thư viện hiện chưa có cuốn sách nào!");
                    } else {
                        System.out.println("\n-------------------- DANH SÁCH SÁCH TRONG THƯ VIỆN --------------------");
                        System.out.printf("%-15s | %-25s | %-10s | %-12s\n", "Mã Sách", "Tên Sách", "Số Lượng", "Giá Tiền");
                        System.out.println("-----------------------------------------------------------------------");
                        for (Sach s : danhSachSach) {
                            System.out.println(s);
                        }
                    }
                    break;
                case 3:
                    // Bài 4: Tìm sách theo mã sử dụng vòng lặp
                    if (danhSachSach.isEmpty()) {
                        System.out.println("Thư viện trống, chưa có dữ liệu để tìm kiếm!");
                        break;
                    }
                    System.out.print("Nhập mã sách cần tìm: ");
                    String maTim = scanner.nextLine();
                    boolean found = false;
                    for (Sach s : danhSachSach) {
                        if (s.getMaSach().equalsIgnoreCase(maTim)) {
                            System.out.println("-> Đã tìm thấy cuốn sách:");
                            System.out.printf("%-15s | %-25s | %-10s | %-12s\n", "Mã Sách", "Tên Sách", "Số Lượng", "Giá Tiền");
                            System.out.println("-----------------------------------------------------------------------");
                            System.out.println(s);
                            found = true;
                            break; // Tìm thấy thì dừng vòng lặp
                        }
                    }
                    if (!found) {
                        System.out.println("-> Không tìm thấy sách có mã: " + maTim);
                    }
                    break;
                case 4:
                    // Bài 2: Tính tổng số lượng và tổng giá trị sách bằng vòng lặp
                    if (danhSachSach.isEmpty()) {
                        System.out.println("Thư viện trống!");
                        break;
                    }
                    int tongSoLuong = 0;
                    double tongGiaTri = 0;
                    for (Sach s : danhSachSach) {
                        tongSoLuong += s.getSoLuong();
                        tongGiaTri += (s.getSoLuong() * s.getGiaTien());
                    }
                    System.out.println("\n--- KẾT QUẢ TÍNH TOÁN ---");
                    System.out.println("Tổng số lượng sách trong thư viện: " + tongSoLuong);
                    System.out.printf("Tổng giá trị kho sách (Số lượng x Giá tiền): %.2f\n", tongGiaTri);
                    break;
                case 5:
                    System.out.println("Đang thoát chương trình. Tạm biệt bạn!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn từ 1 đến 5.");
            }
        } while (luaChon != 5);
        scanner.close();
    }
}