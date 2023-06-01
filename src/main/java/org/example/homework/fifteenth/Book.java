package org.example.homework.fifteenth;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@Getter
@ToString
public class Book{
    private int year;
    private String author;
    private String bookName;

    public int compareToYear(Book book) {
        return Integer.compare(year, book.getYear());
    }

    public char getFirstLetter(){
        return bookName.charAt(0);
    }

}
