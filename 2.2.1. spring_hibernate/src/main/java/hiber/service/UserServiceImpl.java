package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

   private final UserDao userDao;

   public UserServiceImpl(UserDao userDao) {
      this.userDao = userDao;
   }

   @Transactional
   @Override
   public void saveUser(User user) {
      userDao.saveUser(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> getAllUsers() {
      return userDao.getAllUsers();
   }

   @Transactional
   @Override
   public User getUserByCarModelAndSeries(String model, int series) {
      return userDao.getUserByCarModelAndSeries(model, series);
   }

}
