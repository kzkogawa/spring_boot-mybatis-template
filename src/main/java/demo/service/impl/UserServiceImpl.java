package demo.service.impl;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.mapper.UserMapper;
import demo.model.User;
import demo.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	UserMapper userMapper;

	@Override
	public User findUser(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public User[] findUser(User user) {
		return userMapper.selectList(user, new RowBounds());
	}

	@Transactional
	@Override
	public int createUser(User user) {
		return userMapper.insert(user);
	}

}
