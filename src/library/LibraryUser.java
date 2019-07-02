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

    public String getAllBooks() {
        return takenBooks.values().toString();
    }

    public String getAllDates() {
        return takenBooks.keySet().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
