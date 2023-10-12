package ra.run;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import ra.bussinessImp.Book;

import java.util.*;

public class BookManagement {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Book> bookArrayList = new ArrayList<>();

    static {
        bookArrayList.add(new Book(1, "book1", "title1", 10, 1400, 3500, 0, true));
        bookArrayList.add(new Book(2, "book3", "title2", 20, 2000, 4500, 0, true));
        bookArrayList.add(new Book(3, "book2", "title3", 30, 2200, 3500, 0, true));
    }


    public static void main(String[] args) {
        for (Book book : bookArrayList) {
            book.displayData();
        }
        while (true) {
            System.out.println("********** BASIC MENU **********");
            System.out.println("1. Nhập thông tin");
            System.out.println("2. Hiển thị thông tin");
            System.out.println("3. Sắp xếp giảm dần theo lợi nhuận");
            System.out.println("4. Xóa theo mã sách");
            System.out.println("5. Tìm theo mã sách");
            System.out.println("6. Sửa trạng thái sách");
            System.out.println("7. Thoát");
            System.out.println("Nhập vào lựa chọn:");
            int choice = Integer.parseInt(scanner.nextLine());
            handleChoice(choice);
        }
    }

    private static void handleChoice(int choice) {
        switch (choice) {
            case 1:
                handleAdd();
                break;
            case 2:
                handleDisplay();
                break;
            case 3:
                handleSortByDecent();
                break;
            case 4:
                handleDelete();
                break;
            case 5:
                handleFindByBookId();
                break;
            case 6:
                handleEdit();
                break;
            case 7:
                System.exit(0);
                break;
            default:
                System.out.println("Không có lựa chọn này !");
                break;

        }
    }

