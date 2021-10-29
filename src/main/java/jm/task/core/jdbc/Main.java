package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        userServiceImpl.createUsersTable();

        userServiceImpl.saveUser("Mick","Jagger", (byte) 78);
        userServiceImpl.saveUser("Keith","Richards", (byte) 77);
        userServiceImpl.saveUser("Ronnie","Wood", (byte) 74);
        userServiceImpl.saveUser("Charlie","Watts", (byte) 80);

        List<User> users = userServiceImpl.getAllUsers();
        System.out.println(users);

        userServiceImpl.cleanUsersTable();

        userServiceImpl.dropUsersTable();
    }
}
