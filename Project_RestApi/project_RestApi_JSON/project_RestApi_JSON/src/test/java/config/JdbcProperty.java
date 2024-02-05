package config;


import lombok.Getter;

@Getter
public class JdbcProperty extends PropertyConfiguration {

  public final String url = getPropertiesConfiguration().getString("jdbc.url");
  public final String user = getPropertiesConfiguration().getString("jdbc.user");
  public final String password = getPropertiesConfiguration().getString("jdbc.password");

}
