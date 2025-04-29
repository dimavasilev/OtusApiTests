import dto.UserDTO;
import org.apache.http.*;
import org.junit.jupiter.api.*;
import service.PetStoreApiService;

import static org.hamcrest.Matchers.*;

public class UpdateUserTest {

  UserDTO userDTO = UserDTO.builder()
      .id(300)
      .lastName("lastName")
      .firstName("firstName")
      .phone("79999")
      .username("alex")
      .password("password")
      .email("email@mail.ru")
      .userStatus(400)
      .build();

  UserDTO userUpdateDTO = UserDTO.builder()
      .id(300)
      .lastName("lastName")
      .firstName("firstNameUpdate")
      .phone("79999")
      .username("alex")
      .password("password")
      .email("email@mail.ru")
      .userStatus(400)
      .build();

  //DВыполняем обновление поля firstName  пользователя
  @Test
  public void testUpdateUserName() {
    PetStoreApiService petStoreApiService = new PetStoreApiService();
    petStoreApiService.updateUser(userUpdateDTO).statusCode(HttpStatus.SC_OK);
    Assertions.assertEquals("firstName",userUpdateDTO.getFirstName() ,"firstName обновлено");
  }
}
