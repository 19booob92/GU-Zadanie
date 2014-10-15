package serviceTest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.google.gson.JsonSyntaxException;

import service.UserService;
import utils.FileOperations;


@RunWith(PowerMockRunner.class)
@PrepareForTest(FileOperations.class)
public class UserServiceTest {

    UserService service;

    @Before
    public void init() {
        service = new UserService();
    }

    @Test
    public void shouldReturnCollectionWithFiveItems() throws JsonSyntaxException, IOException {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            users.add(new User.UserBuilder().build());
        }
        PowerMockito.mockStatic(FileOperations.class);
        Mockito.when(FileOperations.readAllUsers()).thenReturn(users);

        List<User> returnedList = (List<User>) service.getAllUsers();

        assertEquals(5, returnedList.size());
    }
    
    @Test
    public void shouldReturnCollectionWithUsersWithOrders() throws JsonSyntaxException, IOException {
        PowerMockito.mockStatic(FileOperations.class);
        Mockito.when(FileOperations.readAllUsersWithGivenItemsCost(Mockito.anyLong())).thenReturn(null);
        
        List<User> returnedList = (List<User>) service.getUsersWithGivenItemsCost(2);

        PowerMockito.verifyStatic();
    }
    
    @Test(expected = IOException.class)
    public void shouldThrowsException() throws JsonSyntaxException, IOException {
        PowerMockito.mockStatic(FileOperations.class);
        Mockito.when(FileOperations.readAllUsersWithGivenItemsCost(Mockito.anyLong())).thenThrow(new IOException());
        
        List<User> returnedList = (List<User>) service.getUsersWithGivenItemsCost(2L);
    }
}
