package epam.com.services;

import static io.restassured.RestAssured.given;

import epam.com.Endpoints;
import epam.com.model.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.List;

public class UserService {

  public int getUsersStatusCode() {
    Response response = given()
        .when()
        .get(Endpoints.BASE_URL+Endpoints.USERS);
    return response.getStatusCode();
  }

  public Boolean headerExists(String headerName) {
    Response response = given()
        .when()
        .get(Endpoints.BASE_URL+Endpoints.USERS);
    return response.getHeaders().hasHeaderWithName(headerName);
  }

  public String headerValue(String headerName) {
    Response response = given()
        .when()
        .get(Endpoints.BASE_URL+Endpoints.USERS);
    return response.getHeader(headerName);
  }

  public List<User> getUsers() {
    Response response = given()
        .when()
        .get(Endpoints.BASE_URL+Endpoints.USERS);
    return List.of(response.getBody().as(User[].class));
  }

  public int getUser(String userId) {
    Response response = given()
        .pathParam("id", userId)
        .when()
        .get(Endpoints.BASE_URL+Endpoints.USERS+Endpoints.ID);
    return response.getStatusCode();
  }

  public Response createUser(User user) {
    Response response = given()
        .contentType(ContentType.JSON)
        .body(user)
        .when()
        .post(Endpoints.BASE_URL+Endpoints.USERS);
    return response;
  }

  public Response updateUser(User user, int userId) {
    Response response = given()
        .pathParam("id", userId)
        .contentType(ContentType.JSON)
        .body(user)
        .when()
        .put(Endpoints.BASE_URL+Endpoints.USERS+Endpoints.ID);
    return response;
  }

  public Response deleteUser(int userId) {
    Response response = given()
        .pathParam("id", userId)
        .when()
        .delete(Endpoints.BASE_URL+Endpoints.USERS+Endpoints.ID);
    return response;
  }
}
