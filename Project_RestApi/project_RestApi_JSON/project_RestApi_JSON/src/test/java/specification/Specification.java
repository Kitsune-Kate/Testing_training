package specification;

import config.ApiProperty;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

public class Specification {

    public static final ApiProperty apiProperty = new ApiProperty();
    private static final Cookies cookies = getCookies();


    private static Cookies getCookies() {
        return RestAssured.given()
                .when()
                .get(apiProperty.getApiFood())
                .getDetailedCookies();
    }

    private static RequestSpecification requestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(apiProperty.getBaseUri())
                .setContentType(ContentType.JSON)
                .addCookies(cookies)
                .build();
    }

    private static ResponseSpecification responseSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    public static void installAllSpecification() {
        RestAssured.requestSpecification = requestSpec();
        RestAssured.responseSpecification = responseSpec();
    }
}