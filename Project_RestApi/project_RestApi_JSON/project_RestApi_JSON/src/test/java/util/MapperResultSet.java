package util;

import dto.Product;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import lombok.SneakyThrows;

public class MapperResultSet {

  private static final List<Product> listFormDatabase = new ArrayList<>();

  @SneakyThrows
  public static List<Product> getProductListFromResultSet(ResultSet resultSet) {

    while (resultSet.next()) {
      listFormDatabase.add(Product.builder()
          .name(resultSet.getString("food_name"))
          .type(resultSet.getString("food_type"))
          .exotic(resultSet.getBoolean("food_exotic"))
          .build()
      );
    }

    return listFormDatabase;
  }


}
