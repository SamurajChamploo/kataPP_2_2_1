package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("Model A", 123);
      Car car2 = new Car("Model B", 456);
      Car car3 = new Car("Model C", 132);
      Car car4 = new Car("Model D", 546);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");

      car1.setUser(user1);
      user1.setCar(car1);
      car2.setUser(user2);
      user2.setCar(car2);
      car3.setUser(user3);
      user3.setCar(car3);
      car4.setUser(user4);
      user4.setCar(car4);

      userService.saveUser(user1);
      userService.saveUser(user2);
      userService.saveUser(user3);
      userService.saveUser(user4);

      List<User> users = userService.getAllUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car Model = "+user.getCar().getModel());
         System.out.println("Car Series = "+user.getCar().getSeries());
         System.out.println();
      }

      System.out.println(userService.getUserByCarModelAndSeries(car1.getModel(), car1.getSeries()));

      context.close();
   }
}
