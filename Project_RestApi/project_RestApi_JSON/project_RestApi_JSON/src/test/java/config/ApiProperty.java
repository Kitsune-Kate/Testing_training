package config;

import lombok.Getter;

@Getter
public class ApiProperty extends PropertyConfiguration {

  public final String baseUri = getPropertiesConfiguration().getString("base.uri");
  public final String apiFood = getPropertiesConfiguration().getString("api.food");
  public final String apiDataReset = getPropertiesConfiguration().getString("api.data.reset");


}
