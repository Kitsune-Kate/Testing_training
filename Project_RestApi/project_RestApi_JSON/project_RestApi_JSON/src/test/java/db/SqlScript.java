package db;

import util.MapperJson;

public class SqlScript extends MapperJson {

  //TODO: fix, readSqlFile() not working

  public static String getInsertProduct() {
    return "insert into food(food_name, food_type, food_exotic) values ('Суперфрукт', 'FRUIT', true);";
//    return readSqlFile("src/test/resources/add-product.sql");
  }

  public static String getSelectAllProducts() {
    return "SELECT * FROM FOOD";
//    return readSqlFile("src/test/resources/select-all-products.sql");
  }

}
