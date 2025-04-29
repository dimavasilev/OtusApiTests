import dto.UserDTO;
import org.apache.http.*;
import org.junit.jupiter.api.*;
import service.PetStoreApiService;

import static org.hamcrest.Matchers.*;

public class CreateUserTest {

  UserDTO userDTO = UserDTO.builder()
      .id(300)
      .lastName("lastName")
      .firstName("firstName")
      .phone("79999")
      .username("alex111")
      .password("password")
      .email("email@mail.ru")
      .userStatus(400)
      .build();

  UserDTO userExistingDTO = UserDTO.builder()
      .id(300)
      .lastName("string")
      .firstName("string")
      .phone("string")
      .username("string")
      .password("string")
      .email("string")
      .userStatus(0)
      .build();

  //Создание нового пользователя
  @Test
  public void testCreateNewUser() {
    PetStoreApiService petStoreApiService = new PetStoreApiService();
    petStoreApiService.createUser(userDTO)
        .statusCode(HttpStatus.SC_OK)
        .body("code", equalTo(200))
        .body("type", equalTo("unknown"))
        .body("message", equalTo("300"));
  }

  //Создание пользователя с данными уже существующщего полльзователя (пользователь успешно создан по правилам песочницы)
  @Test
  public void testCreateExistingUser() {
    PetStoreApiService petStoreApiService = new PetStoreApiService();
    petStoreApiService.createUser(userExistingDTO)
        .statusCode(HttpStatus.SC_OK)
        .body("code", equalTo(200))
        .body("type", equalTo("unknown"))
        .body("message", equalTo("300"));
  }
}
