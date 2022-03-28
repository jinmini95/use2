package use.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import use.user.dao.UserMapper;
import use.user.model.UserModel;

@Service
public class UserServiceImpl implements UserServiceI {

	
	public UserMapper userMapper;
	@Autowired
	public UserServiceImpl(UserMapper userMapper) { this.userMapper = userMapper; }


	@Override
	public int insert(UserModel user) {
		// TODO Auto-generated method stub
		return userMapper.insert(user);
	}

	@Override
	public List<UserModel> idCheck(String id) {
		// TODO Auto-generated method stub
		return userMapper.idCheck(id);
	}
	@Override
	public List<UserModel> login(Map<String, String> map) {
		List<UserModel> mol = userMapper.login(map);
		return mol;
	}
}
