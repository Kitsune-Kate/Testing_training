package test;

import static specification.Specification.apiProperty;
import static specification.Specification.installAllSpecification;

import config.JdbcStatement;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {

  public final JdbcStatement jdbcStatement = new JdbcStatement();

  @BeforeAll
  @SneakyThrows
  static void setUp() {
    RestAssured.baseURI = apiProperty.getBaseUri();
    RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    installAllSpecification();
  }

}
