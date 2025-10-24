package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

   private final static String GET_USER_BY_CAR_MODEL_AND_SERIES = "SELECT u FROM User u JOIN u.car c WHERE c.model = :model AND c.series = :series";

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void saveUser(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override

   public List<User> getAllUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getUserByCarModelAndSeries(String model, int series) {
      Query<User> query = sessionFactory.getCurrentSession().createQuery(GET_USER_BY_CAR_MODEL_AND_SERIES, User.class);
      query.setParameter("model", model);
      query.setParameter("series", series);

      return query.uniqueResult();
   }

}
