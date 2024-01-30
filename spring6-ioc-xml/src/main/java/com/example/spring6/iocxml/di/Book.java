package com.example.spring6.iocxml.di;

public class Book {
    private String bookName;
    private String author;
    private String other;

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Book() {
        System.out.println("无参构造执行了。。。");
    }

    public Book(String bookName, String author) {
        System.out.println("有参构造执行了。。。");
        this.bookName = bookName;
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", other='" + other + '\'' +
                '}';
    }

    public static void main(String[] args) {
//        set注入
        Book book = new Book();
        book.setBookName("java");
        book.setAuthor("zhangsan");

//        构造器注入
        Book lisi = new Book("c++", "lisi");


    }
}
