package demo.service;

import demo.model.User;

public interface IUserService {
	User findUser(Integer id);

	User[] findUser(User user);

	int createUser(User user);
}
