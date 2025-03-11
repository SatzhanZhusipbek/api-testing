import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import epam.com.model.Address;
import epam.com.model.Company;
import epam.com.model.Geo;
import epam.com.model.User;
import epam.com.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

public class ApiTest {

  @Test
  @Execution(ExecutionMode.CONCURRENT)
  public void testGetUsersWithStatusCode() {
    UserService userService = new UserService();
    assertEquals(200, userService.getUsersStatusCode());
  }

  @Test
  @Execution(ExecutionMode.CONCURRENT)
  public void testGetUsersHeader() {
    UserService userService = new UserService();
    assertTrue(userService.headerExists("Content-Type"));
    assertEquals("application/json; charset=utf-8",
        userService.headerValue("Content-Type"));
  }

  @Test
  @Execution(ExecutionMode.CONCURRENT)
  public void testGetUsers() {
    UserService userService = new UserService();
    assertNotNull(userService.getUsers());
    assertEquals(10, userService.getUsers().size());
  }

  @Test
  @Execution(ExecutionMode.CONCURRENT)
  public void testGetUser() {
    UserService userService = new UserService();
    assertEquals(200, userService.getUser("1"));
  }

  @Test
  @Execution(ExecutionMode.CONCURRENT)
  public void testCreateUser() {
    UserService userService = new UserService();
    User user = new User("Jack Sparrow", "Jackster", "jack_sparrow@lam.com",
        new Address(), "(775)975-6594 x41207", "jackie.com", new Company());
    assertEquals(201, userService.createUser(user).getStatusCode());
    assertEquals("Jack Sparrow",
        userService.createUser(user).getBody().jsonPath().getString("name"));
  }

  @Test
  @Execution(ExecutionMode.CONCURRENT)
  public void testUpdateUser() {
    UserService userService = new UserService();
    User user = new User("Anastasia Howell", "Antonette", "Shanna@melissa.tv",
        new Address("Victor Plains", "Suite 879", "Wisokyburgh",
            "90566-7771", new Geo("-43.9509", "-34.4618")),
        "010-692-6593 x09125", "anastasia.net", new Company("Deckow-Crist",
        "Proactive didactic contingency", "synergize scalable supply-chains"));
    assertEquals(200, userService.updateUser(user, 2).getStatusCode());
    assertEquals("Anastasia Howell", userService.updateUser(user, 2).getBody()
    .jsonPath().getString("name"));
  }

  @Test
  @Execution(ExecutionMode.CONCURRENT)
  public void testDeleteUser() {
    UserService userService = new UserService();
    assertEquals(200, userService.deleteUser(10).getStatusCode());
  }

}
