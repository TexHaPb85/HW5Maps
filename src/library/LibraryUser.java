package library;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LibraryUser {
    private Map<Date, List<String>> takenBooks;
    private String name;

    public LibraryUser(String name) {
        this.takenBooks = new TreeMap<>();
        this.name = name;
    }

    public void takeBook(Date date, String book) {
        if (takenBooks.containsKey(date)) {
            List<String> list = takenBooks.get(date);
            list.add(book);
            takenBooks.put(date, list);
        } else {
            takenBooks.put(date, Stream.of(book).collect(Collectors.toList()));
        }
    }

    public String getBookByDate(Date date) {
        if (takenBooks.containsKey(date))
            return takenBooks.get(date).toString();
        return "You have not taken books at the date " + date.toString();
    }

    public void getAllBooks() {
        System.out.println("\nAll the taken books:");
        takenBooks.values().forEach(System.out::println);
    }

    public void getAllDates() {
        System.out.println("\nAll the dates of book taking:");
        takenBooks.keySet().forEach(System.out::println);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
