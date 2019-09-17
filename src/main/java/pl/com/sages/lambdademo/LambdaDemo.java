package pl.com.sages.lambdademo;

import java.util.Optional;
import java.util.function.Function;

public class LambdaDemo {
    public static void main(String[] args) {
        //System.out.println("Hello World");

        var book = new Book();
        book.setTitle("Dziady");
        System.out.println(extractTitleFromOptional(Optional.ofNullable(book)));

        Book noBook = null;
        System.out.println(extractTitleFromOptional(Optional.empty()));
        //var book = (Book)null;


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
        return optionalBook.map(Book::getTitle).orElse("Brak tytułu");
    }
}
