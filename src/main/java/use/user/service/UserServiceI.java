package use.user.service;

import java.util.List;
import java.util.Map;

import use.user.model.UserModel;

public interface UserServiceI {
    int insert(UserModel user);
    List<UserModel> idCheck(String id);
    List<UserModel> login(Map<String, String> map);
}
