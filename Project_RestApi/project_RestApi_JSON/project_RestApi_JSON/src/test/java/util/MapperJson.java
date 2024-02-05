package util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.Product;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import lombok.SneakyThrows;

public class MapperJson {

  private final static ObjectMapper objectMapper = new ObjectMapper();


  //TODO: make one generic method to read from file

  @SneakyThrows
  public static String readSqlFile(String path) {
    return objectMapper.readValue(Files.readString(Paths.get(path), StandardCharsets.UTF_8),
        String.class);
  }

  @SneakyThrows
  public static List<Product> readExpectedProductResponse(String path) {
    return objectMapper.readValue(Files.readString(
        Paths.get(path), StandardCharsets.UTF_8), new TypeReference<List<Product>>() {
    });
  }

}
