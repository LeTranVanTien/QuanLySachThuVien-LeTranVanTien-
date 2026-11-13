import java.util.ArrayList;
import java.util.Scanner;
// Lớp Sach đại diện cho thông tin một cuốn sách (giữ nguyên từ bài trước)
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
public class BaiTapTuan5
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Sach> danhSachSach = new ArrayList<>();
        int luaChon = 0;
        // Menu lặp chạy liên tục cho đến khi chọn Thoát (8)
        do {
            System.out.println("\n=================== MENU QUẢN LÝ THƯ VIỆN ===================");
            System.out.println("1. Thêm sách");
            System.out.println("2. Hiển thị sách");
            System.out.println("3. Tìm sách");
            System.out.println("4. Xóa sách");
            System.out.println("5. Sửa sách");
            System.out.println("6. Tính tổng số lượng");
            System.out.println("7. Tính tổng giá trị");
            System.out.println("8. Thoát");
            System.out.println("=============================================================");
            System.out.print("Nhập lựa chọn của bạn (1-8): ");
            try {
                luaChon = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập số từ 1 đến 8.");
                continue;
            }

            switch (luaChon) {
                case 1:
                    // 1. Thêm sách
                    System.out.print("Nhập mã sách: ");
                    String ma = scanner.nextLine();
                    System.out.print("Nhập tên sách: ");
                    String ten = scanner.nextLine();
                    System.out.print("Nhập số lượng: ");
                    int sl = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhập giá tiền: ");
                    double gia = Double.parseDouble(scanner.nextLine());
                    danhSachSach.add(new Sach(ma, ten, sl, gia));
                    System.out.println("-> Thêm sách thành công!");
                    break;
                case 2:
                    // 2. Hiển thị sách
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
                    // 3. Tìm sách theo mã
                    if (danhSachSach.isEmpty()) {
                        System.out.println("Thư viện trống!");
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
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("-> Không tìm thấy sách có mã: " + maTim);
                    }
                    break;
                case 4:
                    // 4. Xóa sách theo mã
                    if (danhSachSach.isEmpty()) {
                        System.out.println("Thư viện trống!");
                        break;
                    }
                    System.out.print("Nhập mã sách cần xóa: ");
                    String maXoa = scanner.nextLine();
                    boolean removed = false;
                    for (int i = 0; i < danhSachSach.size(); i++) {
                        if (danhSachSach.get(i).getMaSach().equalsIgnoreCase(maXoa)) {
                            danhSachSach.remove(i);
                            System.out.println("-> Đã xóa thành công sách có mã: " + maXoa);
                            removed = true;
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("-> Không tìm thấy mã sách cần xóa!");
                    }
                    break;
                case 5:
                    // 5. Sửa sách theo mã
                    if (danhSachSach.isEmpty()) {
                        System.out.println("Thư viện trống!");
                        break;
                    }
                    System.out.print("Nhập mã sách cần sửa: ");
                    String maSua = scanner.nextLine();
                    boolean updated = false;
                    for (Sach s : danhSachSach) {
                        if (s.getMaSach().equalsIgnoreCase(maSua)) {
                            System.out.print("Nhập tên sách mới: ");
                            s.setTenSach(scanner.nextLine());
                            System.out.print("Nhập số lượng mới: ");
                            s.setSoLuong(Integer.parseInt(scanner.nextLine()));
                            System.out.print("Nhập giá tiền mới: ");
                            s.setGiaTien(Double.parseDouble(scanner.nextLine()));
                            System.out.println("-> Cập nhật thông tin thành công!");
                            updated = true;
                            break;
                        }
                    }
                    if (!updated) {
                        System.out.println("-> Không tìm thấy mã sách cần sửa!");
                    }
                    break;
                case 6:
                    // 6. Tính tổng số lượng sách
                    if (danhSachSach.isEmpty()) {
                        System.out.println("Thư viện trống!");
                        break;
                    }
                    int tongSoLuong = 0;
                    for (Sach s : danhSachSach) {
                        tongSoLuong += s.getSoLuong();
                    }
                    System.out.println("-> Tổng số lượng tất cả các sách trong thư viện: " + tongSoLuong);
                    break;
                case 7:
                    // 7. Tính tổng giá trị sách (Số lượng * Giá tiền)
                    if (danhSachSach.isEmpty()) {
                        System.out.println("Thư viện trống!");
                        break;
                    }
                    double tongGiaTri = 0;
                    for (Sach s : danhSachSach) {
                        tongGiaTri += (s.getSoLuong() * s.getGiaTien());
                    }
                    System.out.printf("-> Tổng giá trị kho sách: %.2f\n", tongGiaTri);
                    break;
                case 8:
                    // 8. Thoát chương trình
                    System.out.println("Đang thoát chương trình. Tạm biệt bạn!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn từ 1 đến 8.");
            }
        } while (luaChon != 8);
        scanner.close();
    }
}