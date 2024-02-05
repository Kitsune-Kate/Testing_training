package config;

import lombok.Getter;
import lombok.SneakyThrows;
import org.apache.commons.configuration.PropertiesConfiguration;

@Getter
public class PropertyConfiguration {
  private final PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration();

  @SneakyThrows
  public PropertyConfiguration() {
    propertiesConfiguration.load("application.properties");
  }

}
