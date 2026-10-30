import java.util.Scanner;
public class BaiTapTuan4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== NHAP THONG TIN SACH (TUAN 4) ===");
        System.out.print("Nhap ma sach: ");
        String maSach = scanner.nextLine();
        System.out.print("Nhap ten sach: ");
        String tenSach = scanner.nextLine();
        System.out.print("Nhap tac gia: ");
        String tacGia = scanner.nextLine();
        System.out.print("Nhap nam xuat ban: ");
        int namXuatBan = scanner.nextInt();
        System.out.print("Nhap don gia: ");
        double donGia = scanner.nextDouble();
        System.out.print("Nhap so luong: ");
        int soLuong = scanner.nextInt();
        System.out.println("\n--- CHON LOAI SACH ---");
        System.out.println("1. Sach giao khoa");
        System.out.println("2. Sach tham khao");
        System.out.println("3. Sach chuyen nganh");
        System.out.println("4. Sach khac");
        System.out.print("Nhap lua chon cua ban (1-4): ");
        int loaiSach = scanner.nextInt();
        System.out.println("Ket qua:");
        // bài 1
        boolean hopLe = true;
        if (donGia <= 0) {
            System.out.println("  - Loi Don gia phai lon hon 0.");
            hopLe = false;
        }
        if (soLuong < 0) {
            System.out.println("  - Loi: So luong khong duoc nho hon 0.");
            hopLe = false;
        }
        if (namXuatBan <= 0 || namXuatBan > 2026) {
            System.out.println("  - Loi: Nam xuat ban khong hop le.");
            hopLe = false;
        }
        if (hopLe) {
            System.out.println("  -> Thong tin sach hop le thanh cong!");
        }
        //bài2
        if (donGia < 50000) {
            System.out.println("  -> Sach gia thap");
        } else if (donGia <= 100000) {
            System.out.println("  -> Sach gia trung binh");
        } else if (donGia <= 200000) {
            System.out.println("  -> Sach gia cao");
        } else {
            System.out.println("  -> Sach gia dac biet ");
        }
        //bài 3
        if (soLuong == 0) {
            System.out.println("  -> Het sach");
        } else if (soLuong >= 1 && soLuong <= 5) {
            System.out.println("  -> Sap het");
        } else if (soLuong >= 6 && soLuong <= 20) {
            System.out.println("  -> Con it");
        } else {
            System.out.println("  -> Con nhieu");
        }
        //bài 4
        switch (loaiSach) {
            case 1:
                System.out.println("  -> Loai sach: Sach giao khoa");
                break;
            case 2:
                System.out.println("  -> Loai sach: Sach tham khao");
                break;
            case 3:
                System.out.println("  -> Loai sach: Sach chuyen nganh   ");
                break;
            case 4:
                System.out.println("  -> Loai sach: Sach khac   ");
                break;
            default:
                System.out.println("  -> Lua chon khong hop le");
                break;
        }
        scanner.close();
    }
}
