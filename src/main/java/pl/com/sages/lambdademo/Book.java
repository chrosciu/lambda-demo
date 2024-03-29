package pl.com.sages.lambdademo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int year;
    private int rate;

    public boolean checkTitle() {
        return title != null;
    }
}
