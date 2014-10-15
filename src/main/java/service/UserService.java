package service;


import java.io.IOException;
import java.util.Collection;
import java.util.List;

import model.User;
import utils.FileOperations;

import com.google.gson.JsonSyntaxException;


public class UserService {

    public Collection<User> getAllUsers() throws JsonSyntaxException, IOException {
        return FileOperations.readAllUsers();
    }

    public Collection<User> getUsersWithGivenItemsCost(long cost) throws JsonSyntaxException, IOException {
        return FileOperations. readAllUsersWithGivenItemsCost(cost);
    }

    public void saveUsers(List<User> users) {
        FileOperations.saveUser(users);
    }

    public void saveUser(User user) {
        FileOperations.saveUser(user);
    }

}
