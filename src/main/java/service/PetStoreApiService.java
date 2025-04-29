package service;

import dto.UserDTO;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PetStoreApiService {
  private RequestSpecification requestSpecification;

  PetStoreApiService() {
    requestSpecification = given()
        .baseUri("http://localhost:8080/api")
        .basePath("/user")
        .contentType(ContentType.JSON)
        .log().all();
  }

  public ValidatableResponse createUser(UserDTO userDTO) {
    return given(requestSpecification)
        .when()
        .post()
        .then()
        .log().all();
  }
}
