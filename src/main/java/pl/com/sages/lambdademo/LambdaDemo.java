package pl.com.sages.lambdademo;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaDemo {

    static private Function<Book, String> titleExtractor = new TitleExtractor();

    static private Function<Book, String> titleExtractor2 = new Function<Book, String>() {
        @Override
        public String apply(Book book) {
            return book.getTitle();
        }
    };

    static private Function<Book, String> titleExtractor3 = book -> {
        return book.getTitle();
    };

    static private Function<Book, String> titleExtractor4 = book -> book.getTitle();

    static private Function<Book, String> titleExtractor5 = Book::getTitle;

    static private Predicate<Book> titleChecker = new TitleChecker();

    static private Predicate<Book> titleChecker2 = new Predicate<Book>() {
        @Override
        public boolean test(Book book) {
            return book.getTitle() != null;
        }
    };

    static private Predicate<Book> titleChecker3 = book -> book.getTitle() != null;

    static private Predicate<Book> titleChecker4 = Book::checkTitle;

    static private Predicate<Book> titleChecker5 = BookChecker::checkTitle;


    public static void main(String[] args) {
        //System.out.println("Hello World");

        var book = new Book();
        book.setTitle("Dziady");
        System.out.println(extractTitle(book));

        Book noBook = null;
        System.out.println(extractTitle(noBook));
        //var book = (Book)null;

        var book2 = Book.builder().title("Wladca pierscieni").build();
        var title2 = titleExtractor.apply(book2);

        System.out.println(title2);

        var book3 = Book.builder().build();
        var book4 = Book.builder().title("Jakis tam").build();

        System.out.println(titleChecker5.test(book3));
        System.out.println(titleChecker5.test(book4));


    }

    public static String extractTitle(Book book) {
        if (book != null) {
            var title = book.getTitle();
            return title;
        } else {
            return "Brak tytułu";
        }
    }

    public static String extractTitleFromOptional(Optional<Book> optionalBook) {
        Optional<String> title = optionalBook.map(new Function<Book, String>() {
            @Override
            public String apply(Book book) {
                return book.getTitle();
            }
        });
        String extractedTitle = title.orElse("Brak tytułu");
        return extractedTitle;
    }
}

class TitleExtractor implements Function<Book, String> {
    @Override
    public String apply(Book book) {
        return book.getTitle();
    }
}

class TitleChecker implements Predicate<Book> {
    @Override
    public boolean test(Book book) {
        //return Objects.nonNull(book.getTitle());
        return book.getTitle() != null;
    }
}

class BookChecker {
    public static boolean checkTitle(Book book) {
        return book.getTitle() != null;
    }
}
