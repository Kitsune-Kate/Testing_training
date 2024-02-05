package test.integration;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static specification.Specification.apiProperty;

import dto.Product;
import expected.ExpectedProductResponse;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import java.sql.ResultSet;
import java.util.List;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import test.BaseTest;
import util.MapperResultSet;

public class QualitSandboxIntegrationTest extends BaseTest {


  @BeforeEach
  void prepareDatabase() {
//    jdbcStatement.getExecuteUpdate(SqlScript.getInsertProduct());
    getExecuteUpdateTruncateTableFood();
    sendRequestToResetDatabaseTestData();
  }


  @AfterEach
  void tearDown() {
//    jdbcConnection.closeJdbcConnection();
  }


  @Test
  @Tags({
      @Tag("integration"),
      @Tag("add-product"),
  })
  @DisplayName("Проверка сохранения нового товара в БД через POST запрос")
  @SneakyThrows
  void testAddNewProduct() {


    List<Product> expectedList = ExpectedProductResponse.getProductListForIntegrationFromJson();

    sendPostRequest(Product.builder()
        .name("Супер-фрукт")
        .type("FRUIT")
        .exotic(true)
        .build());

    List<Product> listFromDatabase = getListProductFromResultSet(getExecuteQuerySelectAllFood());

    checkEqualsExpectedListAndDatabaseList(expectedList, listFromDatabase);
  }

  //Проверка ожидаемого соответствия списка товаров
private void checkEqualsExpectedListAndDatabaseList(List<Product> expectedList,
    List<Product> listFromDatabase) {
  Assertions.assertThat(listFromDatabase)
      .usingRecursiveComparison()
      .isEqualTo(expectedList);
}

  //Преобразовать данные из ResultSet в список Product
  private static List<Product> getListProductFromResultSet(ResultSet resultSet) {
    return MapperResultSet.getProductListFromResultSet(resultSet);
  }

  //Выбор всех продуктов из БД
  private ResultSet getExecuteQuerySelectAllFood() {
    return jdbcStatement.getExecuteQuery("SELECT * FROM FOOD");
  }

  //Очистить таблицу
  private void getExecuteUpdateTruncateTableFood() {
    jdbcStatement.getExecuteUpdate("truncate table food");
  }

  //Получить из запроса тело и преобразовать в список Product
  private static List<Product> getProductListFromResponse(
      ExtractableResponse<Response> extractableResponse) {
    return extractableResponse.body().as(new TypeRef<>() {
    });
  }

  //Отправить GET запрос /api/food для получения списка продуктов
  private static ExtractableResponse<Response> sendGetRequest() {
    return given()
        .when()
        .get("/api/food")
        .then()
        .statusCode(200)
        .extract();
  }

  //Отправить POST запрос /api/food для добавления продукта
  private static void sendPostRequest(Product body) {
    given()
        .body(body)
        .when()
        .post("/api/food")
        .then()
        .statusCode(200)
        .extract();
  }

  //Отправить запрос /api/data/reset для сброса БД к базовому состоянию
  private static void sendRequestToResetDatabaseTestData() {
    given()
        .post(apiProperty.getApiDataReset())
        .then()
        .statusCode(200)
        .extract();
  }


}
