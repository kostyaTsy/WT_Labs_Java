package classes_and_objects.task15;

import classes_and_objects.task12.Book;

import java.util.Comparator;

public class AuthorComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getAuthor().compareToIgnoreCase(o2.getAuthor());
    }
}
