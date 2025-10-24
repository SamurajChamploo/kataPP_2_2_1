package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    List<User> getAllUsers();
    User getUserByCarModelAndSeries(String model, int series);
}
