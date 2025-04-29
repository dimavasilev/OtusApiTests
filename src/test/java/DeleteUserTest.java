import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.http.*;
import org.junit.jupiter.api.*;
import service.PetStoreApiService;

public class DeleteUserTest {

  //Проверяем статус запрос при удаленеи не существующего пользователя(должен быть 404)
  @Test
  public void testDeleteNonExistingUser() {
    Response response;
    PetStoreApiService petStoreApiService = new PetStoreApiService();
    petStoreApiService.deleteUser("Sasg")
        .statusCode(HttpStatus.SC_NOT_FOUND);
  }
}