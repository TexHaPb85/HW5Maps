package library;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<LibraryUser> users;


    public Library() {
        this.users = new ArrayList<>();
    }

    public void addUser(LibraryUser user) {
        users.add(user);
    }

    public LibraryUser getUserByName(String name) {
        return users.stream().filter(user -> user.getName().equals(name)).collect(Collectors.toList()).get(0);
    }


}
