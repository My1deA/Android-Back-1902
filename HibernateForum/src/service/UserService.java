package service;

import dao.UserDao;
import domain.User;

public class UserService {

	public void addUser(User user) {
		// TODO Auto-generated method stub
		UserDao userDao=new UserDao();
		userDao.addUser(user);
	}

}
