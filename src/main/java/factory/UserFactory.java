package factory;


import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserFactory {

	public List<User> getDefaultUsers() {

		List<User> users = new ArrayList<>();

		User defaultUser = new User.UserBuilder().withName("Jan")
				.withSurname("Kowalski")
				.withAddress(null).build();

		User defaultUser2 = new User.UserBuilder().withName("Jan")
				.withSurname("Kowalski")
				.withAllProductsCost(7L)
				.withAddress(null)
				.build();

		User defaultUser3 = new User.UserBuilder().withName("Jan")
				.withSurname("Kowalski")
				.withAllProductsCost(5L)
				.build();

		users.add(defaultUser);
		users.add(defaultUser2);
		users.add(defaultUser3);

		return users;
	}

}
