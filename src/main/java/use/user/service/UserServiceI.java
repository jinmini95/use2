package use.user.service;

import use.user.model.UserModel;

public interface UserServiceI {
    int insert(UserModel user);
    boolean idCheck(String id);
}
