package expected;

import dto.Product;
import java.util.List;
import util.MapperJson;

public class ExpectedProductResponse extends MapperJson {

  public static List<Product> getProductListFromJson() {
    return readExpectedProductResponse("src/test/resources/product-list.json");
  }

  public static List<Product> getProductListForIntegrationFromJson() {
    return readExpectedProductResponse("src/test/resources/product-list-for-integration-test.json");
  }

  public static List<Product> getProductListAfterAddFromJson() {
    return readExpectedProductResponse("src/test/resources/product-list-after-add.json");
  }
}
