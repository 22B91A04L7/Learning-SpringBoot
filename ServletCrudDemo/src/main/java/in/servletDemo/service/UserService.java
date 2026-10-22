package in.servletDemo.service;

import in.servletDemo.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    Map<Integer, User> userDB;

    public UserService(){
        userDB = new HashMap<>();
    }
    // to create new user
    public User createUser(User userReq){
        userDB.put(userReq.getId(), userReq);
        return userReq;
    }
    // fetch single user details using id
    public User getUserById(Integer id){
        User userRes = userDB.getOrDefault(id, null);
        return userRes;
    }

    public List<User> getAllUsers(){
       List<User> userResp = new ArrayList<>();
       for(User user : userDB.values()){
           userResp.add(user);
       }
        return userResp;
    }
}
