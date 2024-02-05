package request;

import dto.Product;

public class RequestBody {
  public static Product getBody() {
    return Product.builder()
        .name("Маракуйя")
        .type("FRUIT")
        .exotic(true)
        .build();
  }
}
