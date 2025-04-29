package service;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserApi {
  public static final String BASE_URL = "https://petstore.swagger.io/v2/";

  private RequestSpecification specification;

  private static final String USER = "/user";

  public UserApi(){
    specification = given()
        .baseUri(BASE_URL)
        .contentType(ContentType.JSON);
  }
}
