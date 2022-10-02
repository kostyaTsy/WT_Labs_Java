package classes_and_objects.task12;

import classes_and_objects.task15.AuthorComparator;
import classes_and_objects.task15.PriceComparator;
import classes_and_objects.task15.TitleComparator;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Book1", "Auth1", 45, 2));
        books.add(new Book("book12", "auth12", 88, 1));
        books.add(new Book("Book3", "Auth3", 30, 4));
        books.add(new Book("Book21", "Auth21", 65, 10));
        books.add(new Book("Book2", "Auth2", 15, 12));
        books.add(new Book("BBook1", "aaAuth1", 2, 3));

        ArrayList<Comparator<Book>> comparators = new ArrayList<Comparator<Book>>();
        comparators.add(new TitleComparator());
        comparators.add((new TitleComparator()).thenComparing(new AuthorComparator()));
        comparators.add((new AuthorComparator()).thenComparing(new TitleComparator()));
        comparators.add(((new AuthorComparator()).thenComparing(new TitleComparator())).thenComparing(new PriceComparator()));

        for (Comparator<Book> comparator: comparators) {
            books.sort(comparator);
            System.out.println("\nSorted array of books: ");
            for (Book book: books) {
                System.out.println(book.toString());
            }
        }
    }
}
