package use.user.dao;

import use.user.model.UserModel;
public interface UserMapper {
	    int insert(UserModel record);
	    boolean idCheck(String id);
}