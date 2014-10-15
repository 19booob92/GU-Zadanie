package modelTest;

import static org.junit.Assert.assertEquals;
import model.User;

import org.junit.Test;

public class UserModelTest {

	@Test
	public void shouldReturnUserWithIdAndName() {
		String userName = "name";

		User user = new User.UserBuilder().withName(userName).build();

		assertEquals(user.getName(), userName);
	}

	@Test
	public void shouldCreateUserWithValueOfItemsCostEqualsToZero() {
		User user = new User.UserBuilder().build();

		assertEquals(user.getAllProductsCost(), 0);
	}
	
	
	
}
