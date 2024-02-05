package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@Builder
@NoArgsConstructor
public class Product {

  private String name;
  private String type;
  private boolean exotic;


  @Override
  public String toString() {
    return "{name=" + name + ", type=" + type + ", exotic=" + exotic + "}";
  }

}
