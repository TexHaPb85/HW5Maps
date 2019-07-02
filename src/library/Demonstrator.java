package library;

import java.util.Date;
import java.util.Scanner;

public class Demonstrator {
    public void libaryWorkDemo() {
        Library library = new Library();
        library.addUser(new LibraryUser("Mike"));

        library.getUserByName("Mike").takeBook(new Date(99, 6, 5), "Gamlet");
        library.getUserByName("Mike").takeBook(new Date(99, 6, 5), "Harry Potter");
        library.getUserByName("Mike").takeBook(new Date(99, 6, 6), "The Song of ice and fire");
        library.getUserByName("Mike").takeBook(new Date(99, 6, 7), "The Lord of the Ring");
        String ifContinue;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println(library.getUserByName("Mike").getBookByDate(enterDate(sc)) +
                    "\nDo you want to check one more date(yes/no)");
            ifContinue = sc.next();
        } while (ifContinue.equals("yes"));


        System.out.println("All the taken books:\n" + library.getUserByName("Mike").getAllBooks());
        System.out.println("All the dates of book taking:\n" + library.getUserByName("Mike").getAllDates());
    }

    public Date enterDate(Scanner sc) {
        System.out.println("Enter day");
        int day = sc.nextInt();
        System.out.println("Enter month");
        int month = sc.nextInt();
        System.out.println("Enter year");
        int year = sc.nextInt();
        return new Date(year, month, day);
    }
}