    private static void handleEdit() {
        handleDisplay();
        System.out.println("Nhập mã sách bạn muốn sửa: ");
        int editId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < bookArrayList.size(); i++) {
            if (bookArrayList.get(i).getBookId() == editId) {
                bookArrayList.get(i).displayData();
                System.out.println("Chọn thuộc tính bạn muốn sửa: ");
                System.out.println("1. Tên sách: ");
                System.out.println("2. Tiêu đề sách: ");
                System.out.println("3. Số sách: ");
                System.out.println("4. Giá nhập: ");
                System.out.println("5. Giá bán: ");
                System.out.println("6. Trạng thái: ");
                System.out.println("7. Thoát: ");
                int select = Integer.parseInt(scanner.nextLine());
                if (select == 7) {
                    return;
                }
                handleSelect(select);
                break;
            }
        }
    }

    private static void handleSelect(int select) {
        switch (select) {
            case 1:
                handleEditByName();
                break;
            case 2:
                handleEditByTitle();
                break;
            case 3:
                handleEditByNumberOfPage();
                break;
            case 4:
                handleEditByImportPrice();
                break;
            case 5:
                handleEditByExportPrice();
                break;
            case 6:
                handleEditByBookStatus();
                break;
            case 7:
                System.exit(0);
                break;
            default:
                System.out.println("Không có lựa chọn này !");
                System.exit(1);

        }
    }

    private static void handleEditByBookStatus() {
        for (int i = 0; i < bookArrayList.size(); i++) {
            System.out.println("Trạng thái cũ là: " + bookArrayList.get(i).isBookStatus());
            System.out.println("Mời thay đổi: ");
            boolean status = Boolean.parseBoolean(scanner.nextLine());
            bookArrayList.get(i).setBookStatus(status);
            System.out.println("Trạng thái sau khi thay đổi: " + bookArrayList.get(i).isBookStatus());
            break;
        }
    }

    private static void handleEditByExportPrice() {
        for (int i = 0; i < bookArrayList.size(); i++) {
            System.out.println("Giá bán cũ là: " + bookArrayList.get(i).getExportPrice());
            System.out.println("Mời thay đổi: ");
            int exportNum = Integer.parseInt(scanner.nextLine());
            bookArrayList.get(i).setImportPrice(exportNum);
            System.out.println("Giá bán sau khi thay đổi: " + bookArrayList.get(i).getExportPrice());
            break;
        }
    }

    private static void handleEditByImportPrice() {
        for (int i = 0; i < bookArrayList.size(); i++) {
            System.out.println("Giá nhập cũ là: " + bookArrayList.get(i).getImportPrice());
            System.out.println("Mời thay đổi: ");
            int importNum = Integer.parseInt(scanner.nextLine());
            bookArrayList.get(i).setImportPrice(importNum);
            System.out.println("Giá nhập sau khi thay đổi: " + bookArrayList.get(i).getImportPrice());
            break;
        }
    }

    private static void handleEditByNumberOfPage() {
        for (int i = 0; i < bookArrayList.size(); i++) {
            System.out.println("Số trang cũ là: " + bookArrayList.get(i).getNumberOfPages());
            System.out.println("Mời thay đổi: ");
            int number = Integer.parseInt(scanner.nextLine());
            bookArrayList.get(i).setNumberOfPages(number);
            System.out.println("Số trang sau khi thay đổi: " + bookArrayList.get(i).getNumberOfPages());
            break;
        }
    }

    private static void handleEditByTitle() {
        for (int i = 0; i < bookArrayList.size(); i++) {
            System.out.println("Tiêu đề cũ là: " + bookArrayList.get(i).getTitle());
            System.out.println("Mời thay đổi: ");
            String title = scanner.nextLine();
            bookArrayList.get(i).setTitle(title);
            System.out.println("Tiêu đề sau khi thay đổi: " + bookArrayList.get(i).getTitle());
            break;
        }
    }

    private static void handleEditByName() {
        for (int i = 0; i < bookArrayList.size(); i++) {
            System.out.println("Tên cũ là: " + bookArrayList.get(i).getBookName());
            System.out.println("Mời thay đổi: ");
            String name = scanner.nextLine();
            bookArrayList.get(i).setBookName(name);
            System.out.println("Tên sau khi thay đổi: " + bookArrayList.get(i).getBookName());
            break;
        }
    }

    private static void handleFindByBookId() {
        handleDisplay();
        System.out.println("Nhập vào mã sách bạn muốn tìm: ");
        int findBookId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < bookArrayList.size(); i++) {
            if (bookArrayList.get(i).getBookId() == findBookId) {
                bookArrayList.get(i).displayData();
            }
        }
        System.out.println("Finded Done !");
    }

    private static void handleDelete() {
        handleDisplay();
        System.out.println("Nhập vào mã sách cần xóa: ");
        int deleteBookId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < bookArrayList.size(); i++) {
            if (bookArrayList.get(i).getBookId() == deleteBookId) {
                bookArrayList.remove(bookArrayList.get(i));
            }
        }
        handleDisplay();
        System.out.println("Deleted Done !");
    }

    private static void handleSortByDecent() {
        System.out.println("Danh sách trước khi hiển thị: ");
        System.out.println("******************************");
        handleDisplay();
//        for (Book book : bookArrayList) {
//            book.getNumberOfPages();
//        }
//        dùng để so sánh int, double, float
        Collections.sort(bookArrayList);
        System.out.println("Danh sách sau khi hiển thị: ");
        System.out.println("****************************");
        handleDisplay();
        System.out.println("Sorted Done !");


//      dùng để so sánh String
//        bookArrayList.sort(new Comparator<Book>() {
//            @Override
//            public int compare(Book o1, Book o2) {
//                return (int) (o1.getInterest()-o2.getInterest());
//            }
//        });
    }

    private static void handleDisplay() {
        for (Book book : bookArrayList) {
            book.displayData();
        }
    }

    private static void handleAdd() {
        System.out.println("Nhập số lượng sách cần thêm mới: ");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            Book book = new Book();
            book.inputData();
            bookArrayList.add(book);
        }
        System.out.println("Add done !");
    }
}
