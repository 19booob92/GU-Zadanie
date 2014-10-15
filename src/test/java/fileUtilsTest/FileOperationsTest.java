package fileUtilsTest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import model.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utils.FileOperations;

import com.google.gson.JsonSyntaxException;

import factory.UserFactory;


public class FileOperationsTest {

    protected UserFactory userFactory = new UserFactory();
    
    @Before
    public void init() {
        FileOperations.deleteAllUsers();
    }

    @After
    public void tearsDown() {
        FileOperations.deleteAllUsers();
    }


    @Test
    public void shouldSaveFileOnDisk() throws JsonSyntaxException, IOException {

        User user = new User.UserBuilder()
                .withAllProductsCost(2L)
                .build();

        FileOperations.saveUser(user);
        List<User> users = FileOperations.readAllUsers();
        User firstUser = users.get(0);

        assertEquals(users.size(), 1);
        assertEquals(firstUser.getAllProductsCost(), 2L);
    }

    @Test
    public void shouldNotThrowJsonSyntaxException() throws JsonSyntaxException, IOException {

        User user = new User.UserBuilder()
                .withAllProductsCost(2L)
                .withSurname("\"{id : 'a'\"}")
                .build();

        FileOperations.saveUser(user);
        FileOperations.readAllUsers();
    }

    @Test
    public void shouldReadAllUsersWithGivenItemsCost() throws JsonSyntaxException, IOException {
        
        List<User> users = userFactory.getDefaultUsers();

        FileOperations.saveUser(users);
        List<User> usersWithOrders = FileOperations.readAllUsersWithGivenItemsCost(3L);
        
        assertEquals(2, usersWithOrders.size());
    }


}
