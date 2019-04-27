package Service;

import Dao.UserDao;
import Model.UserItem;

public class UserService {
	public static boolean login(UserItem user) {
		return UserDao.login(user);
	}
	
	public static boolean register(UserItem user) {
		return UserDao.register(user);
	}
}
