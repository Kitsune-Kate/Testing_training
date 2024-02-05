package test.api;

import static io.restassured.RestAssured.given;
import static specification.Specification.apiProperty;

import dto.Product;
import expected.ExpectedProductResponse;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import java.util.List;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import request.RequestBody;
import test.BaseTest;


public class QualitSandboxApiTest extends BaseTest {


  @BeforeEach
  void resetDatabase() {
    sendRequestToResetDatabaseTestData();
  }

  @Test
  @Tags({
      @Tag("api"),
      @Tag("products-list"),
  })
  @DisplayName("Проверка получения списка товаров")
  void testGetProducts() {
    Assertions.assertThat(getProductListFromResponse(sendGetRequest()))
        .usingRecursiveComparison()
        .isEqualTo(ExpectedProductResponse.getProductListFromJson());
  }


  @Test
  @Tags({
      @Tag("api"),
      @Tag("add-product"),
  })
  @DisplayName("Проверка тела ответа при добавлении нового товара через POST запрос")
  @SneakyThrows
  void testAddNewProduct() {
    List<Product> listBeforeAdd = getProductListFromResponse(sendGetRequest());

    sendPostRequest(RequestBody.getBody());

    Assertions.assertThat(getProductListFromResponse(sendGetRequest()))
        .usingRecursiveComparison()
        .isNotEqualTo(listBeforeAdd)
        .isEqualTo(ExpectedProductResponse.getProductListAfterAddFromJson());
  }



  //Сбросить тестовые данные в таблице
  public static void sendRequestToResetDatabaseTestData() {
    given()
        .post(apiProperty.getApiDataReset())
        .then()
        .statusCode(200)
        .extract();
  }

  //Отправить запрос GET /api/food
  private static ExtractableResponse<Response> sendGetRequest() {
    return given()
        .get("/api/food")
        .then()
        .statusCode(200)
        .extract();
  }

  //Отправить запрос POST /api/food
  private static void sendPostRequest(Product body) {
    given()
        .body(body)
        .when()
        .post("/api/food")
        .then()
        .statusCode(200)
        .extract();
  }

  //Получить преобразовать тело ответа в список Product
  private static List<Product> getProductListFromResponse(
      ExtractableResponse<Response> extractableResponse) {
    return extractableResponse.body().as(new TypeRef<>() {
    });
  }
}
