package ra.bussinessImp;

import ra.bussiness.IBook;

import java.util.Scanner;

public class Book implements IBook ,Comparable<Book> {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean bookStatus;
    private static int count = 0;

    public Book() {
        this.bookId = count++;
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, float importPrice, float exportPrice, float interest, boolean bookStatus) {
        this.bookId = count++;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = getExportPrice()-getImportPrice();
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return this.exportPrice-this.importPrice;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Book.count = count;
    }

    @Override
    public void inputData() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập vào tên sách: ");
        this.bookName=scanner.nextLine();
        System.out.println("Nhập vào tiêu đề sách: ");
        this.title=scanner.nextLine();
        System.out.println("Nhập vào số trang sách: ");
        this.numberOfPages= Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào giá sách: ");
        this.importPrice= Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập vào giá bán: ");
        this.exportPrice= Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập vào trạng thái sách: ");
        this.bookStatus= Boolean.parseBoolean(scanner.nextLine());
    }


    @Override
    public void displayData() {
        System.out.println("Book Info: {" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", title='" + title + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                ", interest=" + interest +
                ", bookStatus=" + bookStatus +
                '}');
    }


    @Override
    public int compareTo(Book o) {
        return (int) (o.interest-this.interest);
    }


}
