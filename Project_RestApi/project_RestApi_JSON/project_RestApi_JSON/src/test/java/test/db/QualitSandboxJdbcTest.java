package test.db;

import static io.restassured.RestAssured.given;
import static test.api.QualitSandboxApiTest.sendRequestToResetDatabaseTestData;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import db.SqlScript;
import dto.Product;
import expected.ExpectedProductResponse;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import test.BaseTest;
import util.MapperResultSet;


public class QualitSandboxJdbcTest extends BaseTest {


  @BeforeEach
  void prepareDatabase() {
    sendRequestToResetDatabaseTestData();
  }


  @Test
  @Tags({
      @Tag("db"),
      @Tag("products-list"),
  })
  @DisplayName("Проверка получения списка товаров из базы данных")
  void testGetProductsFromDatabase() {
    ResultSet resultSet = jdbcStatement.getExecuteQuery(SqlScript.getSelectAllProducts());

    Assertions.assertThat(MapperResultSet.getProductListFromResultSet(resultSet))
        .usingRecursiveComparison()
        .isEqualTo(ExpectedProductResponse.getProductListFromJson());
  }

}
