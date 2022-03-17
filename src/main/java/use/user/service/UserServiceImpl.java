package use.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import use.user.dao.UserMapper;
import use.user.model.UserModel;

@Service
public class UserServiceImpl implements UserServiceI {

	@Autowired
	public UserMapper userMapper;

	public UserMapper getuserMapper() {
		return userMapper;
	}

	
	public void setuserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public int insert(UserModel user) {
		// TODO Auto-generated method stub
		return userMapper.insert(user);
	}

	public boolean idCheck(String id) {
		// TODO Auto-generated method stub
		return userMapper.idCheck(id);
	}

}
