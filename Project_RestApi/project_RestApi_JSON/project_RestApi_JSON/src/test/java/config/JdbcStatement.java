package config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import lombok.SneakyThrows;

public class JdbcStatement extends JdbcConnection {

  private final Statement statement;

  @SneakyThrows
  public JdbcStatement() {
    this.statement = getJdbcConnection().createStatement();
  }

  @SneakyThrows
  public ResultSet getExecuteQuery(String query) {
    return statement.executeQuery(query);
  }

  @SneakyThrows
  public void getExecuteUpdate(String query) {
    statement.executeUpdate(query);
  }
//
//  private void closeStatement() throws SQLException {
//    statement.close();
//  }
}
