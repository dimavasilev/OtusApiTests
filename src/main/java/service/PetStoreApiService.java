package service;

import dto.UserDTO;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PetStoreApiService {
  private RequestSpecification requestSpecification;

  public PetStoreApiService() {
    requestSpecification = given()
        .baseUri(System.getProperty("base.url"))
        .contentType(ContentType.JSON)
        .log().all();
  }

  public ValidatableResponse createUser(UserDTO userDTO) {
    return given(requestSpecification)
        .body(userDTO)
        .basePath("/user")
        .when()
        .post()
        .then()
        .log().all();
  }

  public ValidatableResponse deleteUser(String user) {
    return given(requestSpecification)
        .basePath("/user")
        .pathParam("username", user)
        .when()
        .delete("/{username}")
        .then()
        .log().all();
  }


  public ValidatableResponse updateUser(UserDTO userDTO){
    return given(requestSpecification)
        .when()
        .put("/{username}", userDTO.getUsername())
        .then()
        .log().all();
  }
}
