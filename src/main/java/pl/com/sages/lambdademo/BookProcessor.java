package pl.com.sages.lambdademo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookProcessor {

    //extract titles longer than 10 characters
    public static List<String> extractLongTitlesFromBooks(List<Book> books) {
        var titles = new ArrayList<String>();
        /*
        for (var i = 0; i < books.size(); ++i) {
            //
        }
        */
        for (var book: books) {
            if (book !=null) {
                var title = book.getTitle();
                if (title != null) {
                    var length = title.length();
                    if (length > 10) {
                        titles.add(title);
                    }
                }
            }
        }
        return titles;
    }

    public static List<String> extractLongTitlesFromBooksByStream(List<Book> books) {
        Stream<Book> booksStream = books.stream();
        Stream<Book> existingBooksStream = booksStream.filter(new Predicate<Book>() {
            @Override
            public boolean test(Book book) {
                return book != null;
            }
        });
        Stream<String> titlesStream = existingBooksStream.map(new Function<Book, String>() {
            @Override
            public String apply(Book book) {
                return book.getTitle();
            }
        });
        Stream<String> existingTitlesStream = titlesStream.filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s != null;
            }
        });
        Stream<String> longTitlesStream = existingTitlesStream.filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 10;
            }
        });
        List<String> titles = longTitlesStream.collect(Collectors.toList());
        return titles;
    }

    public static List<String> extractLongTitlesFromBooksByStream2(List<Book> books) {
        Stream<Book> booksStream = books.stream();
        Stream<Book> existingBooksStream = booksStream.filter(book -> book != null);
        Stream<String> titlesStream = existingBooksStream.map(Book::getTitle);
        Stream<String> existingTitlesStream = titlesStream.filter(s -> s != null);
        Stream<String> longTitlesStream = existingTitlesStream.filter(s -> s.length() > 10);
        List<String> titles = longTitlesStream.collect(Collectors.toList());
        return titles;
    }

    public static List<String> extractLongTitlesFromBooksByStream3(List<Book> books) {
        Stream<Book> booksStream = books.stream();
        Stream<Book> existingBooksStream = booksStream.filter(Objects::nonNull);
        Stream<String> titlesStream = existingBooksStream.map(Book::getTitle);
        Stream<String> existingTitlesStream = titlesStream.filter(Objects::nonNull);
        Stream<String> longTitlesStream = existingTitlesStream.filter(s -> s.length() > 10);
        List<String> titles = longTitlesStream.collect(Collectors.toList());
        return titles;
    }

    public static List<String> extractLongTitlesFromBooksByStream4(List<Book> books) {
        return books.stream()
        .filter(Objects::nonNull)
        .map(Book::getTitle)
        .filter(Objects::nonNull)
        .filter(s -> s.length() > 10)
        .collect(Collectors.toList());
    }

    //prepare list of books descriptions (can use @ToString on book) but discard books with no author or no title
    public static List<String> prepareBookDescriptions(List<Book> books) {
        return null;
    }
}
