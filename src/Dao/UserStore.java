package Dao;

import java.util.HashMap;
import java.util.Map;

import Dto.User;

public class UserStore {

	private static final Map<String, User> user_map_store = new HashMap<>();

	public static void userDetailsStore(String userName, String password, String email) {

		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setEmail(email);

		user_map_store.put(user.getUserName(), user); 

	}

	public static User getUser(String userName) {

		User user = user_map_store.get(userName); 

		if (user != null) {
			return user;
		}

		return null;
	}

}
  