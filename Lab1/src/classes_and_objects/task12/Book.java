package classes_and_objects.task12;

import java.util.Objects;

public class Book implements Comparable<Book> {
    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getPrice() {
        return this.price;
    }

    public Book() {
    }

    public Book(String title, String author, int price, Integer isbn) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            boolean isTitlesEquals = Objects.equals(this.title, ((Book) obj).title);
            boolean isAuthorsEquals = Objects.equals(this.author, ((Book) obj).author);
            boolean isPricesEquals = this.price == ((Book) obj).price;
            return isTitlesEquals && isAuthorsEquals && isPricesEquals;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.price + this.title.hashCode() + this.author.hashCode() + Book.edition;
    }

    @Override
    public String toString() {
        return "Title: " + this.title + " Author: " + this.author + " Price: " + this.price + " Edition: " + Book.edition;
    }

    @Override
    public Object clone() {
        Book book = new Book(this.title, this.author, this.price, this.isbn);
        return book;
    }

    @Override
    public int compareTo(Book o) {
        return Integer.compare(this.isbn, o.isbn);
    }

    private String title;
    private String author;
    private int price;
    private static int edition;
    private int isbn;
}
