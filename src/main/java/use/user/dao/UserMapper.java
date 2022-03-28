package use.user.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import use.user.model.UserModel;

public interface UserMapper {
	    int insert(UserModel record);
	    List<UserModel> idCheck(String id);
	    List<UserModel> login(Map<String, String> map);
}