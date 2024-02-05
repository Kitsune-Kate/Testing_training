package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import lombok.SneakyThrows;
import org.h2.Driver;

public class JdbcConnection {

  private final JdbcProperty jdbcProperty = new JdbcProperty();

//  @SneakyThrows
//  public void registerDriver() {
//    DriverManager.registerDriver(new Driver());
//  }

  @SneakyThrows
  public Connection getJdbcConnection() {
    return DriverManager.getConnection(
        jdbcProperty.getUrl(),
        jdbcProperty.getUser(),
        jdbcProperty.getPassword()
    );
  }

//  @SneakyThrows
//  public void closeJdbcConnection() {
//    connection.close();
//  }




}
