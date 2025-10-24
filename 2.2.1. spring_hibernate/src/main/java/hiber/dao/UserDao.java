package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void saveUser(User user);
   List<User> getAllUsers();
   User getUserByCarModelAndSeries(String model, int series);
}
