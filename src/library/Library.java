package library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<LibraryUser> users;

    public Library() {
        this.users = new ArrayList<>();
    }

    public void addUser(LibraryUser user) {
        users.add(user);
    }

    public LibraryUser getUserByName(String name) {
        return users.stream().filter(user -> user.getName().equals(name)).findFirst().get();
    }


}
