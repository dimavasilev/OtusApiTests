import dto.UserDTO;
import org.apache.http.*;
import org.junit.jupiter.api.*;
import service.PetStoreApiService;

public class UpdateUserTest {

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
    Assertions.assertEquals("firstName", userUpdateDTO.getFirstName(), "firstName обновлено");
  }
}
